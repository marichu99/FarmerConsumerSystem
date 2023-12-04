package com.servlet.dao;

import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings({ "unchecked"})
public class GenericDao<T> implements GenericDaoI<T> {

    private EntityManager em;
    
    @Override
    public List<T> list(Object entity) {
        String jpql = "FROM "+ entity.getClass().getSimpleName()+ " e";

        List<T> results = (List<T>)em.createQuery(jpql, entity.getClass()).getResultList();

        // the select returns the unknown object and is thereby casted into the list of unknown
        return (List<T>) results;
    }

    @Override
    public void addOrUpdate(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity, int entityID) {
        String jpql = "DELETE FROM "+entity.getClass().getSimpleName()+" WHERE id=:id";
        em.createQuery(jpql,entity.getClass())
          .setParameter("id", entityID);
        // code to remove an object from the database
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
