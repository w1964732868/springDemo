package com.wu.demo1;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//静态代理
//客户端访问代理角色
//我  直接接触到的是中介 租的是房东的房子
public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        host.rent();//房东要出租房子  我找到了 房东

        System.out.println();

        //代理角色 代理会有一些附属操作
        //不要面对房东找中介即可
        Proxy proxy = new Proxy(host);
        proxy.rent();//房东要出租房子

        //房东要出租房子

        //中介带你看房
        //房东要出租房子
        //签租赁合同
        //收中介费
    }
}
