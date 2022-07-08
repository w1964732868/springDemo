import com.wu.mapper.UserMapper;
import com.wu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
        String resources = "mybatis-config.xml";
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
}
