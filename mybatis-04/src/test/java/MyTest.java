import com.wu.dao.TeacherMapper4;
import com.wu.pojo.Teacher;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/23
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {
    //一对多
    //association用于一对一 多对一
    //collection一对多
    static Logger logger = Logger.getLogger(MyTest.class);

    //一对多  结果嵌套
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper4 mapper = sqlSession.getMapper(TeacherMapper4.class);
        Teacher teacher = mapper.getTeacher2(1);
        //[MyTest]-Teacher(id=0, name=秦老师, students=[Student(id=1, name=小明, tid=1), Student(id=2, name=小红, tid=1), Student(id=3, name=小张, tid=1), Student(id=4, name=小李, tid=1), Student(id=5, name=小王, tid=1)])
        logger.info(teacher);
        sqlSession.close();
    }

    //一对多  查询嵌套
    @Test
    public void testGetTeacher2() {
        SqlSession session = MybatisUtils.getSqlSession();
        TeacherMapper4 mapper = session.getMapper(TeacherMapper4.class);
        Teacher teacher = mapper.getTeachers2(1);
        logger.info(teacher.getName());
        logger.info(teacher.getStudents());
        //[MyTest]-秦老师
        //[MyTest]-[Student(id=1, name=小明, tid=1), Student(id=2, name=小红, tid=1), Student(id=3, name=小张, tid=1), Student(id=4, name=小李, tid=1), Student(id=5, name=小王, tid=1)]
    }

}
