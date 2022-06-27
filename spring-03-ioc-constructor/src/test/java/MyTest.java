import com.wu.pojo.User;
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
public class MyTest {
    public static void main(String[] args) {
        User user = new User();//User无参构造

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//调用无参构造   User无参构造
        User user1 = (User) context.getBean("user");
        user1.show();//调用有参构造   User的show方法

    }

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");//调用无参构造   User无参构造
        User user = (User) context.getBean("user");
        User user1 = (User) context.getBean("user");
        System.out.println(user == user1);//true   beans.xml里面scope="singleton"或者默认  单例模式
        //false  beans.xml里面scope="prototype"  原型模式
    }
}
