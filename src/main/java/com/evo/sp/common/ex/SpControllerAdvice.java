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
            if (SpAssert.isNotNull(spParameterException.getMsg())) {
                map.put(EXCEPTION_MSG,spParameterException.getMsg());
            }else{
                map.put(EXCEPTION_MSG,ResultEnum.REQUEST_PARAMETER_ERROR.getName());
            }
            if(SpAssert.isNotNull(spParameterException.getCode())){
                map.put(EXCEPTION_CODE,spParameterException.getCode());
            }else{
                map.put(EXCEPTION_CODE, ResultEnum.REQUEST_PARAMETER_ERROR.getValue());
            }
            map.put(EXCEPTION_DATA, false);
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
            SessionException sessionException  = (SessionException) ex;
            if (SpAssert.isNotNull(sessionException.getMsg())) {
                map.put(EXCEPTION_MSG,sessionException.getMsg());
            }else{
                map.put(EXCEPTION_MSG,ResultEnum.SESSION_IS_NULL.getName());
            }
            if(SpAssert.isNotNull(sessionException.getCode())){
                map.put(EXCEPTION_CODE,sessionException.getCode());
            }else{
                map.put(EXCEPTION_CODE, ResultEnum.SESSION_IS_NULL.getValue());
            }
            map.put(EXCEPTION_DATA, false);
        }else if (ex instanceof SaveException) {//保存失败
            SaveException saveException  = (SaveException) ex;
            if (SpAssert.isNotNull(saveException.getMsg())) {
                map.put(EXCEPTION_MSG,saveException.getMsg());
            }else{
                map.put(EXCEPTION_MSG,ResultEnum.SAVE_FAIL.getName());
            }
            if(SpAssert.isNotNull(saveException.getCode())){
                map.put(EXCEPTION_CODE,saveException.getCode());
            }else{
                map.put(EXCEPTION_CODE, ResultEnum.SAVE_FAIL.getValue());
            }
            map.put(EXCEPTION_DATA, false);
        } else if (ex instanceof UploadException) {//文件上传
            map.put(EXCEPTION_DATA, false);
            if (!SpAssert.isNotNull(((UploadException) ex).getCode()) && !SpAssert.isNotNull(((UploadException) ex).getMsg())) {
                map.put(EXCEPTION_CODE, ResultEnum.FILE_UPLOAD_FAIL.getValue());
                map.put(EXCEPTION_MSG, ResultEnum.FILE_UPLOAD_FAIL.getName());
            }
        } else if(ex instanceof DelException){ //删除异常
            DelException delException  = (DelException) ex;
            if (SpAssert.isNotNull(delException.getMsg())) {
                map.put(EXCEPTION_MSG,delException.getMsg());
            }else{
                map.put(EXCEPTION_MSG,ResultEnum.REMOVE_FAIL.getName());
            }
            if(SpAssert.isNotNull(delException.getCode())){
                map.put(EXCEPTION_CODE,delException.getCode());
            }else{
                map.put(EXCEPTION_CODE, ResultEnum.REMOVE_FAIL.getValue());
            }
            map.put(EXCEPTION_DATA, false);
        } else {
            map.put(EXCEPTION_DATA, false);
            map.put(EXCEPTION_CODE, 100);
            map.put(EXCEPTION_MSG, ex.getMessage());
            ex.printStackTrace();
        }
        return map;
    }
}
