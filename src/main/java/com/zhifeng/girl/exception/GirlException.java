package com.zhifeng.girl.exception;

import com.zhifeng.girl.enums.ResultEnum;

/**
 * Created by zhifeng
 * 2020/2/8 17:42
 */
public class GirlException extends RuntimeException{
    private  Integer code;
    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
