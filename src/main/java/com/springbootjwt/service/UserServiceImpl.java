package com.springbootjwt.service;

import com.springbootjwt.dao.UserDAO;
import com.springbootjwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: UserServiceImpl
 * Package: com.springbootjwt.service
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 19:18
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        // 根据接收用户名密码查询数据库
        User userDB = userDAO.login(user);
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("登录失败!");
    }
}
