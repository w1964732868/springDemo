package com.wu.pojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Controller
public class MappingController {
    //原来的
    @RequestMapping("/addRequest")
    public String addRequest(int a, int b, Model model) {
        //http://localhost:8081/addRequest?a=1&b=2
        //结果为3
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }

    //@RequestMapping("/addRequestResFul/{a}/{b}")
    // @RequestMapping(path = "/addRequestResFul/{a}/{b}", method = RequestMethod.GET)、
    @RequestMapping(value = "/addRequestResFul/{a}/{b}", method = RequestMethod.GET)
    //@GetMapping("/addRequestResFul/{a}/{b}")
    public String addRequestResFulGet(@PathVariable int a, @PathVariable int b, Model model) {
        //http://localhost:8081/addRequestResFul/1/2
        //结果为3

        //a、b如果是String类型的  结果为12  只是拼接
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }

    //配置了 ViewResolver视图解析器
    //简洁 高效 安全
    @PostMapping("/addRequestResFul/{a}/{b}")
    public String addRequestResFulPost(@PathVariable int a, @PathVariable int b, Model model) {
        //地址跟上面Get一样 但请求方式不一样
        //http://localhost:8081/addRequestResFul/1/2
        //结果为3

        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "hello";
    }

    //没有配置 ViewResolver视图解析器  全地址
    //转发 跳转 默认
    @GetMapping("/testForwardResFul/{a}/{b}")
    public String testForwardRequestResFul(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        model.addAttribute("msg", "结果为" + res);
        return "forward:/WEB-INF/jsp/hello.jsp";// forward 页面真正的位置
    }

    //重定向
    @GetMapping("/testRedirestResFul/{a}/{b}")
    public String testRedirestRequestResFul(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a + b;
        //http://localhost:8081/testRedirestResFul/1/2
        //重定向到下面连接
        //http://localhost:8081/index.jsp?msg=testRedirestRequestResFul
        model.addAttribute("msg", "testRedirestRequestResFul");
        return "redirect:/index.jsp";// redirect
    }

    //http://localhost:8081/testResFul?username=wu
    @GetMapping("/testResFul")
    public String testResFul(@RequestParam("username") String name) {
        System.out.println("name:" + name);//name:wu
        return "hello";
    }

    @GetMapping("/testGetResFul")
    public String testGetResFul(User user) {
        System.out.println("user:" + user);
        //http://localhost:8081/testGetResFul?id=1&username=wu&age=3
        //user:User(id=1, name=null, age=3)

        //http://localhost:8081/testGetResFul?id=1&name=wu&age=3
        //user:User(id=1, name=wu, age=3)
        return "hello";
    }


    //http://localhost:8081/form.jsp  输入：购物券
    //http://localhost:8081/testPostResFul 购物券


    //过滤器 解决乱码
    //http://localhost:8081/form.jsp  输入：购物券
    //name:è???????? 出现乱码
    @PostMapping(value = "/testPostResFul")
    public String testPostResFul(String name, Model model) {
        System.out.println("name:" + name);
        model.addAttribute("msg", name);
        return "hello";
    }

}
