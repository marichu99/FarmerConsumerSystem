package com.servlet.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDaoI<T> extends Serializable{
   List<T> list(Object entity);

    void addOrUpdate(T entity);

    void delete(T entity, int productID);

    EntityManager getEm();

    void setEm(EntityManager em);
    
}