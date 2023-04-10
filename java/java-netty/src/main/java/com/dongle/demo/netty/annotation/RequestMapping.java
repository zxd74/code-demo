package com.dongle.demo.netty.annotation;

import com.dongle.demo.netty.core.RequestMethod;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RequestMapping {

    /**
     * 请求uri
     */
    String value() default "";

    /**
     * See{@link RequestMethod}
     */
    RequestMethod[] method() default {};


}
