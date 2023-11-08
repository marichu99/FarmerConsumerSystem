package com.servlet.database;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database implements Serializable {

    private String databaseCreateAt;

    private List<User> users = new ArrayList<>();

    private List<Product> Products = new ArrayList<>();

    private static Database dbInstance;

    private List<CartProduct> cartProducts = new ArrayList<>();
    

    private Database(){}

    public static Database getDbInstance(){
        if (dbInstance == null) {
            dbInstance = new Database();
            dbInstance.databaseCreateAt = DateFormat.getDateTimeInstance().format(new Date());
            System.out.println("Database created at " + dbInstance.getDatabaseCreateAt());
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
        return Products;
    }

    public void setProducts(List<Product> Products) {
        this.Products = Products;
    }

    public String getDatabaseCreateAt() {
        return databaseCreateAt;
    }

    public void setDatabaseCreateAt(String databaseCreateAt) {
        this.databaseCreateAt = databaseCreateAt;
    }

    public static void setDbInstance(Database dbInstance) {
        Database.dbInstance = dbInstance;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
