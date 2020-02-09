package com.zhifeng.girl.service;

import com.zhifeng.girl.domain.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Created by zhifeng
 * 2020/2/10 0:18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlserviceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void finOneTest(){
        Optional<Girl>  girl = girlService.findOne(12);
        Assert.assertEquals(new Integer(12),girl.get().getAge());
    }

}