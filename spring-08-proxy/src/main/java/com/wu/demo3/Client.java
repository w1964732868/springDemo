package com.wu.demo3;

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
        Host host = new Host();

        //代理角色 现在没有
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //通过调用 程序处理角色  来处理我们要调用的接口对象
        handler.setRent(host);
        Rent proxy = (Rent) handler.getProxy();//动态生成的
        proxy.rent();//房东要出租房子

    }
}
