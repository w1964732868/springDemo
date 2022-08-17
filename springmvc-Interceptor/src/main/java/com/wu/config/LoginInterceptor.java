package com.wu.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/17
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //放行：判断什么情况下登录
        HttpSession session = request.getSession();
        //本来在登录页面了
        if (request.getRequestURI().contains("toLogin")){
            return true;
        }
        if (request.getRequestURI().contains("login")){
            return true;
        }
        //说明已经登录过了
        if (session.getAttribute("userLoginInfo") != null){
            return true;
        }

        //判断什么情况下没有登录

        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
