package com.wu.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//使用注解的方式实现AOP
@Aspect//标注类是切面
public class AnnotationPointCut {
    @Before("execution(* com.wu.pojo.UserServiceImpl.*(..))")//切入点
    public void before() {
        System.out.println("Annotation方法执行前");
    }

    @After("execution(* com.wu.pojo.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("Annotation方法执行后");
    }

    //在环绕增强中 可以给定一个参数 代表要获取处理切入的点
    @Around("execution(* com.wu.pojo.UserServiceImpl.*(..))")
    public void aroud(ProceedingJoinPoint jp) {
        System.out.println("Annotation环绕前");
        try {
            //签名
            Signature signature = jp.getSignature();
            System.out.println("signature:" + signature);
            //执行方法
            Object proceed = jp.proceed();
            System.out.println("proceed:" + proceed);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("Annotation环绕后");

    }
}
