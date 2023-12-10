package com.servlet.view.html.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FileTypeAnnot {    
    String enctype() default "enctype=\"multipart/form-data\"";

    String accept() default "image/*";
}
