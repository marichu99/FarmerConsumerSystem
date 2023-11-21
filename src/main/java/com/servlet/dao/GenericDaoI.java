package dao;

import java.util.List;

public interface GenericDaoI<T>{
    List<T> list();

     T addOrUpdate(T entity);

    void delete(T entity);
    
}