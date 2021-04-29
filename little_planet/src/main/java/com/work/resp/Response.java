package com.work.resp;

import lombok.Data;

@Data
public class Response {
    private Integer code;
    private String msg;
    private Object data;


    public Response success(){
        this.code=200;
        this.msg="success";
        return this;
    }

    public Response paramEmpty(){
        this.code=10001;
        this.msg="param is fail";
        return this;
    }
    public Response noUser(){
        this.code=10002;
        this.msg="user not exists";
        return this;
    }
    public Response hasUser(){
        this.code=10003;
        this.msg="user is exists";
        return this;
    }
}
