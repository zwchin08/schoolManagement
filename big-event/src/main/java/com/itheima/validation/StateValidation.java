package com.itheima.validation;

import com.itheima.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName: StateValidation
 * Package: com.itheima.validation
 * Description:
 *
 * @Author 吉田学園　陈正伟
 * @Create 2024-01-22 9:30
 * @Version 1.0
 */
public class StateValidation implements ConstraintValidator<State,String> {
    /**
     *
     * @param value 将来要校验的数据
     * @param constraintValidatorContext
     * @return 如果返回false表示校验不通过，如果返回的是true表示校验通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        //提供校验规则
        if(value == null){
            return false;
        }
        if(value.equals("正社員")||value.equals("研修中")){
            return true;
        }
        return false;
    }
}
