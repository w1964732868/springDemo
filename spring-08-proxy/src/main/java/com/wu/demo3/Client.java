package com.wu.demo3;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

/**
 * 动态代理 底层都是反射
 * java.lang.reflect 需要了解两个类 Proxy/InvocationHandler
 * 基于接口:JDK动态代理
 * 基于类:cglib
 * Java字节码实现:javasist
 */
public class Client {
    public static void main(String[] args) {
        //真实角色
        Host host = new Host();

        //代理角色 现在没有
        ProxyInvocationHandler handler = new ProxyInvocationHandler();
        //通过调用 程序处理角色  来处理我们要调用的接口对象
        handler.setRent(host);//代理真实角色
        Rent proxy = (Rent) handler.getProxy();//动态生成的代理类
        proxy.rent();
        //中介带你看房
        //房东要出租房子
        //收中介费

    }
}
