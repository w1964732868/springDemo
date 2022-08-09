package com.wu.service;

import com.wu.pojo.Books;

import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface BookService {
    //增加
    int addBook(Books books);
    //删除
    int deleteBook(int id);
    //更新
    int updateBook(Books books);
    //查询
    Books queryBook(int id);
    //查全的
    List<Books> queryAllBook();
}
