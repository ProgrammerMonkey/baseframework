package com.tyrone.baseframework.result;

import com.tyrone.baseframework.constant.Message;

import java.util.Date;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2019-11-14 11:48
 */
public class BaseResponse {

    /**
     * 响应编号
     */
    private int code=200;
    /**
     * 响应信息
     */
    private String message;

    /**
     * 服务器时间
     */
    private Date servertime;

    public BaseResponse() {
    }
    public BaseResponse(Message message) {
        this.code = message.getCode();
        this.message = message.getMessage();
        this.servertime = new Date();
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


    public Date getServertime() {
        return servertime;
    }

    public void setServertime(Date servertime) {
        this.servertime = servertime;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", servertime=" + servertime +
                '}';
    }
}
