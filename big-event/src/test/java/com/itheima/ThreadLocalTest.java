package com.itheima;

import org.junit.jupiter.api.Test;

/**
 * ClassName: TheadLocalTest
 * Package: com.itheima
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-18 14:02
 * @Version 1.0
 */
public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        //提供一个TheadLocal对象
        ThreadLocal tl = new ThreadLocal();


        //开启两个线程
        new Thread(()->{
            tl.set("小燕");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());

        },"蓝色").start();

        new Thread(()->{
            tl.set("火鸡");
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());

        },"红色").start();


    }
}
