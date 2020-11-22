package com.springbootjwt.config;

import com.springbootjwt.interceptors.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: InterceptorConfig
 * Package: com.springbootjwt.config
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 20:16
 * @author: taojun
 * @email: 1609591835@qq.com
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                // 其他接口保护
                .addPathPatterns("/user/test")
                // 所有用户放行
                .excludePathPatterns("/user/login");
    }
}
