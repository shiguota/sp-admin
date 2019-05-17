package com.evo.sp.common.ex;

/**
 * <p>
 *
 * </p>
 *
 * @author sgt
 * @since 2019-05-15 14:31
 */
public class DelException extends BaseException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     *
     * @param code
     * @param msg
     */
    public DelException(Integer code, String msg) {
        super(code, msg);
    }

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public DelException() {
    }

    public DelException(String message) {
        super(message);
    }

    public DelException(String message, Throwable cause) {
        super(message, cause);
    }

    public DelException(Throwable cause) {
        super(cause);
    }

    public DelException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
