package com.wu.dao;

import com.wu.pojo.User;

import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public abstract class UserDaoImpl implements MyBatisUserDao {
    public List<User> getUserList() {
        //执行sql
       String sql = "select * from mysql.user";
       //结果集 resultSet
        return null;
    }
}
