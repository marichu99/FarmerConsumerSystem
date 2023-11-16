package com.servlet.app.bean;

import java.util.List;

public interface GenericBeanI<T> {
    List<T> list();

     T addOrUpdateProduct(T entity);

    void deleteProduct(T entity);
    
} 
