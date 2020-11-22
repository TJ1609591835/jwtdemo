package com.springbootjwt.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ClassName: User
 * Package: com.springbootjwt.entity
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 18:40
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Data
@Accessors(chain=true)
public class User {
    private String id;
    private String name;
    private String password;
}
