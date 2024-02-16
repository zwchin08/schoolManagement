package com.itheima.anno;

import com.itheima.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * ClassName: State
 * Package: com.itheima.anno
 * Description:文章的发布只有两种状态
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-19 21:16
 * @Version 1.0
 */

@Documented //元注解
@Constraint(
        validatedBy = {StateValidation.class}//指定提供校验规则的类
)
//也是元注解，用来标识可以用在哪些地方
@Target( ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)//元注解
public @interface State {

    //用来提示失败时校验信息
    String message() default "state的值只能是已发布或者草稿";
    //指定分组
    Class<?>[] groups() default {};
    //获取到state注解的信息
    Class<? extends Payload>[] payload() default {};
}
