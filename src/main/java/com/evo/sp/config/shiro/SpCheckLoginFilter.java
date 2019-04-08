package com.evo.sp.config.shiro;


import com.alibaba.fastjson.JSON;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.HttpMethodPermissionFilter;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 * 过滤器
 * </p>
 *
 * @author sgt
 * @since 2019-04-04 14:15
 */
public class SpCheckLoginFilter extends HttpMethodPermissionFilter {

    /**
     * 是否允许继续访问
     */
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        //设置登陆路径
        setLoginUrl(SpConstantInter.SYSTEM_USER + SpConstantInter.SYSTEM_USER_LOGIN);
        //判断当前请求是否是登陆请求或注销请求
        if (!isLoginRequest(request, response)) {
            HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
            HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
            String id = httpServletRequest.getSession().getId();
            //是否已登陆
            if (isAuthenticated(id, httpServletRequest,httpServletResponse)) {
                //是否已授权
               return super.isAccessAllowed(request,response,mappedValue);
            } else {
                httpServletResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * 访问被拒绝
     **/
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        int status = httpServletResponse.getStatus();
            //未登录
        if (status == HttpServletResponse.SC_ACCEPTED) {
            Result result = new Result(false, ResultEnum.LOGIN_HELP.getValue(), ResultEnum.LOGIN_HELP.getName());
            httpServletResponse.setCharacterEncoding(SpConstantInter.CHARACTER_ENCODING);
            httpServletResponse.getWriter().write(JSON.toJSONString(result));

        }
            //未授权
//        else if (status == HttpServletResponse.SC_UNAUTHORIZED) {
//            Result result = new Result(false, ResultEnum.PERMISSION_UNAUTHORIZED.getValue(), ResultEnum.PERMISSION_UNAUTHORIZED.getName());
//            httpServletResponse.setCharacterEncoding(SpConstantInter.CHARACTER_ENCODING);
//            httpServletResponse.getWriter().write(JSON.toJSONString(result));
//        }
        return false;
    }

    @Override
    public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return super.onPreHandle(request, response, mappedValue);
    }

    /**
     * @Description:是否已登陆
     * @Author: sgt
     * @Date: 2019/4/5
     */
    public boolean isAuthenticated(String sessionID, HttpServletRequest request, HttpServletResponse response) throws IOException {
        boolean status = false;
        SessionKey key = new WebSessionKey(sessionID, request, response);
        try {
            Session se = SecurityUtils.getSecurityManager().getSession(key);
            Object obj = se.getAttribute(DefaultSubjectContext.AUTHENTICATED_SESSION_KEY);
            if (obj != null) {
                status = (Boolean) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Session se = null;
            Object obj = null;
        }
        return status;
    }

    /**
     * @Description:当前请求是否已经授权
     * @Author: sgt
     * @Date: 2019/4/5
     */
    public boolean isAuthorization(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Subject subject = getSubject(request, response);
        // If the subject isn't identified, redirect to login URL
        if (subject.getPrincipal() == null) {
            saveRequestAndRedirectToLogin(request, response);
        } else {
            // If subject is known but not authorized, redirect to the unauthorized URL if there is one
            // If no unauthorized URL is specified, just return an unauthorized HTTP status code
            String unauthorizedUrl = getUnauthorizedUrl();
            //SHIRO-142 - ensure that redirect _or_ error code occurs - both cannot happen due to response commit:
            if (StringUtils.hasText(unauthorizedUrl)) {
                //WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                WebUtils.toHttp(response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return false;
    }

    /**
    * @Description:是否是注销请求
    * @Author: sgt
    * @Date:  2019/4/5
    */
    public boolean isLoginOutRequest(ServletRequest request){
        return pathsMatch(SpConstantInter.SYSTEM_USER + SpConstantInter.SYSTEM_USER_LOGIN_OUT, request);
    }

}
