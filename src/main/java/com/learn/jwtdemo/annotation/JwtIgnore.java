package com.learn.jwtdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 忽略验证
 * @Author: lh
 * @Date: 2021/1/12 20:49
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtIgnore {

    /**
     * 是否忽略
     * @return 默认 true
     */
    boolean isIgnore() default true;

}
