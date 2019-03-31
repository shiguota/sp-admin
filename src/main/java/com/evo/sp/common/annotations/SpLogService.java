package com.evo.sp.common.annotations;


import java.lang.annotation.*;


/**
* @Description:自定义注解拦截logservice
* @Author: 史国涛
* @Date:  2019-03-29 
*/


@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SpLogService {
    String description() default "";
}
