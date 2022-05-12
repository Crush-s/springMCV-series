package com.javacodt2018.springmvc.chat9.interfaces;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

/**
 * @author crush
 */
@Component
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ControllerAdvice {

    /**
     * 用来指定controller所在的包，满足一个就可以
     */
    @AliasFor("basePackages")
    String[] value() default {};

    /**
     * 用来指定controller所在的包，满足一个就可以
     *
     * @return string[]
     */
    @AliasFor("value")
    String[] basePackages() default {};

    /**
     * controller所在的包必须为basePackageClass中同等级或者自子包中，满足一个就可以
     *
     * @return Class<?>[]
     */
    Class<?>[] basePackageClasses() default {};

}
