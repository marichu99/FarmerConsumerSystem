package com.servlet.view.html.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.servlet.view.enums.UserType;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthFormsAnnot {
    UserType userType() default UserType.USER;
}
