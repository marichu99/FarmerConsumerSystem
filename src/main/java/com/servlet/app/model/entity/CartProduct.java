package com.servlet.app.model.entity;

import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.view.html.HtmlTable;
import com.servlet.view.html.HtmlTableColHeader;

@HtmlTable(name = "Cart")
@DbTable(name ="CartItem")
public class CartProduct extends Product{
    @DbTableColumn(colName = "productId",colDescription = "INT")
    private int productId;
    
    @HtmlTableColHeader(header = "Product Name")
    @DbTableColumn(colName = "productName", colDescription = "VARCHAR(255)")
    private String prodName;

    @HtmlTableColHeader(header = "Price")
    @DbTableColumn(colName = "Price",colDescription = "INT(11)")
    private Double prodPrice;

    @DbTableColumn(colName = "productQuantity", colDescription = "INT(11)")
    @HtmlTableColHeader(header = "Quantity")
    private int prodQuantity;

    @DbTableColumn(colName = "productDescription",colDescription = "VARCHAR(255)")
    private String prodDescription;

    public CartProduct() {
    }
    public String getProdDescription() {
        return prodDescription;
    }
    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public Double getProdPrice() {
        return prodPrice;
    }
    public void setProdPrice(Double prodPrice) {
        this.prodPrice = prodPrice;
    }
    public int getProdQuantity() {
        return prodQuantity;
    }
    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public CartProduct(int productId, String prodName, Double prodPrice, int prodQuantity, String prodDescription) {
        this.productId = productId;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodQuantity = prodQuantity;
        this.prodDescription = prodDescription;
    }
    
    
}
