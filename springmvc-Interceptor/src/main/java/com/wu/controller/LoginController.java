package com.wu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/17
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Controller
@RequestMapping("/user")
public class LoginController {

    //http://localhost:8088/
    //=======1====处理前==============
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/toLogin")
    public String login() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model) {
        //把用户的信息放到session
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("usetname", username);
        return "main";//登录到main页面
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session) {
        //移除节点
        session.removeAttribute("userLoginInfo");
        return "main";
    }

}
