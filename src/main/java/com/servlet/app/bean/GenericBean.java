package com.servlet.app.bean;

import java.util.List;

import com.servlet.dao.GenericDao;

public class GenericBean<T> implements GenericBeanI<T>{
    private final GenericDao<T> genericDao = new GenericDao<>();

    @Override
    public List<T> list(Object entity) {
        return genericDao.list(entity);
    }

    @Override
    public T addOrUpdate(T entity) {
        return genericDao.addOrUpdate(entity);
    }

    @Override
    public void delete(T entity, int entityID) {
        genericDao.delete(entity,entityID);
    }

    public GenericDao<T> getGenericDao() {
        return genericDao;
    }
}

