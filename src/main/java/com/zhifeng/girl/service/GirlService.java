package com.zhifeng.girl.service;

import com.zhifeng.girl.domain.Girl;
import com.zhifeng.girl.enums.ResultEnum;
import com.zhifeng.girl.exception.GirlException;
import com.zhifeng.girl.reposiltory.GirlReposiltory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhifeng
 * 2020/2/6 23:57
 */
@Service
public class GirlService {
    @Autowired
    private GirlReposiltory girlReposiltory;

    @Transactional  //事务
    public Girl girlA(){
        Girl girlA = new Girl();
        girlA.setCupSize("BBB");
        girlA.setAge(22);
        return  girlReposiltory.save(girlA);
    }

    public Girl girlB(){
        Girl girlB = new Girl();
        girlB.setCupSize("C");
        girlB.setAge(23);
        return  girlReposiltory.save(girlB);
    }

    public Optional<Girl> getAge(Integer id) throws Exception{
        Optional<Girl>  girl = girlReposiltory.findById(id);
        Integer  age = girl.get().getAge();

       if(age<10){
           throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
       }else if (age>10 && age < 16){
           throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
       }else if (age>16 && age<20) {
           throw new GirlException(ResultEnum.HIGH_SCHOOL);
       }else {
           return girl;
       }
    }

    public  Optional<Girl> findOne(Integer id){
        return   girlReposiltory.findById(id);
    }
}
