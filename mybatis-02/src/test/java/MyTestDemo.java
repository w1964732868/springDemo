import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/15
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class MyTestDemo {
    public static void main(String[] args) {
        //添加信息
        List<CodeBean> penBeanList = new ArrayList<CodeBean>();
        penBeanList.add(new CodeBean("1", "铅笔", "black", "", ""));
        penBeanList.add(new CodeBean("2", "中性笔", "white", "", ""));

        //使用contain判断，是否有相同的元素

        CodeBean codeBean = new CodeBean("1", "铅笔", "black", "", "");
        if (!penBeanList.contains(codeBean)) {
            penBeanList.add(codeBean);
        }
        CodeBean codeBean1 = new CodeBean("2", "中性笔", "white", "", "");
        if (!penBeanList.contains(codeBean1)) {
            penBeanList.add(codeBean1);
        }
        System.out.println(penBeanList);//[CodeBean(name=铅笔, n=black), CodeBean(name=中性笔, n=white)]

    }


    @Test
    public void updateUser2() {
        List<CodeBean> penBeanList = new ArrayList<CodeBean>();
        penBeanList.add(new CodeBean("1", "铅笔", "black", "", ""));
        penBeanList.add(new CodeBean("2", "中性笔", "white", "", ""));

        for (CodeBean codeBean : penBeanList) {
            codeBean.setPushType("时间");
        }
        System.out.println(penBeanList);
    }


    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("diyi", "1");
        map.put("diyi", "2");//覆盖

        //System.out.println(map);

        HashMap<String, String> map1 = new HashMap<String, String>();
        List<String> list = Arrays.asList("Aa", "BB", "C#");
        for (String s : list) {
            System.out.println(s.hashCode());

            //java1.7死锁 hash碰撞

            //hash碰撞
            //2112
            //2112
            //2112
            map1.put(s, s);

            //1、hash  2、equals
        }
    }

}
