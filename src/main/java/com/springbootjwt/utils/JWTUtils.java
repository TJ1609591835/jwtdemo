package com.springbootjwt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * ClassName: JWTUtils
 * Package: com.springbootjwt.utils
 * created By taojun
 * Description:
 *
 * @date: 2020/11/22 17:58
 * @author: taojun
 * @email: 1609591835@qq.com
 */
public class JWTUtils {

    private static final String SIGN = "!@#$%^&";

    /**
     * 生成 token header.payload.signature
     */
    public static String getToken(Map<String, String> map){
        Calendar instance = Calendar.getInstance();
        // 默认七天过期
        instance.add(Calendar.DATE, 7);

        // 创建jwt builder
        JWTCreator.Builder builder = JWT.create();

        // payload
        map.forEach((k,v) -> {
            builder.withClaim(k,v);
        });


        String token =
                // 指定令牌过期时间
                builder.withExpiresAt(instance.getTime())
                // 签名
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }

    /**
     * 验证token 合法性, 并返回信息对象
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

//    /**
//     * 获取token信息方法
//     */
//    public static DecodedJWT getTokenInfo(String token){
//        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
//    }
}
