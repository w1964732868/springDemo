package com.wu.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wu.pojo.User;
import com.wu.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/5
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
//@RestController = @Controller+@ResponseBody不会走视图解析器，会直接返回一个String
@Controller
public class UserController {
    //@RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")//springmvc-servlet.xml里面配置解决乱码
    @RequestMapping(value = "/j1")
    @ResponseBody//它不会走视图解析器，会直接返回一个String
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("w", 3, "男");


        String jsonString = mapper.writeValueAsString(user);

        //http://localhost:8083/j1
        //return user.toString();//User(name=w, age=3, sex=?) User(name=w, age=3, sex=男)
        return jsonString;//{"name":"w","age":3,"sex":"男"}
    }


    @RequestMapping(value = "/j2")
    @ResponseBody//它不会走视图解析器，会直接返回一个String
    public String json2() throws JsonProcessingException {
        User user1 = new User("w1", 3, "男");
        User user2 = new User("w2", 3, "男");
        User user3 = new User("w3", 3, "男");
        User user4 = new User("w4", 3, "男");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        arrayList.add(user4);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(arrayList);

        //http://localhost:8083/j2
        return jsonString;//[{"name":"w1","age":3,"sex":"男"},{"name":"w2","age":3,"sex":"男"},{"name":"w3","age":3,"sex":"男"},{"name":"w4","age":3,"sex":"男"}]
    }

    @RequestMapping(value = "/j3")
    @ResponseBody//它不会走视图解析器，会直接返回一个String
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //String jsonString = mapper.writeValueAsString(new Date());//1659928371698  时间戳

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String jsonString = mapper.writeValueAsString(sdf.format(new Date()));//"2022-08-08 11:15:29"

        //http://localhost:8083/j3  1659928371698  时间戳
        //http://localhost:8083/j3  "2022-08-08 11:15:29"


        return jsonString;
    }

    @RequestMapping(value = "/j4")
    @ResponseBody//它不会走视图解析器，会直接返回一个String
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        String jsonString = mapper.writeValueAsString(new Date());
        return jsonString;//http://localhost:8083/j4   "2022-08-08 11:19:52"
    }

    @RequestMapping(value = "/j5")
    @ResponseBody//它不会走视图解析器，会直接返回一个String
    public String json5() throws JsonProcessingException {
        return JsonUtils.getJson(new Date(), "yyyy-MM-dd HH:mm:ss");//http://localhost:8083/j5   "2022-08-08 11:29:41"
    }

    @RequestMapping(value = "/j6")
    @ResponseBody//它不会走视图解析器，会直接返回一个String
    public String fastjson6() throws JsonProcessingException {
        User user1 = new User("w1", 3, "男");
        User user2 = new User("w2", 3, "男");
        User user3 = new User("w3", 3, "男");
        User user4 = new User("w4", 3, "男");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add(user1);
        arrayList.add(user2);
        arrayList.add(user3);
        arrayList.add(user4);
        //http://localhost:8083/j6
        return JSON.toJSONString(arrayList);//[{"age":3,"name":"w1","sex":"男"},{"age":3,"name":"w2","sex":"男"},{"age":3,"name":"w3","sex":"男"},{"age":3,"name":"w4","sex":"男"}]
    }

}
