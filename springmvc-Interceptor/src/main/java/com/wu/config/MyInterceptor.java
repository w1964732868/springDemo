package com.wu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/12
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyInterceptor implements HandlerInterceptor {
    //AOP 拦截器

    //true会执行下一个拦截器 放行
    //false不执行下一个拦截器 卡住
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=======1====处理前==============");
        //http://localhost:8088/t1

        //return true;
        //=======1====处理前==============
        //=======2====处理后==============
        //=======3====清理==============

        //1111111
        return false;//=======1====处理前==============
    }

    //拦截日志
    //public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    //    System.out.println("=======2====处理后==============");
    //}
    //拦截日志
    //public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    //    System.out.println("=======3====清理==============");
    //}
}
