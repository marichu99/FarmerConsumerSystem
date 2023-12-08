package com.servlet.view.html.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface HtmlTable{

    String name() default "";

    String addUrl() default "";

    String deleteUrl() default "";

    String addToCart() default "";

    String className() default "myTable";

    String action() default "POST";
}
 