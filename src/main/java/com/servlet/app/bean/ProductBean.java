package com.servlet.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

public class ProductBean implements ProductBeanI{
    private Database database = Database.getDbInstance();
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
        database.getProducts().add(product);
        return product;
    }
    public void updateByID(int productID,Product productUpdate){        
        for(Product product: database.getProducts()){
            if(productID == product.getProductId()){
                // lets update the product then
                database.getProducts().remove(product);
                // and replace it with the new product
                database.getProducts().add(productUpdate);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }

    public void deleteProduct(int productID) {
        for(Product product: database.getProducts()){
            if(productID == product.getProductId()){
                // lets update the product then
                database.getProducts().remove(product);
                break;
            }else{
                // otherwise continue
                continue;
            } 
        }
    }
    
}
