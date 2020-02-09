package com.zhifeng.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 拦截器
 * Created by zhifeng
 * 2020/2/8 15:00
 */
@Aspect
@Component
public class HttpAsperct {
    //日志
    private final static Logger logger = LoggerFactory.getLogger(HttpAsperct.class);
    //拦截方法
//    @Before("execution(public * com.zhifeng.girl.controller.GirlController.*(..))")
//    public void log(){
//        System.out.println("========拦截1========");
//    }
//
//    @After("execution(public * com.zhifeng.girl.controller.GirlController.*(..))")
//    public void  doAfter(){
//        System.out.println("========拦截2========");
//    }
    @Pointcut("execution(public * com.zhifeng.girl.controller.GirlController.*(..))")
    public void  log(){
    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("========拦截1========");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}", request.getRequestURI());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());

    }

    @After("log()")
    public void  doAfter(){
        logger.info("========拦截2========");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public  void  doAfterReturning(Object object){
     //   logger.info("response={}",object.toString());

    }

}
