package com.wu.demo2;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//真实对象
public class UserServiceImpl implements UserService {

    public void add() {
        //不改变原有代码 每条加一个日志
        //System.out.println("使用了add方法");
        System.out.println("增加");
    }

    public void delete() {
        System.out.println("删除");
    }

    public void update() {
        System.out.println("修改");
    }

    public void query() {
        System.out.println("查询");
    }
}
