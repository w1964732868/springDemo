package com.wu.dao;

import com.wu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/25
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public interface TeacherMapper4 {
    Teacher getTeacher2(@Param("id") int id);

    Teacher getTeachers2(@Param("id") int id);
}
