package com.wu.mapper;

import com.wu.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;
import java.util.regex.Matcher;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class UserNewMapperImpl extends SqlSessionDaoSupport implements UserNewMapper {

    public List<User> selectUserNew() {
        UserNewMapper mapper = getSqlSession().getMapper(UserNewMapper.class);
        //变为一组事务
        User user = new User(3, "小王", "12");
        mapper.addUser(user);
        User user3 = new User(4, "小王", "12");
        mapper.addUser(user3);
        mapper.deleteUser(3);

        return mapper.selectUserNew();
    }

    public int addUser(User user) {
        return getSqlSession().getMapper(UserNewMapper.class).addUser(user);
    }

    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserNewMapper.class).deleteUser(id);
    }
}
