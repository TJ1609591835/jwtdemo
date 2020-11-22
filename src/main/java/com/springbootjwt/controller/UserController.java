package com.springbootjwt.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.springbootjwt.entity.User;
import com.springbootjwt.service.UserService;
import com.springbootjwt.utils.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: UserController
 * Package: com.springbootjwt.controller
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 19:22
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String, Object> login(User user) {
        log.info("用户名: [{}]", user.getName());
        log.info("密码: [{}]", user.getPassword());
        HashMap<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);
            HashMap<String, String> payload = new HashMap<>();
            payload.put("userId", userDB.getId());
            payload.put("name", userDB.getName());
            // 生成JWT的令牌
            String token = JWTUtils.getToken(payload);
            map.put("state", true);
            map.put("msg", "认证成功");
            // 响应token
            map.put("token", token);
        } catch (Exception e) {
            map.put("state", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String, Object> test(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
       // 处理自己的业务逻辑
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        log.info("用户userId: [{}]", verify.getClaim("userId").asString());
        log.info("用户name: [{}]", verify.getClaim("name").asString());
        map.put("state", true);
        map.put("msg", "请求成功!");
        return map;
    }

}
