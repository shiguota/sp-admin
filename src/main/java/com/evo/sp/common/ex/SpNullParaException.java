package com.evo.sp.common.ex;

public class SpNullParaException extends BaseException {


    public SpNullParaException(String message) {
        super(message);
    }

    public SpNullParaException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpNullParaException(Throwable cause) {
        super(cause);
    }

    public SpNullParaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
