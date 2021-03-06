package com.zhifeng.girl.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置实体类
 * Created by zhifeng
 * 2020/2/6 15:59
 */
@Component
@ConfigurationProperties(prefix = "girl") //获取前缀是girl配置
public class GirlProperties {
    private  String cupSize;
    private Integer age;

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
