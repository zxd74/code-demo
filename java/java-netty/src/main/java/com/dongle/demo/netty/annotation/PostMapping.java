package com.dongle.demo.netty.annotation;

import com.dongle.demo.netty.core.RequestMethod;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@RequestMapping(method = RequestMethod.POST)
public @interface PostMapping {

    String[] value() default {};

}
