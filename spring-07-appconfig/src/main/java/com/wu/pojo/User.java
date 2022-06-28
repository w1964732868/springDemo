package com.wu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author huijie.wu
 * @version 1.0.0
 * @date 2022/6/27
 * @description
 * @copyright COPYRIGHT © 2014 - 2022 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
@Data
@Component//说明类被spring接管 注册到容器中
public class User {

    @Value("xiaoming")//属性注入值
    private String name;
}
