package com.itheima;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

/**
 * ClassName: RedisTest
 * Package: com.itheima
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-24 0:03
 * @Version 1.0
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void testSet(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.set("username","hello123");
        operations.set("v","123",20, TimeUnit.SECONDS);
    }

    @Test
    public void testGet(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        System.out.println(operations.get("username"));
        System.out.println(operations.get("v"));
    }


}
