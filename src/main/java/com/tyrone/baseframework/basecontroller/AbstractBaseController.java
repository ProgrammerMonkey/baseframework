package com.tyrone.baseframework.basecontroller;

import com.tyrone.baseframework.constant.Message;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2019-11-15 15:17
 */
public abstract class AbstractBaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    //获取http对象

    /**
     * 成功 @RestController中调用
     */
//    protected BaseResponse response() {
//        return response(getHttp(), BaseCode.CODE_200);
//    }
//
//    protected BaseResponse response(Http http,String code) {
//        return response(http,code,"base");
//    }
//
//    protected BaseResponse response(Http http,String code,String name) {
//        Message message=messageParse(code);
//        try{
//            return new BaseResponse(message,http.getRequestLogNo(),name);
//        }finally{
//            //打印日志
//            //saveLog(http,message.getCode());
//        }
//    }


    protected Message messageParse(String message) {
        return Message.parse(message);
    }

}
