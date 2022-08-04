package com.wu.pojo;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//实现Controller 就说明此类是一个控制器了
public class HelloController implements Controller {

    //重写
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();


        //调用业务层

        //封装对象 放model 数据 要展示的内容
        mv.addObject("msg", "Hello SpringMVC!");
        //封装要跳转的视图 view  jsp   视图名字
        mv.setViewName("hello");
        return mv;
    }
}
