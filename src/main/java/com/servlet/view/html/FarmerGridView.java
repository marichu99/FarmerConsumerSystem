package com.servlet.view.html;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FarmerGridView {

    String className() default "";

    String imgPath() default "./webapp/images/barley.jpg";
    
}
