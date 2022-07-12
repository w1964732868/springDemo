package com.wu.log;

import org.springframework.aop.AfterAdvice;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class AfterLog implements AfterReturningAdvice {

    //返回值 要执行的目标对象的方法 参数 目标接口/对象
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法, 返回结果为" + o);
    }
}
