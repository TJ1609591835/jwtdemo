package com.springbootjwt.dao;

import com.springbootjwt.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: UserDAO
 * Package: com.springbootjwt.dao
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 18:42
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Mapper
public interface UserDAO {
    User login(User user);
}
