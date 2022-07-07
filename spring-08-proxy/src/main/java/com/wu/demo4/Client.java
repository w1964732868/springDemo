package com.wu.demo4;

import com.wu.demo2.UserService;
import com.wu.demo2.UserServiceImpl;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl userService = new UserServiceImpl();

        //代理角色
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        handler.setTarget(userService);
        //动态生成代理类
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();
        //使用了add方法
        //增加
        System.out.println();
        proxy.delete();
        //使用了delete方法
        //删除

    }
}
