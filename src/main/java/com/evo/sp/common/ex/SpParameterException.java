package com.evo.sp.common.ex;

public class SpParameterException extends BaseException {

    private Object dtail;

    public SpParameterException(Integer code, String msg, Object dtail) {
        super(code,msg);
        this.dtail = dtail;
    }

    public SpParameterException() {
    }

    public SpParameterException(Integer code, String msg) {
        super(code,msg);
    }

    public SpParameterException(String message) {
        super(message);
    }

    public Object getDtail() {
        return dtail;
    }

    public void setDtail(Object dtail) {
        this.dtail = dtail;
    }
}
