package com.zhifeng.girl.exception;

/**
 * Created by zhifeng
 * 2020/2/8 17:42
 */
public class GirlException extends RuntimeException{
    private  Integer code;
    public GirlException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
