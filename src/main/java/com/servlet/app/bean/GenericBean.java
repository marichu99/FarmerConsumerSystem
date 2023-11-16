package com.servlet.app.bean;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.database.Database;

public class GenericBean<T> implements GenericBeanI<T>{

    @SuppressWarnings({"unchecked","rawtypes"})
    @Override
    public List<T> list() {
        Class clazz = ((Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0]);

        System.out.println("List class " + clazz);
        if (clazz.equals(Product.class))
            return (List<T>) Database.getDbInstance().getProducts();

        if (clazz.equals(User.class))
            return (List<T>) Database.getDbInstance().getUsers();

        return  new ArrayList<>();
    }

    @Override
    public T addOrUpdateProduct(T entity) {
        Database database = Database.getDbInstance();

        Class clazz = entity.getClass();
        System.out.println(clazz.getName());

        if (entity instanceof Product)
            database.getProducts().add((Product) entity);

        else if (entity instanceof User)
            database.getUsers().add((User) entity);

        else if (entity instanceof User)
            database.getUsers().add((User) entity);
    

        return entity;
    }

    @Override
    public void deleteProduct(T entity) {
        Database database = Database.getDbInstance();
        if (entity instanceof Product)
            database.getProducts().remove((Product) entity);
        if (entity instanceof User)
            database.getUsers().remove((User) entity);
    }
}

