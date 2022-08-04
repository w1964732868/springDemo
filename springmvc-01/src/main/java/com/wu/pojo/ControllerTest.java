package com.wu.pojo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/4
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Controller//会被视图解析器处理   有hello.jsp
// @RestController 不会被视图解析器解析直接返回字符串  会被spring接管
public class ControllerTest {
    //http://localhost:8081/annotationHello
    //SpringMVC and Annotation!
    //@GetMapping("/annotationHello")
    @RequestMapping("/annotationHello")
    public String hello(Model model) {
        String str = "SpringMVC and Annotation!";//业务逻辑层
        model.addAttribute("msg", str);
        return "hello";//会被视图解析器处理  视图名字  有hello.jsp
    }
}
