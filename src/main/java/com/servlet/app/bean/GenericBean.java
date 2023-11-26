package com.servlet.app.bean;

import java.util.List;

import javax.ejb.EJB;

import com.servlet.dao.GenericDao;
import com.servlet.database.MysqlDataBase;

public class GenericBean<T> implements GenericBeanI<T>{
    @EJB
    MysqlDataBase database;
    private final GenericDao<T> genericDao = new GenericDao<>();

    @Override
    public List<T> list(Object entity) {
        genericDao.setDatabase(database);
        return genericDao.list(entity);
    }

    @Override
    public void addOrUpdate(T entity) {
        genericDao.setDatabase(database);
        genericDao.addOrUpdate(entity);
    }

    @Override
    public void delete(T entity, int entityID) {
        genericDao.setDatabase(database);
        genericDao.delete(entity,entityID);
    }

    public GenericDao<T> getGenericDao() {
        genericDao.setDatabase(database);
        return (GenericDao<T>)genericDao;
    }
}

