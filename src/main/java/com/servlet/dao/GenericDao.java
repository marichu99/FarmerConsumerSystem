package com.servlet.dao;

import java.util.List;

import com.servlet.database.MysqlDataBase;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class GenericDao<T> implements GenericDaoI<T> {
    private MysqlDataBase dataBase;
    @Override
    public List<T> list(Object entity) {

        Class clazz = entity.getClass();
        // the select returns the unknown object and is thereby casted into the list of unknown
        return (List<T>) dataBase.select(clazz);
    }

    @Override
    public void addOrUpdate(T entity) {
        dataBase.insert(entity);
    }

    @Override
    public void delete(T entity, int entityID) {
        // code to remove an object from the database
        dataBase.delete(entity, entityID);
    }

    @Override
    public MysqlDataBase getDatabase() {
        // TODO Auto-generated method stub
        return dataBase;
    }

    @Override
    public void setDatabase(MysqlDataBase database) {
        // TODO Auto-generated method stub
        this.dataBase=database;        
    }
}
