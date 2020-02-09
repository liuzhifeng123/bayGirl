package com.zhifeng.girl.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by zhifeng
 * 2020/2/6 23:09
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue
    private  Integer id;

    @NotNull(message = "罩杯必填")
    private  String cupSize;

    @Min(value = 18, message = "未满18岁少禁止入内")
    private  Integer age;

    @Min(value = 0 , message = "金额大于零")
    private  Double monery ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Double getMonery() {
        return monery;
    }

    public void setMonery(Double monery) {
        this.monery = monery;
    }

    public Girl(){

    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", monery=" + monery +
                ", age=" + age +
                '}';
    }
}
