package com.servlet.database;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;

public class Database implements Serializable{
    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private Database(){}
    private static Database dbInstance;
    public static Database getDbInstance(){
        if(dbInstance == null){
            dbInstance = new Database();
        }
        return dbInstance;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public static void setDbInstance(Database dbInstance) {
        Database.dbInstance = dbInstance;
    }
    

    
}
