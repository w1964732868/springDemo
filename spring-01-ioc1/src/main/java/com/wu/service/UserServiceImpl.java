package com.wu.service;

import com.wu.dao.UserDao;
import com.wu.dao.UserDaoOracleImpl;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/26
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class UserServiceImpl implements UserService {
    //程序主动new对象 主动权在程序员手上   主动权在业务层 程序员手上
    //private UserDao userDao = new UserDaoImpl();//默认获取用户数据
    //private UserDao userDao = new UserDaoMysqlImpl();//Mysql获取用户数据
    //private UserDao userDao = new UserDaoOracleImpl();//Oracle获取用户数据

    //set注入后程序不在具有主动性，而变为被动接受对象  控制反转 IOC原型 主动权在用户
    private UserDao userDao;
    //利用set动态实现值得注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}
