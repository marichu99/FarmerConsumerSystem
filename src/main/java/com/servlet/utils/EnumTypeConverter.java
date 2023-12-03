package com.servlet.utils;

import org.apache.commons.beanutils.ConvertUtils;

import com.servlet.view.enums.ProductCategory;
import com.servlet.view.enums.UserCategory;
import com.servlet.view.enums.UserType;


public class EnumTypeConverter {
    public static void registerEnumConverters() {
        ConvertUtils.register(new UserCategoryConverter(), UserCategory.class);
        ConvertUtils.register(new UserTypeConverter(), UserType.class);
        ConvertUtils.register(new ProductTypeConverter(), ProductCategory.class);
    }
}