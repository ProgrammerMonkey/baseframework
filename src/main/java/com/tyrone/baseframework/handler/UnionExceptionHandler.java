package com.tyrone.baseframework.handler;

import com.tyrone.baseframework.constant.CodeRes;
import com.tyrone.baseframework.basecontroller.AbstractBaseController;
import com.tyrone.baseframework.exception.ApplicationException;
import com.tyrone.baseframework.exception.ServiceException;
import com.tyrone.baseframework.result.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

/**
 * @program: baseframework
 * @description: 统一异常处理类
 * @author: Tyrone
 * @create: 2019-11-14 11:34
 */
@RestControllerAdvice
public class UnionExceptionHandler extends AbstractBaseController {
    //缺少日志打印模块
    @ExceptionHandler(ApplicationException.class)
    public BaseResponse handlerApplicationException(HandlerMethod handler, ApplicationException e) {
        //缺少日志打印模块
        return new BaseResponse(messageParse(CodeRes.CODE_500));
    }
    @ExceptionHandler(ServiceException.class)
    public BaseResponse handlerAppRuntimeException(HandlerMethod handler, ServiceException e) {
        return new BaseResponse(messageParse(String.valueOf(e.getMessage())));
    }


    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(HandlerMethod handler, Exception e) {
        return new BaseResponse(messageParse(CodeRes.CODE_505));
    }


}
