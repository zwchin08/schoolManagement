package com.itheima.config;

import com.itheima.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: WebConfig
 * Package: com.itheima.config
 * Description:用于注册拦截器。
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-18 11:29
 * @Version 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired //オートワイヤード
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录  和 注册  接口不拦截
       registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
    }
}
