import com.wu.mapper.MyBatisUserMapper;
import com.wu.pojo.User;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
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
            System.out.println(user);
            //User(id=1, name=哈哈, password=null)
            //User(id=2, name=hehe, password=null)
            //User(id=3, name=keke, password=null)
            //User(id=4, name=hh, password=null)
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

    //总共4条
    //select * from mysql.user limit 0,2; -- 1,2
    //select * from mysql.user limit 1,2; -- 2,3
    //select * from mysql.user limit 2,2; -- 3,4

    //select * from mysql.user limit 3; -- 1,2,3

    //sql limit
    @Test
    public void getUserListLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyBatisUserMapper mapper = sqlSession.getMapper(MyBatisUserMapper.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);//2,3
        List<User> userList = mapper.getUserListLimit(map);
        for (User user : userList) {
            System.out.println(user);
            //User(id=2, name=hehe, password=1)
            //User(id=3, name=keke, password=2)
        }

        sqlSession.close();
    }

    //rowBounds分页
    @Test
    public void getUserRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(2, 2);//3,4
        List<User> selectList = sqlSession.selectList("com.wu.mapper.MyBatisUserMapper.getUserRowBounds", "", rowBounds);
        for (User user : selectList) {
            System.out.println(user);
            //User(id=3, name=keke, password=2)
            //User(id=4, name=hh, password=3)
        }

        sqlSession.close();
    }

    //注解
    @Test
    public void getUserLimit2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        MyBatisUserMapper mapper = sqlSession.getMapper(MyBatisUserMapper.class);
        List<User> userLimit = mapper.getUserLimit();
        for (User user : userLimit) {
            System.out.println(user);
            //User(id=1, name=哈哈, password=111)
            //User(id=2, name=hehe, password=1)
            //User(id=3, name=keke, password=2)
            //User(id=4, name=hh, password=3)
        }

        sqlSession.close();
    }

    //注解+limit分页
    @Test
    public void getUserLimitRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0, 2);//1 2
        List<User> selectList = sqlSession.selectList("com.wu.mapper.MyBatisUserMapper.getUserLimit", "", rowBounds);
        for (User user : selectList) {
            System.out.println(user);
            //User(id=1, name=哈哈, password=111)
            //User(id=2, name=hehe, password=1)
        }

        sqlSession.close();
    }

    @Test
    public void testLog4J() {
        //日志级别
        logger.info("info进入");
        logger.debug("debug进入");
        logger.error("error进入");
    }

    //mybatis执行流程刨析
    //Resources获取加载全局的配置文件->实例化SqlSessionFactoryBuilder构造器->build  解析配置文件 流XMLConfigBuilder->Configuration所有配置信息->sqlSessionFactory实例化->transational事务管理->创建 executor 执行器->创建sqlSession执行mapper->实现CRUD->查快是否执行成功->关闭事务
    //实现CRUD->transational事务管理
    //查快是否执行成功->transational事务管理
}

