package com.evo.sp.common.annotations;


import java.lang.annotation.*;

/**
* @Description:自定义注解，拦截logController
* @Author: 史国涛
* @Date:  2019-03-29 
*/


@Target({ElementType.PARAMETER, ElementType.METHOD})//作用在参数和方法上
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Documented //表明这个注解应该被 javadoc工具记录
public @interface SpLogController {
    String description() default "";
}
