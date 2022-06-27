import com.wu.dao.UserDaoImpl;
import com.wu.dao.UserDaoMysqlImpl;
import com.wu.dao.UserDaoOracleImpl;
import com.wu.service.UserService;
import com.wu.service.UserServiceImpl;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/26
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTest {
    public static void main(String[] args) {
        //用户实际调用的是业务层，用户dao不需要接触
        UserService userService = new UserServiceImpl();

        //set注入后程序不在具有主动性，而变为被动接受对象
        //((UserServiceImpl)userService).setUserDao(new UserDaoOracleImpl());//Oracle获取用户数据
        //((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());//Mysql获取用户数据
        ((UserServiceImpl)userService).setUserDao(new UserDaoImpl());//默认获取用户数据



        userService.getUser();

    }
}
