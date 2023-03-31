package com.yan.entity;

import java.io.Serializable;

public class Response<T> implements Serializable {
    private int code;
    private T payLoad;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Response(int code, T responseObject, String msg) {
        this.code = code;
        this.payLoad = responseObject;
        this.msg = msg;
    }

    public static<T> Response<T> ok(T responseObject,String msg){
        return new Response<T>(200,responseObject,msg);
    }

    public static<T> Response<T> ok(String msg){
        return new Response<T>(200,null, msg);
    }

    public static<T> Response<T> error(int code, String msg){
        return new Response<T>(code,null, msg);
    }



}
