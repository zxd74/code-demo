package com.dongle.demo.netty.annotation;

import com.dongle.demo.netty.core.RequestMethod;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.GET)
@Documented
public @interface GetMapping {

    String[] value() default {};
}
