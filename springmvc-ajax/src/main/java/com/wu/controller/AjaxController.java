package com.wu.controller;

import com.wu.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/9
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        if ("wu".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(String name, HttpServletResponse response) throws IOException {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("java", 10));
        users.add(new User("mysql", 11));
        //http://localhost:8087/a2
        //[{"name":"java","age":10},{"name":"mysql","age":11}]
        return users;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd) {
        String msg = "";
        if (name != null) {
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }
        if (pwd != null) {
            if ("111".equals(pwd)) {
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        //http://localhost:8087/a3?name=12&pwd=123
        //密码有误

        //http://localhost:8087/a3?name=admin&pwd=111
        //ok

        //http://localhost:8087/login.jsp
        return msg;
    }

}
