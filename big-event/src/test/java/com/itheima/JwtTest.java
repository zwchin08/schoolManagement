package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JwtTest
 * Package: com.itheima
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-18 9:16
 * @Version 1.0
 */
public class JwtTest {

    @Test
    public void testGen(){
        Map<String,Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","田中さん");
        //生成Jwt的代码
        String token = JWT.create()
                .withClaim("user",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))//添加过期时间
                .sign(Algorithm.HMAC256("itheima"));//指定算法配置密钥

        System.out.println(token);
    }

    @Test
    public void testParse(){
        //定义字符串，模拟用户传过来的token
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6IueUsOS4reOBleOCkyJ9LCJleHAiOjE3MDU1ODIyNTR9.R6e6O4vueRD8nEbWoHers0C1PwNL1RrWqiQMdo-tVCQ";
//
//        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("itheima")).build();//build()生成验证器
//        DecodedJWT decodedJWT = jwtVerifier.verify(token);//verify  中文是核实的意思    //验证token，生成一个解析后的JWT对象
//        Map<String, Claim> claims = decodedJWT.getClaims();
//        System.out.println(claims.get("user"));
        //如果篡改了头部和在和的数据，那么验证失败
        //时间过期
        //如果密钥改了也失效
    }
}
