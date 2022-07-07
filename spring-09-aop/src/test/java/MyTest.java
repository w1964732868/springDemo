import com.wu.pojo.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/7
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

//使用spring的api接口
public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理 代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        //com.wu.pojo.UserServiceImpl的add被执行了
        //增加
        //执行了add方法, 返回结果为null

        System.out.println();
        userService.select();
        //com.wu.pojo.UserServiceImpl的select被执行了
        //查询
        //执行了select方法, 返回结果为null
    }

    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理 代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        //com.wu.pojo.UserServiceImpl的add被执行了
        //方法执行前
        //方法执行后
        //增加
        //执行了add方法, 返回结果为null

        System.out.println();
        userService.select();
        //com.wu.pojo.UserServiceImpl的select被执行了
        //方法执行前
        //方法执行后
        //查询
        //执行了select方法, 返回结果为null
    }

    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理 代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        System.out.println();
        userService.select();

    }
}
