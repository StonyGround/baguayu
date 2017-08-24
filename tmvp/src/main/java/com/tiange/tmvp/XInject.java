package com.tiange.tmvp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @CreadBy ：DramaScript
 * @date 2017/3/22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface XInject {

    /**
     * 布局id
     *
     * @return
     */
    int contentViewId() default -1;


}
