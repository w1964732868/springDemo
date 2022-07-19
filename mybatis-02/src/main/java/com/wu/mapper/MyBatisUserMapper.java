package com.wu.mapper;

import com.wu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface MyBatisUserMapper {
    List<User> getUserList();

    User getUserById(@Param("map") Map<String, Object> map);

    User getUserById1(@Param("id") int id);

    List<User> getUserListLimit(@Param("map") Map<String, Integer> map);

    @Select("select id,name,pwd as password from mysql.user")
    User getUserLimit();

}
