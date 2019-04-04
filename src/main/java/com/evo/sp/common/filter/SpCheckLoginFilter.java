package com.evo.sp.common.filter;


import com.evo.sp.common.SpAssert;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.ex.SpParameterException;
import com.evo.sp.common.ex.SpSessionException;
import com.evo.sp.common.result.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  过滤器
 * </p>
 *
 * @author sgt
 * @since 2019-04-04 14:15
 */
public class SpCheckLoginFilter extends AccessControlFilter {

    /**
     * Returns <code>true</code> if the request is allowed to proceed through the filter normally, or <code>false</code>
     * if the request should be handled by the
     * {@link #onAccessDenied(ServletRequest, ServletResponse, Object) onAccessDenied(request,response,mappedValue)}
     * method instead.
     *
     * @param request     the incoming <code>ServletRequest</code>
     * @param response    the outgoing <code>ServletResponse</code>
     * @param mappedValue the filter-specific config value mapped to this filter in the URL rules mappings.
     * @return <code>true</code> if the request should proceed through the filter normally, <code>false</code> if the
     * request should be processed by this filter's
     * {@link #onAccessDenied(ServletRequest, ServletResponse, Object)} method instead.
     * @throws Exception if an error occurs during processing.
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("isAccessAllowed："+mappedValue);
        return false;
    }

    /**
     * Processes requests where the subject was denied access as determined by the
     * {@link #isAccessAllowed(ServletRequest, ServletResponse, Object) isAccessAllowed}
     * method.
     *
     * @param request  the incoming <code>ServletRequest</code>
     * @param response the outgoing <code>ServletResponse</code>
     * @return <code>true</code> if the request should continue to be processed; false if the subclass will
     * handle/render the response directly.
     * @throws Exception if there is an error processing the request.
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("onAccessDenied：");
        Subject subject = getSubject(request, response);
        Session session = subject.getSession(false);
        if (!SpAssert.isNotNull(session)) {
               throw new SpParameterException(ResultEnum.SESSION_IS_NULL.getValue(),ResultEnum.SESSION_IS_NULL.getName());
        }
        return true;
    }

    /**
     * Returns <code>true</code> if
     * {@link #isAccessAllowed(ServletRequest, ServletResponse, Object) isAccessAllowed(Request,Response,Object)},
     * otherwise returns the result of
     * {@link #onAccessDenied(ServletRequest, ServletResponse, Object) onAccessDenied(Request,Response,Object)}.
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return <code>true</code> if
     * {@link #isAccessAllowed(ServletRequest, ServletResponse, Object) isAccessAllowed},
     * otherwise returns the result of
     * {@link #onAccessDenied(ServletRequest, ServletResponse) onAccessDenied}.
     * @throws Exception if an error occurs.
     */
    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        if (isAuthenticated(subject.getSession().getId().toString(),(HttpServletRequest) request,(HttpServletResponse) response)) {
            return super.onPreHandle(request, response, mappedValue);
        }
        return false;
    }


    public boolean isAuthenticated(String sessionID, HttpServletRequest request, HttpServletResponse response){
        boolean status = false;

        SessionKey key = new WebSessionKey(sessionID,request,response);
        try{
            Session se = SecurityUtils.getSecurityManager().getSession(key);
            Object obj = se.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
            if(obj != null){
                status = (Boolean) obj;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            Session se = null;
            Object obj = null;
        }
        response.setStatus(123);
        return status;
    }

}
