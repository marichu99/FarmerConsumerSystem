package com.servlet.utils;

import org.apache.commons.beanutils.ConvertUtils;

import com.servlet.view.enums.UserType;


public class EnumTypeConverter {
    public static void registerEnumConverters() {
        ConvertUtils.register(new UserTypeConverter(), UserType.class);
    }
}