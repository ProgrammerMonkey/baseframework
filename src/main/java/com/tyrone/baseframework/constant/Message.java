package com.tyrone.baseframework.constant;

import com.tyrone.baseframework.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: baseframework
 * @description: 处理错误代码中的code和message
 * @author: Tyrone
 * @create: 2019-11-14 16:15
 */
public class Message {
    private static final Logger LOGGER = LoggerFactory.getLogger(Message.class);

    private int code;
    private String message;

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Message parse(String message){
        if(StringUtils.isEmpty(message)){
            if(LOGGER.isErrorEnabled()) {
                LOGGER.error("BaseCode设置有误，Message为空");
            }
            return parse(BaseCode.CODE_504);
        }
        String[] msg=message.split("-");
        if(msg.length==2){
            return new Message(Integer.parseInt(msg[0]),msg[1]);
        }else{
            return new Message(0,message);
        }
    }



    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
