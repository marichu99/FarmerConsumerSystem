package com.servlet.app.bean;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.dao.GenericDao;

public class GenericBean<T> implements GenericBeanI<T>{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private GenericDao<T> genericDao;

    @Override
    public List<T> list(T entity) {
        genericDao.setEm(em);
        return genericDao.list(entity);
    }

    @Override
    public void addOrUpdate(T entity) {
        genericDao.setEm(em);
        genericDao.addOrUpdate(entity);
    }

    @Override
    public void delete(T entity, int entityID) {
        genericDao.setEm(em);
        genericDao.delete(entity,entityID);
    }

    public GenericDao<T> getGenericDao() {
        genericDao.setEm(em);
        return (GenericDao<T>)genericDao;
    }

    @Override
    public T getByID(int id, T entity) {
        List<T> elements = genericDao.list(entity);
        for(T element: elements){
            if(entity instanceof User){
                User newUser = (User) element;
                if(newUser.getId() == id){
                    // return the new user
                    return element;
                }
           }else if(entity instanceof Product){
                Product newProduct = (Product)element;
                if(newProduct.getId() == id){
                    // return the new product
                    return element;
                }
           }
        }
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> allElements(T entity) {
        // TODO Auto-generated method stub
        genericDao.setEm(em);        
        return genericDao.allElements(entity);
    }

  
}

