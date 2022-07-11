import com.wu.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description 依赖注入  1构造器注入  2set注入  3拓展注入 p注入/c注入
 * p是无参数构造用的
 * c是有参数构造用的
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);//Student(name=武, address=null, books=null, hobbys=null, cards=null, games=null, wife=null, info=null)  只赋值了name
        //Student(
        // name=吴,
        // address=Address(address=上海),
        // books=[水浒传, 西游记, 红楼梦, 三国演义],
        // hobbys=[听歌, 看电影, 敲代码],
        // cards={身份证=123456, 银行卡=12345678},
        // games=[LOL, BOB],
        // wife=null,
        // info={password=123456, username=root})
    }
}
