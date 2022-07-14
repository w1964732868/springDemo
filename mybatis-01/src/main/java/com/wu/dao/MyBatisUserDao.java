package com.wu.dao;

import com.wu.pojo.User;

import java.util.List;

public interface MyBatisUserDao {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int deleteUser(int id);

    int updateUser(User user);

}
