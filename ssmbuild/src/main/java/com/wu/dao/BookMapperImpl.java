package com.wu.dao;

import com.wu.pojo.Books;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class BookMapperImpl extends SqlSessionDaoSupport implements BookMapper {

    SqlSessionTemplate sqlSessionTemplate;
    public int addBook(Books books) {
        return 0;
    }

    public int deleteBook(int id) {
        return 0;
    }

    public int updateBook(Books books) {
        return 0;
    }

    public Books queryBook(int id) {
        return null;
    }

    public List<Books> queryAllBook() {
        return null;
    }
}
