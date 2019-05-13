package com.evo.sp.config.shiro;

import com.alibaba.fastjson.JSON;
import com.evo.sp.common.SpConstantInter;
import com.evo.sp.common.result.Result;
import com.evo.sp.common.result.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-04-30 14:40
 */
@SuppressWarnings("all")
public class SpPathFilter extends FormAuthenticationFilter {

    /**s
     * 是否允许继续访问
     */
    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //设置登陆路径
        setLoginUrl(SpConstantInter.SYS_USER + SpConstantInter.SYS_USER_LOGIN);
        //判断当前请求是否是登陆请求或注销请求
        if (!isLoginRequest(request, response)) {
            HttpServletRequest httpServletRequest = WebUtils.toHttp(request);
            HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
            String id = httpServletRequest.getSession().getId();
            //是否已登陆
            try {
                if (isAuthenticated(id, httpServletRequest, httpServletResponse)) {
                    //是否已授权
                    return super.isAccessAllowed(request, response, mappedValue);
                } else {
                    httpServletResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    /**
     * @Description:是否已登陆
     * @Author: sgt
     * @Date: 2019/4/5
     */
    public boolean isAuthenticated(String sessionID, HttpServletRequest request, HttpServletResponse response) throws
            IOException {
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

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        int status = httpServletResponse.getStatus();
        //未登录
        if (status == HttpServletResponse.SC_ACCEPTED) {
            Result result = new Result(false, ResultEnum.LOGIN_HELP.getValue(), ResultEnum.LOGIN_HELP.getName());
            httpServletResponse.setCharacterEncoding(SpConstantInter.CHARACTER_ENCODING);
            httpServletResponse.getWriter().write(JSON.toJSONString(result));
        }
        return false;
    }
}
