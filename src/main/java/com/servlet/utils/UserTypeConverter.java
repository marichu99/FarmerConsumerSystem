package com.servlet.utils;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

import com.servlet.view.enums.UserType;

public class UserTypeConverter implements Converter{
     @Override
    public <T> T convert(Class<T> tClass, Object o) {
        String enumValName = (String) o;
        UserType[] enumConstants = (UserType[]) tClass.getEnumConstants();

        for (UserType enumConstant : enumConstants) {
            if (enumConstant.name().equals(enumValName)) {
                return (T) enumConstant;
            }
        }
        throw new ConversionException(String.format("Failed to convert %s value to %s class", enumValName, tClass.toString()));
    }
}