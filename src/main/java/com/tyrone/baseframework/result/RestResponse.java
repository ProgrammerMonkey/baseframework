package com.tyrone.baseframework.result;

/**
 * @program: baseframework
 * @description:
 * @author: Tyrone
 * @create: 2019-11-15 15:14
 */
public class RestResponse extends BaseResponse {

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "RestResponse{" +
                "data=" + data +
                '}';
    }
}
