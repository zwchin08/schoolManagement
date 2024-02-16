package com.itheima.interceptors;

import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * ClassName: LoginInterceptor
 * Package: com.itheima.interceptors  如果有多个接口有同样的事情要完成可以使用什么技术来完成？  拦截器
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-18 11:02
 * @Version 1.0
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //浏览获取token令牌
        String token = request.getHeader("Authorization");
        //令牌验证
        try {
            //从redis中获取相同的token
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get(token);
            if(redisToken==null){
                //token已经失效
                throw new RuntimeException();
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
            //把解析出来的token存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            return true;//true表示 放行
        } catch (Exception e) {
            // http 响应状态码401
            response.setStatus(401);
            return false;//拦截
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据,防止内存泄漏
        ThreadLocalUtil.remove();
    }
}
