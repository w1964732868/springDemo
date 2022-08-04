package com.wu.dao;

import com.wu.pojo.Student;

import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface StudentMapper {

    //获取所有学生对应的老师信息
    List<Student> getStudent();

    List<Student> getStudents2();

}
