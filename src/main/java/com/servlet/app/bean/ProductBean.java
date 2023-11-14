package com.servlet.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

public class ProductBean implements ProductBeanI{
     @Override
    public String productList() {
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "maize", "yellow", 300, 12));
        products.add(new Product(2, "beans", "yellow", 200, 12));
        products.add(new Product(3, "tomato", "sweet tomato", 5000, 13));
        products.add(new Product(4, "cabbage", "pink", 5000, 15));


        StringBuilder trBuilder = new StringBuilder();

        trBuilder.append("<section class='farm_produce' id='farms'>");

        for (Product product : products)
            trBuilder.append(product.displayProducts());

        trBuilder.append("</section>");

        return trBuilder.toString();

    }

    public Product addOrUpdateProduct(Product product) throws Exception {
        Database database = Database.getDbInstance();
        // check to see whether the product exists and needs to be updated
        for(Product product1 : database.getProducts()){
            if(product1.getProductId() == product.getProductId()){
                // lets update the product then
                database.getProducts().remove(product1);
                // and replace it with the new product
                database.getProducts().add(product);
            }else{
                // otherwise just add the products
                database.getProducts().add(product);
            }            
        }
        return product;
    }

    public void deleteAccount(Product product) {

    }
    
}
