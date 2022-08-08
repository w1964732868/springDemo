package com.wu.dao;

import com.wu.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    //增加
    int addBook(Books books);
    //删除
    int deleteBook(@Param("bookId")int id);
    //更新
    int updateBook(Books books);
    //查询
    Books queryBook(@Param("bookId")int id);
    //查全的
    List<Books> queryAllBook();
}
