package com.wu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Component//等价于 <bean id="user" class="com.wu.pojo.User"/>
@Scope(value = "prototype")
public class User {
    //public String name = "小红";//小红

    //public String name;//null

    @Value("潇潇")
    //相当于
    //<bean id="user" class="com.wu.pojo.User">
    //<property name="name" value="潇潇"/>
    //</bean>
    public String name;//潇潇
}

