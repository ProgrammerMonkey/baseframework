package com.tyrone.baseframework.exception;

/**
 * @program: baseframework
 * @description: 业务异常
 * @author: Tyrone
 * @create: 2019-11-13 16:10
 */
public class ServiceException extends  ApplicationException {
    private static final long serialVersionUID = 1L;

    public ServiceException(String message){
        super(message);
    }



}
