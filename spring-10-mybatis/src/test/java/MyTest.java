import com.wu.mapper.UserMapper;
import com.wu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//Mybatis-plus  通用mapper

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {
    @Test
    public void test() throws IOException {
        //加载配置文件
        String resources = "mybatis-config.xml";// environments|mappers注释掉了 会报错
        InputStream in = Resources.getResourceAsStream(resources);
        //读
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userNews = mapper.selectUser();
        for (User user : userNews) {
            System.out.println(user);
        }


    }


    @Test
    public void testSpringDao() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");// bean id="userMapper"注释掉了 会报错
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }
    }

    @Test
    public void testApplicationContext() throws IOException {
        //SqlSessionTemplate  sqlSession
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }
    }

    @Test
    public void test2() throws IOException {
        // //getSqlSession() SqlSessionDaoSupport里面写的  sqlSessionFactory
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }
    }

}
