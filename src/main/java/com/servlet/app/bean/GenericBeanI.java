package com.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

public interface GenericBeanI<T> extends Serializable{
    List<T> list(T object);

    void addOrUpdate(T entity);

    void delete(T entity);

    T getByID(int id, T entity);

    List<T> allElements(T entity);
} 
