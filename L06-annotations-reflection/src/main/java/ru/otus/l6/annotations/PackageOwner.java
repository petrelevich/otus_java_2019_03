package ru.otus.l6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tully.
 */
@Target({ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PackageOwner {
    String value() default "";
//    String owner() default "";
}
