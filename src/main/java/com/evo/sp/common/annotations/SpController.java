package com.evo.sp.common.annotations;


import io.swagger.annotations.Api;
import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RestController
@RequestMapping
@Api
public @interface SpController {

    String value() default "";

    String[] tags() default "";
}
