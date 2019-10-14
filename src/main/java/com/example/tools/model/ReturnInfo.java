package com.example.tools.model;

/**
 * controller给前端的返回类型
 */
public class ReturnInfo {
    String code;
    String message;

    public ReturnInfo() {
        this.code = "000000";
        this.message = "交易成功";
    }

    public ReturnInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
