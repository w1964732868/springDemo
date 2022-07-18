import com.wu.mapper.MyBatisUserMapper;
import com.wu.pojo.User;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {
    //org.apache.log4j.Logger导包
    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    public void getUserList() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyBatisUserMapper mapper = sqlSession.getMapper(MyBatisUserMapper.class);
        for (User user : mapper.getUserList()) {
            System.out.println(user);//User(id=1, name=哈哈, password=null)
        }

        //关闭
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyBatisUserMapper mapper = sqlSession.getMapper(MyBatisUserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        User user = mapper.getUserById(map);
        System.out.println(user);

        User user1 = mapper.getUserById1(1);
        System.out.println(user1);
        //User(id=1, name=哈哈, password=111)
        //User(id=1, name=哈哈, password=111)
        //关闭
        sqlSession.close();
    }

    @Test
    public void testLog4J() {
        //日志级别
        logger.info("info进入");
        logger.debug("debug进入");
        logger.error("error进入");
    }

}

