package com.wu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/8
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor//无参构造
public class User {
    private int id;
    private String name;
    private String pwd;
}
