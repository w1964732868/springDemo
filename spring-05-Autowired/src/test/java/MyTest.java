import com.wu.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//一个人有两个宠物
public class MyTest {
    /**
     * 显示注解
     */
    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = context.getBean("person", Person.class);
        person.getDog().shout();
        person.getCat().shout();
        //wang~
        //miao~

    }

    /**
     * 自动导入注解  @Autowired set方法可以省略前提在ioc容器存在且byName方式
     * 注解用反射实现的
     *
     *  @Autowired默认required为true
     *  @Autowired(required = false) 说明这个对象可以为null,否则不允许为空
     *  @Nullable说明字段可以为null
     */
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
        Person person = context.getBean("person", Person.class);
        person.getDog().shout();
        person.getCat().shout();
        //wang~
        //miao~

    }
}
