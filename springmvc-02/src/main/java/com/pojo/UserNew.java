package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNew implements Serializable {
    private String name;
    private int age;
    private String sex;
    private int id;
}
