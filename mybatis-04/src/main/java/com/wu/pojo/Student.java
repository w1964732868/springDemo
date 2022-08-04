package com.wu.pojo;

import lombok.Data;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/7/20
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data//无参构造 set get toString equals hashCode
public class Student {
    private int id;
    private String name;
    private int tid;
}
