package com.wu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/8/10
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   private String name;
   private int age;
}
