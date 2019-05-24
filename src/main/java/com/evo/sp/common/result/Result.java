package com.evo.sp.common.result;

import java.io.Serializable;

/**
* @Description: 返回数据bean
* @Author: sgt
* @data:  2019-03-27
*/
public class Result implements Serializable {
    /**
     * 返回的数据
     */
    private Object data;

    /**
     *  错误编码
     */
    private Integer code;

    /**
     *  错误信息
     */
    private Object msg;

    /**
     *
     * 扩展字段
     */
    private Object extension;

    public Object getdata() {
        return data;
    }

    public void setdata(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Object getExtension() {
        return extension;
    }

    public void setExtension(Object extension) {
        this.extension = extension;
    }

    public Result(Object data) {
        this.data = data;
        if(data instanceof Boolean){
            if(!(Boolean) data){
                this.code = ResultEnum.OPERATION_FAIL.getValue();
                this.msg = ResultEnum.OPERATION_FAIL.getName();
            }
        }
        this.code = ResultEnum.OPERATION_SUCCESS.getValue();
        this.msg = ResultEnum.OPERATION_SUCCESS.getName();
    }

    public Result(Integer code, Object msg) {
        data = false;
        this.code = code;
        this.msg = msg;
    }

    public Result(Object data, Integer code, Object msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public Result(Object data, Object extension) {
        this.data = data;
        this.extension = extension;
        this.code = ResultEnum.OPERATION_SUCCESS.getValue();
        this.msg = ResultEnum.OPERATION_SUCCESS.getName();
    }

    public Result(Object data, Integer code) {
        this.data = data;
        this.code = code;
        this.msg = MSG(code);

    }


    public static String MSG(Integer code){
        String msg = "";
        switch (code){
            case 1001:
                msg = ResultEnum.SAVE_SUCCESS.getName();
                break;
            case 1002:
                msg = ResultEnum.SAVE_FAIL.getName();
                break;
            case 1003:
                msg = ResultEnum.REMOVE_SUCCESS.getName();
                break;
            case 1004:
                msg = ResultEnum.REMOVE_FAIL.getName();
                break;
            case 1005:
                msg = ResultEnum.MODIFY_SUCCESS.getName();
                break;
            case 1006:
                msg = ResultEnum.MODIFY_FAIL.getName();
                break;
            case 1007:
                msg = ResultEnum.OPERATION_SUCCESS.getName();
                break;
            case 1008:
                msg = ResultEnum.OPERATION_FAIL.getName();
                break;
            case 1009:
                msg = ResultEnum.OPERATION_UNKNOWN.getName();
                break;
            case 2001:
                msg = ResultEnum.LOGIN_FAIL.getName();
                break;
            case 2002:
                msg = ResultEnum.LOGIN_SUCCESS.getName();
                break;
            case 2003:
                msg = ResultEnum.LOGIN_FIAL_SUER_NOT_IN_SYSTEM.getName();
                break;
            case 2004:
                msg = ResultEnum.LOGIN_FAIL_SUER_PASSWORD_IS_ERORR.getName();
                break;
            case 2005:
                msg = ResultEnum.LOGIN_FAIL_SUER_NOT_AND_PASSWORD_ERORR.getName();
                break;
            case 2006:
                msg = ResultEnum.LOGIN_FAIL_USER_IS_LOCKED.getName();
                break;
            case 2007:
                msg = ResultEnum.LOGIN_OUT_SUCCESS.getName();
                break;
            case 2008:
                msg = ResultEnum.LOGIN_OUT_FAIL.getName();
                break;
            case 2009:
                msg = ResultEnum.REGISTER_FAIL.getName();
                break;
            case 2010:
                msg = ResultEnum.SESSION_IS_NULL.getName();
                break;
            case 2011:
                msg = ResultEnum.LOGIN_HELP.getName();
                break;
            case 3001:
                msg = ResultEnum.REQUEST_PARAMETER_ERROR.getName();
                break;
            case 3002:
                msg = ResultEnum.REQUEST_PARAMETER_NOT_NULL.getName();
                break;
            case 4001:
                msg = ResultEnum.PERMISSION_UNAUTHORIZED.getName();
                break;
            case 4002:
                msg = ResultEnum.PERMISSION_SAVE_CODE.getName();
                break;
            case 4003:
                msg = ResultEnum.PERMISSION_SAVE_NAME.getName();
                break;
            case 4004:
                msg = ResultEnum.PERMISSION_DEL_SUCCESS.getName();
                break;
            case 4005:
                msg = ResultEnum.PERMISSION_DEL_FAIL.getName();
                break;
            case 5001:
                msg = ResultEnum.USER_IS_EXIST.getName();
                break;
            case 6001:
                msg = ResultEnum.FILE_UPLOAD_IS_NULL.getName();
                break;
            case 6002:
                msg = ResultEnum.FILE_UPLOAD_SUCCESS.getName();
                break;
            case 6003:
                msg = ResultEnum.FILE_UPLOAD_FAIL.getName();
                break;
            case 6004:
                msg = ResultEnum.FILE_NAME_EXISTS.getName();
                break;
        }
        return msg;
    }
}
