package com.zhifeng.girl.controller;

import com.zhifeng.girl.domain.Girl;
import com.zhifeng.girl.domain.Result;
import com.zhifeng.girl.reposiltory.GirlReposiltory;
import com.zhifeng.girl.service.Girlservice;
import com.zhifeng.girl.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by zhifeng
 * 2020/2/6 23:14
 */
@RestController
public class GirlController {

    @Autowired
    private GirlReposiltory girlReposiltory;

    @Autowired
    private Girlservice girlservice;

    /**
     * 查询所有女生
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList(){
    return girlReposiltory.findAll();
    }

    /**
     * 插入一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping("/girlinster")
    public Girl girlinster(@RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age){
        Girl  girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlReposiltory.save(girl);
    }

    /**
     * 传入值为对象  newgirlinster
     */
    @PostMapping("newgirlinster")
    public Result<Girl> girlinster(@Valid Girl girl, BindingResult bindingResult){
        //验证年龄是否通过
        if (bindingResult.hasErrors()){
//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg("失败");
//            result.setData(bindingResult.getFieldError().getDefaultMessage());
//            return result ;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("成功");
//        result.setData(girlReposiltory.save(girl));
//        return result ;
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil
                .success(girlReposiltory.save(girl));
    }

    /**
     * 更新一个女生
     * @param cupSize
     * @param age
     * @param id
     * @return
     */
    @PostMapping("/girlupdate")
    public  Girl girlupdate(@RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age,
                            @RequestParam("id") Integer id){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return  girlReposiltory.save(girl);
    }

    /**
     *删除一个女生
     * @param id
     */
    @DeleteMapping("girldelete/{id}")
    public  void girldelete(@PathVariable("id") Integer id){
        girlReposiltory.deleteById(id);

    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @GetMapping("girlByAge")
    public List<Girl> girlByAge(@RequestParam("age") Integer age){
        return  girlReposiltory.findByAge(age);

    }

    @GetMapping("girltow")
    public  void girltow(){
        girlservice.girlA();
        girlservice.girlB();
    }

    @GetMapping("getAge")
    public void getAge(@RequestParam("id") Integer id) throws Exception{
        girlservice.getAge(id);
    }
}
