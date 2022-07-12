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

//使用spring的api接口 实现AOP
public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理 代理的是接口 不是UserServiceImpl类
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

    //自定义来实现 AOP
    @Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //动态代理 代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
        //方法执行前
        //方法执行后
        //增加

        System.out.println();
        userService.select();
        //方法执行前
        //方法执行后
        //查询
    }

    //使用注解的方式实现AOP
    @Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext3.xml");
        //动态代理 代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        System.out.println();
        userService.select();
        //Annotation环绕前
        //signature:void com.wu.pojo.UserService.add()
        //Annotation方法执行前
        //增加
        //Annotation方法执行后
        //proceed:null
        //Annotation环绕后

        //Annotation环绕前
        //signature:void com.wu.pojo.UserService.select()
        //Annotation方法执行前
        //查询
        //Annotation方法执行后
        //proceed:null
        //Annotation环绕后
    }
}
