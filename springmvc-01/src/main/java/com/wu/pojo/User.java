package com.wu.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/5
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
}
