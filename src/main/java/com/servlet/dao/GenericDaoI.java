package com.servlet.dao;

import java.util.List;

public interface GenericDaoI<T>{
    List<T> list(Object entity);

     T addOrUpdate(T entity);

    void delete(T entity, int entityID);
    
}