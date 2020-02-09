package com.zhifeng.girl.service;

import com.zhifeng.girl.domain.Girl;
import com.zhifeng.girl.exception.GirlException;
import com.zhifeng.girl.reposiltory.GirlReposiltory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by zhifeng
 * 2020/2/6 23:57
 */
@Service
public class Girlservice {
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

    public void  getAge(Integer id) throws Exception{
        Optional<Girl>  girl = girlReposiltory.findById(id);
        Integer  age = girl.get().getAge();

       if(age<10){
           throw  new GirlException(100,"还在上小学吧");
       }else if (age>10 && age < 16){
           throw  new GirlException(101,"还在上初中吧");
       }


    }
}
