package com.wu.utils;

import java.util.UUID;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/25
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public class IDUtil {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
