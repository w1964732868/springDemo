package com.wu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/12
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@RestController
public class TestController {
    @GetMapping("/t1")
    public String test() {
        System.out.println("1111111");
        return "OK";
    }
}
