package com.wu.pojo;

import lombok.Data;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
public class User {
    private String name;

    public User() {
        System.out.println("User无参构造");

    }

    public User(String name) {
        this.name = name;
        System.out.println("User有参构造");
    }

    public void show() {
        System.out.println("name = " + name);

    }
}
