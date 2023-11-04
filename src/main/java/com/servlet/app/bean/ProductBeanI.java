package com.servlet.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.entity.Product;

public class ProductBeanI implements ProductBean{
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

    public Product addOrUpdateAccount(Product product) throws Exception {

        return null;
    }

    public void deleteAccount(Product product) {

    }
    
}
