package com.wu.mapper;

import com.wu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MyBatisUserMapper {
    List<User> getUserList();

    User getUserById(@Param("map") Map<String, Object> map);

    User getUserById1(@Param("id") int id);

}
