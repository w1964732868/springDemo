package com.wu.dao;

import com.wu.pojo.Teacher;
import org.apache.ibatis.annotations.*;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface TeacherMapper {
    @Select("select * from mysql.teacher where id =#{tid}")
    Teacher getTeacher(@Param("tid") int id);

    @Insert("insert into mysql.teacher(id, name) values (#{model.id}, #{model.name})")
    void addTeacher(@Param("model") Teacher teacher);

    @Update("update mysql.teacher set name = #{model.name} where id = #{model.id}")
    void updateTeacher(@Param("model") Teacher teacher);

    @Delete("delete from mysql.teacher where id = #{id}")
    void deleteTeacher(int id);
}
