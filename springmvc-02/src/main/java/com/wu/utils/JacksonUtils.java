package com.wu.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.wu.exception.BusinessException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class JacksonUtils {
    private final static ObjectMapper DEFAULT_OBJECT_MAPPER;
    private final static ObjectMapper NOT_NULL_OBJECT_MAPPER;

    static {
        DEFAULT_OBJECT_MAPPER = new ObjectMapper();
        DEFAULT_OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        NOT_NULL_OBJECT_MAPPER = new ObjectMapper();
        NOT_NULL_OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

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


    /**
     * bean对象转Json
     *
     * @param object
     * @return
     */
    public static String bean2Json(Object object) {
        try {
            return DEFAULT_OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    /**
     * bean对象转Json
     *
     * @param object
     * @return
     */
    public static String bean2JsonNotNull(Object object) {
        try {
            return NOT_NULL_OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    /**
     * json 转bean对象 用
     *
     * @param jsonStr
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T json2Bean(String jsonStr, Class<T> cls) {
        try {
            return DEFAULT_OBJECT_MAPPER.readValue(jsonStr, cls);
        } catch (IOException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    /**
     * json 转bean对象
     *
     * @param jsonStr
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T json2Bean(String jsonStr, TypeReference<T> type) {
        try {
            return DEFAULT_OBJECT_MAPPER.readValue(jsonStr, type);
        } catch (IOException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    //protected static <R, T> R deepConvert4Bean(T bean, Class<R> clazz) {
    //    return JacksonUtils.convert(bean, clazz);
    //}

    public static <T> T convert(Object obj, Class<T> clz) {
        return DEFAULT_OBJECT_MAPPER.convertValue(obj, clz);
    }

    //protected static <R, T> List<R> deepConvert4List(List<T> list, Class<R> clazz) {
    //    return JacksonUtils.convert(list, clazz);
    //}

    public static <T, R> List<R> convert(List<T> objs, Class<R> clz) {
        JavaType type = DEFAULT_OBJECT_MAPPER.getTypeFactory().constructParametricType(ArrayList.class, clz);
        return DEFAULT_OBJECT_MAPPER.convertValue(objs, type);
    }

}
