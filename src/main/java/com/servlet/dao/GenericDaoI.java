package com.servlet.dao;

import java.util.List;

import com.servlet.database.MysqlDataBase;

public interface GenericDaoI<T>{
   List<T> list(Object entity);

    void addOrUpdate(T entity);

    void delete(T entity, int productID);

    MysqlDataBase getDatabase();

    void setDatabase(MysqlDataBase database);
    
}