package com.springbootjwt.service;

import com.springbootjwt.entity.User;

/**
 * ClassName: UserService
 * Package: com.springbootjwt.service
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 19:21
 * @author: taojun
 * @email: 1609591835@qq.com
 */
public interface UserService {

    /**
     * 登录接口
     * @param user
     * @return
     */
    User login(User user);
}
