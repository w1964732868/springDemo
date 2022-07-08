import com.wu.mapper.UserNewMapper;
import com.wu.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//ACID 原子性 一致性 隔离性 持久性
public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserNewMapper userNewMapper = context.getBean("userNewMapper", UserNewMapper.class);
        for (User user : userNewMapper.selectUserNew()) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserNewMapper userNewMapper = context.getBean("userNewMapper", UserNewMapper.class);
        for (User user : userNewMapper.selectUserNew()) {
            System.out.println(user);//User(id=1, name=小明, pwd=123)
        }
    }
}

