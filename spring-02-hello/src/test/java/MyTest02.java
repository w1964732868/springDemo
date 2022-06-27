import com.wu.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/26
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/

/**
 * Hello是谁创建的 spring
 * 对象由spring类创建 管理 装配
 */
public class MyTest02 {
    public static void main(String[] args) {
        //获取spring的上下文对象
        ApplicationContext context = new ClassPathXmlApplicationContext( "beans.xml");
        //我的对象 都在spring的方式管理了  直接取出来既可以了
        Hello bean = (Hello)context.getBean("hello1");
        System.out.println(bean.toString());//Hello(str=HelloSpring)

    }
}
