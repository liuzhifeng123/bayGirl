package com.zhifeng.girl.enums;

/**
 * Created by zhifeng
 * 2020/2/9 23:05
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"你可能还在上小学吧"),
    MIDDLE_SCHOOL(101,"你可能还在上初中吧"),
    HIGH_SCHOOL(102,"你可能还在上高中吧");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
