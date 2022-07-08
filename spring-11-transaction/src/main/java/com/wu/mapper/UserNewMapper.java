package com.wu.mapper;

import com.wu.pojo.User;

import java.util.List;

public interface UserNewMapper {
    List<User> selectUserNew();

    //添加用户
    int addUser(User user);

    //删除用户
    int deleteUser(int id);

}
