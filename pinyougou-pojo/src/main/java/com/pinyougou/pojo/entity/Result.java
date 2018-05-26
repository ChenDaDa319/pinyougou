package com.pinyougou.pojo.entity;

import java.io.Serializable;

/**
 * 返回结果封装
 */
public class Result implements Serializable{

    private boolean success;
    private String message;


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
