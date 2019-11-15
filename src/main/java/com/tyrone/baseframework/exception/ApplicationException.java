package com.tyrone.baseframework.exception;

/**
 * @program: baseframework
 * @description: 应用异常
 * @author: Tyrone
 * @create: 2019-11-13 16:09
 */
public class ApplicationException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ApplicationException(Throwable e) {
        super(e);
    }

    public ApplicationException(String message) {
        super(message);
    }

}
