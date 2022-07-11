package com.wu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

/**
 * spring三种装配方式
 * 在xml中显示的装配
 * 在java中显示的装配
 * 隐士的自动装配bean 重要Autowired
 */
//导入约束 xmlns:context="http://www.springframework.org/schema/context"
//配置注解的支持 <context:annotation-config/>

//很简单的一个例子，有两个苹果，一个叫哈哈，一个叫呵呵，你指着两个苹果，意思是去拿个苹果，
// 让@Resource去拿，如果不说明，他懵了，但是你说明拿叫哈哈的那个，他就知道了，给你拿来了，
// 让@Autowired去拿，如果不说明，他也懵了，但是他又是个聋子，听不到你说的，结果就拿不到，但是如果写了个字条（@Qualifier）写明拿呵呵，他也就知道了。

@Data
public class Person {
    //按类型装配（默认使用的装配方式）。        byType class唯一
    //按名称装配（结合@Qualifier注解使用）。   byName id唯一

    //自动注解
    @Autowired//byType class
    private Cat cat;

    @Autowired//组合byName id
    @Qualifier(value = "dog")
    //@Resource 先name 后type   id名字唯一 class全局唯一
    // 既没指定name，也没指定type，自动按照名称装配 byName(id)  name：指定需注入的bean的名称(id) type： 指定需注入的bean的类型(class)
    private Dog dog;

    private String name;
}
