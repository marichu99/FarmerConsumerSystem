package com.servlet.dao;

import java.util.List;

import com.servlet.database.MysqlDataBase;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class GenericDao<T> implements GenericDaoI<T> {

    @Override
    public List<T> list(Object entity) {

        Class clazz = entity.getClass();
        // the select returns the unknown object and is thereby casted into the list of unknown
        return (List<T>) MysqlDataBase.select(clazz);

    }

    @Override
    public T addOrUpdate(T entity) {
        Class clazz = entity.getClass();
        System.out.println(clazz.getName());
        MysqlDataBase.insert(entity);
        return entity;
    }

    @Override
    public void delete(T entity, int entityID) {
        // code to remove an object from the database
        MysqlDataBase.delete(entity, entityID);
    }
}
