import com.wu.dao.MyBatisUserDao;
import com.wu.pojo.User;
import com.wu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/13
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//要导入 mysql-connector-java 依赖
//增删改需要提交事务
public class MyTest {
    @Test
    public void test() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方法1  接口的class对象  MyBatisUserDao接口
        MyBatisUserDao mapper = sqlSession.getMapper(MyBatisUserDao.class);
        for (User user : mapper.getUserList()) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }
        System.out.println();
        //方法2  selectOne selectMap  强转了
        List<User> users = sqlSession.selectList("com.wu.dao.MyBatisUserDao.getUserList");
        for (User user : users) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }

        //关闭
        sqlSession.close();
        //问题

        //org.apache.ibatis.binding.BindingException:Type interface com.wu.dao.MyBatisUserDao is not known to the MapperRegistry.
        //映射器注册表没有 绑定异常
        //<mappers>
        //        <mapper resource="com/wu/dao/MyBatisUserDao.xml"/>
        //    </mappers>


        //java.lang.ExceptionInInitializerError
        //Caused by: org.apache.ibatis.exceptions.PersistenceException:
        //### Error building SqlSession.
        //### The error may exist in com/wu/dao/MyBatisUserDao.xml
        //maven静态资源过滤问题

    }


    @Test
    public void getUserById() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方法1  接口的class对象  MyBatisUserDao接口
        MyBatisUserDao mapper = sqlSession.getMapper(MyBatisUserDao.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);//User(id=1, name=小明, pwd=123)
        //关闭
        sqlSession.close();
    }

    @Test
    public void addUser() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方法1  接口的class对象  MyBatisUserDao接口
        MyBatisUserDao mapper = sqlSession.getMapper(MyBatisUserDao.class);
        mapper.addUser(new User(2, "小红", "123456"));

        //提交事务 不然 插入不了
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方法1  接口的class对象  MyBatisUserDao接口
        MyBatisUserDao mapper = sqlSession.getMapper(MyBatisUserDao.class);
        mapper.deleteUser(2);

        //提交事务 不然 删除不了
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        //获取sqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方法1  接口的class对象  MyBatisUserDao接口
        MyBatisUserDao mapper = sqlSession.getMapper(MyBatisUserDao.class);
        mapper.updateUser(new User(1, "哈哈", "111"));

        //提交事务 不然 修改不了
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }


}

