package com.wu.demo2;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//静态代理
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.add();//增加

        System.out.println();

        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);//加了代理
        proxy.update();
        //使用了add方法
        //增加

    }
}
