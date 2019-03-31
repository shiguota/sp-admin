package com.evo.sp.common.ex;

public class SpParameterException extends BaseException {

    private  Integer code;

    private String msg;

    private Object dtail;

    public SpParameterException(Integer code, String msg, Object dtail) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.dtail = dtail;
    }

    public SpParameterException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public SpParameterException(String message) {
        super(message);
    }


    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getDtail() {
        return dtail;
    }

    public void setDtail(Object dtail) {
        this.dtail = dtail;
    }
}
