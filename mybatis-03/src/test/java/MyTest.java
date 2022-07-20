import com.wu.dao.TeacherMapper;
import com.wu.pojo.Teacher;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


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
        logger.info(teacher);//Teacher(id=1, name=老师)

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
}
