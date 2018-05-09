package com.peramdy.cache.annotation;

import java.lang.annotation.*;

/**
 * @author pd 2018/2/7.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PdDelCache {
    String value();
}
