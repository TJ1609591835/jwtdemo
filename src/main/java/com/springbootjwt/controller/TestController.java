package com.springbootjwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: TestController
 * Package: com.springbootjwt.controller
 * created By taojun
 * Description:
 *
 * @date: 2020/11/21 19:47
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@RestController
public class TestController {

    @GetMapping("/test/test")
    public String test(String username, HttpServletRequest req){
        req.getSession().setAttribute("username", username);
        return "login ok";
    }
}
