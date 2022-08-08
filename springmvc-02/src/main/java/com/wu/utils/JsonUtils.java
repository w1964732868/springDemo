package com.wu.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class JsonUtils {
    //代码复用
    public static String getJson(Object object) throws JsonProcessingException {
        //ObjectMapper mapper = new ObjectMapper();
        //return mapper.writeValueAsString(object);
        return getJson(object, "yyyy-MM-dd HH:mm:ss");
    }

    //代码复用
    public static String getJson(Object object, String dateformt) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleDateFormat sdf = new SimpleDateFormat(dateformt);
        mapper.setDateFormat(sdf);

        return mapper.writeValueAsString(object);
    }
}
