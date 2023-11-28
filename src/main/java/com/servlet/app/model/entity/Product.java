package com.servlet.app.model.entity;

import java.io.Serializable;

import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.database.helper.DbTableID;
import com.servlet.view.enums.ProductCategory;
import com.servlet.view.enums.PurchaseStatus;
import com.servlet.view.html.FarmerEnumAnnot;
import com.servlet.view.html.FarmerGridView;
import com.servlet.view.html.FarmerHtmlForm;
import com.servlet.view.html.FarmerHtmlFormField;
import com.servlet.view.html.HtmlTable;
import com.servlet.view.html.HtmlTableColHeader;

@FarmerHtmlForm(label = "Product", action = "./produce")
@DbTable(name = "products")
@HtmlTable()
public class Product implements Serializable{

    @HtmlTableColHeader(header = "Product ID")
    @DbTableColumn(colName = "productId", colDescription = "INT(11)")
    @DbTableID
    private int productId;

    @HtmlTableColHeader(header = "Product Name")
    @DbTableColumn(colName = "productName", colDescription = "VARCHAR(255)")
    @FarmerGridView(className = "prodName")
    @FarmerHtmlFormField(labelName = "Product Name",formType = "text", placeHolder = "E.g. Maize")
    private String productName;

    @HtmlTableColHeader(header = "Product Description")
    @DbTableColumn(colName = "productDescription", colDescription = "VARCHAR(255)")
    @FarmerGridView(className = "prodLocation")
    @FarmerHtmlFormField(labelName = "Product Description", formType = "text", placeHolder = "your description")
    private String productDescription;

    @HtmlTableColHeader(header = "Price")
    @DbTableColumn(colName="price", colDescription = "INT(11)")
    @FarmerGridView(className = "prodPrice")
    @FarmerHtmlFormField(labelName = "Product Price", formType = "number", placeHolder = "E.g.. 200")
    private double price;

    @HtmlTableColHeader(header = "Product Quantity")
    @DbTableColumn(colName = "productQuantity", colDescription = "INT(11)")
    @FarmerHtmlFormField(labelName = "Product Quantity", formType = "number", placeHolder = "Enter amount")    
    private int prodQuantity;

    @HtmlTableColHeader(header = "Product Category")
    @DbTableColumn(colName = "productCategory", colDescription = "VARCHAR(255)")
    @FarmerHtmlFormField(labelName = "Select the Product Category", formName = "")
    @FarmerEnumAnnot
    private ProductCategory productCategory;

    @DbTableColumn(colName = "productOwner",colDescription = "VARCHAR(255)")
    private String productOwner;

    @DbTableColumn(colName = "purchaseStatus",colDescription = "VARCHAR(255)")
    @FarmerEnumAnnot
    private PurchaseStatus purchaseStatus;

    public int getProdQuantity() {
        return prodQuantity;
    }


    public void setProdQuantity(int prodQuantity) {
        this.prodQuantity = prodQuantity;
    }

    public Product() {
    }

    public Product(int id, String name, String description, double price, int prodQuantity) {
        this.productId = id;
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.prodQuantity =prodQuantity;
    }
    public Product(int id, String name, String description, double price, int prodQuantity, ProductCategory productCategory) {
        this.productId = id;
        this.productName = name;
        this.productDescription = description;
        this.price = price;
        this.prodQuantity =prodQuantity;
        this.productCategory=productCategory;
    }
    

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getPrice() {
        return price;
    }
   

    public void setPrice(double price) {
        this.price = price;
    }
    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }


    public String getProductOwner() {
        return productOwner;
    }


    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }


    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }


    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }


    
}