package com.servlet.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDaoI<T> extends Serializable{
   List<T> list(T entity);

    void addOrUpdate(T entity);

    void delete(T entity);

    EntityManager getEm();

    void setEm(EntityManager em);

    List<T> allElements(T entity);
    
}