package com.wu.demo1;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//代理角色
//代理角色也要做一件事情 是Rent租房子 帮房东租房子
public class Proxy implements Rent {
    //原则 先组合 少继承
    //把房东拿过来
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {//把房东给代理中介了
        this.host = host;
    }


    //代理
    public void rent() {
        seeHouse();
        host.rent();
        heTong();
        fare();
    }

    //看房
    public void seeHouse() {
        System.out.println("中介带你看房");
    }

    //收中介费
    public void fare() {
        System.out.println("收中介费");
    }

    //签合同
    public void heTong() {
        System.out.println("签租赁合同");
    }

}
