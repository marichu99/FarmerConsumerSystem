package com.servlet.view.html.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FarmerHtmlFormField {
    String labelName() default "";

    String className() default "user";

    String placeHolder() default "";

    String formName() default "";

    String formType() default "";

}
