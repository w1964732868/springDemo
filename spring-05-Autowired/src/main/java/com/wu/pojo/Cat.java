package com.wu.pojo;

import lombok.Data;

import java.sql.SQLOutput;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
public class Cat {
    public void shout(){
        System.out.println("miao~");
    }

}
