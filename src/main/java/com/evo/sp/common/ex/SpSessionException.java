package com.evo.sp.common.ex;

/**
 * <p>
 *  session 异常类
 * </p>
 *
 * @author sgt
 * @since 2019-04-04 14:25
 */
public class SpSessionException extends BaseException{

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param code
     * @param msg
     */
    public SpSessionException(Integer code, String msg) {
        super(code, msg);
    }

    public SpSessionException(String message) {
        super(message);
    }

    public SpSessionException(String message, Throwable cause) {
        super(message, cause);
    }

    public SpSessionException(Throwable cause) {
        super(cause);
    }

    public SpSessionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
