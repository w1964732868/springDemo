import com.wu.config.MyConfig;
import com.wu.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        User getUser = (User)context.getBean("getUser");
        System.out.println(getUser.getName());//xiaoming
    }
}
