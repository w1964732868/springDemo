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
}
