package com.servlet.app.bean;

import java.util.ArrayList;
import java.util.List;

import com.servlet.app.model.entity.Product;

public class ProductBeanI implements ProductBean{
     @Override
    public String productList() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("001", "maize", "yellow", 300, 25, "cereals"));
        products.add(new Product("002", "beans", "yellow", 200, 20, "cereals"));
        products.add(new Product("003", "tomato", "sweet tomato", 5000, 25, "fruits"));
        products.add(new Product("004", "cabbage", "pink", 5000, 25, "vegetables"));

        StringBuilder trBuilder = new StringBuilder();

        trBuilder.append("<div >");

        for (Product product : products)
            trBuilder.append(product.displayProducts());

        trBuilder.append("</div>");

        return trBuilder.toString();
    }

    public Product addOrUpdateAccount(Product product) throws Exception {

        return null;
    }

    public void deleteAccount(Product product) {

    }
}
