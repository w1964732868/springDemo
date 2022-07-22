import com.wu.dao.StudentMapper;
import com.wu.dao.TeacherMapper;
import com.wu.pojo.Student;
import com.wu.pojo.Teacher;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;


/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {

    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        logger.info(teacher);//Teacher(id=1, name=秦老师)

        sqlSession.close();
    }

    @Test
    public void addTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.addTeacher(new Teacher(2, "李老师"));

        sqlSession.close();
    }

    @Test
    public void updateTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.updateTeacher(new Teacher(2, "wang老师"));

        sqlSession.close();
    }

    @Test
    public void deleteTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.deleteTeacher(2);

        sqlSession.close();
    }

    @Test
    public void getStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> teachers = mapper.getStudent();
        for (Student teacher : teachers) {
            logger.info(teacher);
            //[MyTest]-Student(id=1, name=小明, teacher=Teacher(id=1, name=秦老师))
            //[MyTest]-Student(id=2, name=小红, teacher=Teacher(id=1, name=秦老师))
            //[MyTest]-Student(id=3, name=小张, teacher=Teacher(id=1, name=秦老师))
            //[MyTest]-Student(id=4, name=小李, teacher=Teacher(id=1, name=秦老师))
            //[MyTest]-Student(id=5, name=小王, teacher=Teacher(id=1, name=秦老师))
        }
        sqlSession.close();
    }

    //java.lang.IllegalArgumentException: Result Maps collection does not contain value for
    //.xml文件中 将resultType 和resultMap 混淆
}
