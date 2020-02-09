package com.zhifeng.girl.controller;

import com.zhifeng.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zhifeng
 * 2020/2/6 15:48
 */
@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private  String cupSize;
//    @Value("${age}")
//    private  String age;
//
//    @Value("${content}")
//    private  String content;
    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = {"/hello","hi"},method = RequestMethod.POST)
    @GetMapping("hello")
    public String say(@RequestParam("id") Integer id){
        return "id"+id;
    }
}
