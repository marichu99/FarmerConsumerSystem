package com.servlet.view.html.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// set the target and when to use them
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FarmerHtmlForm {
    // Set the elements of the html that you want parameterized
    String label() default "Form";

    String action() default ".";

    String httpMethod() default "POST";
    
}
