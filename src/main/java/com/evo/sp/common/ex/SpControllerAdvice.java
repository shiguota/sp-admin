package com.evo.sp.common.ex;


import com.evo.sp.common.result.ResultEnum;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:全局异常捕获类
 * @Author: sgt
 * @Date: 2019-03-29
 */

@ControllerAdvice
public class SpControllerAdvice {

    private static final String EXCEPTION_CODE = "code";
    private static final String EXCEPTION_MSG = "msg";
    private static final String EXCEPTION_DATA = "data";
    private static final String EXCEPTION_MSG_DETAIL = "msg_detail";

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map ExceptionHandler(Exception ex) {
        Map map = new HashMap();
        if (ex instanceof SpParameterException) {//参数错误
            SpParameterException spParameterException = (SpParameterException) ex;
            map.put(EXCEPTION_CODE, spParameterException.getCode());
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_MSG, spParameterException.getMsg());
        } else if (ex instanceof UnauthorizedException) {//未授权
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_CODE, ResultEnum.PERMISSION_UNAUTHORIZED.getValue());
            map.put(EXCEPTION_MSG, ResultEnum.PERMISSION_UNAUTHORIZED.getName());
        } else if (ex instanceof UnknownAccountException || ex instanceof IncorrectCredentialsException) {//用户名密码错误
            map.put(EXCEPTION_CODE, ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getValue());
            map.put(EXCEPTION_MSG, ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getName());
        } else if (ex instanceof LockedAccountException) {//用户被锁定
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_CODE, ResultEnum.LOGIN_FAIL_USER_IS_LOCKED.getValue());
            map.put(EXCEPTION_MSG, ResultEnum.LOGIN_FAIL_USER_IS_LOCKED.getName());
        } else if (ex instanceof AuthenticationException) {//登陆（其他）错误
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_CODE, ResultEnum.LOGIN_FAIL.getValue());
            map.put(EXCEPTION_MSG, ResultEnum.LOGIN_FAIL.getName());
        } else if (ex instanceof SessionException) {//会话过期
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_CODE, ResultEnum.SESSION_IS_NULL.getValue());
            map.put(EXCEPTION_MSG, ResultEnum.SESSION_IS_NULL.getName());
        } else if (ex instanceof UploadException) {//文件上传
            map.put(EXCEPTION_DATA, false);
            if (!SpAssert.isNotNull(((UploadException) ex).getCode()) && !SpAssert.isNotNull(((UploadException) ex).getMsg())) {
                map.put(EXCEPTION_CODE, ResultEnum.FILE_UPLOAD_FAIL.getValue());
                map.put(EXCEPTION_MSG, ResultEnum.FILE_UPLOAD_FAIL.getName());
            }
        } else {
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_CODE, 100);
            map.put(EXCEPTION_MSG, ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }
}
