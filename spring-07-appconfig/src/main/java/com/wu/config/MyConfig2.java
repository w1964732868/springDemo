package com.wu.config;

import com.wu.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//配置类
@Configuration//类似于beans  被石牌岭接管 注册到容器中
@ComponentScan("com.wu.pojo")
public class MyConfig2 {

    @Bean//类似于bean  getUser类似于id  返回值类似于class
    public User getUser(){
        return new User();
    }
}
