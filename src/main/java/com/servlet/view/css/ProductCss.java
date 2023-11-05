package com.servlet.view.css;

import java.io.Serializable;

public class ProductCss implements Serializable{
    private String styles = ".farm_produce{" +
                     "    width: 70%;" +
                     "    padding-top: 10px;" +
                     "    text-align: center;" +
                     "    margin: 10px;" +
                     "}" +
                     ".users{" +
                     "    width: 60%;" +
                     "    padding-top: 10px;" +
                     "    text-align: center;" +
                     "    margin: auto;" +
                     "    display:none;" +
                     "}" +
                     ".prod_row{" +
                     "    margin-top: 5%;" +
                     "    display: none;" +
                     "    justify-content: space-between;" +
                     "    padding-bottom: 0;" +
                     "    flex-wrap: wrap;" +
                     "}" +
                     ".prod_item{" +
                     "    flex: 1;" +
                     "    gap: 10px;" +
                     "    padding: 0;" +
                     "    margin: 10px;" +
                     "    text-align: start;" +
                     "    transition: transform .5s;" +
                     "}" +
                     ".prod_item:hover{" +
                     "    transform: scale(1.1);" +
                     "}" +
                     ".image_prod{" +
                     "    width: 200px;" +
                     "    height: 150px;" +
                     "    border-radius: 20px;" +
                     "}" +
                     ".prodName{" +
                     "    font-weight: bold;" +
                     "    font-size: 20px;" +
                     "}" +
                     ".prodLocation{" +
                     "    font-weight: 300;" +
                     "    font-size: 15px;" +
                     "    font-size: small;" +
                     "}" +
                     ".prodPrice{" +
                     "    font-weight: bold;" +
                     "    font-size: 15px;" +
                     "    color: dark-blue;" +
                     "}" +
                     ".farm_produce h1{" +
                     "    font-size: 50px;" +
                     "    font-weight: bold;" +
                     "    font-style: normal;" +
                     "}";


    public String getStyles() {
        return styles;
    }

    public void setStyles(String styles) {
        this.styles = styles;
    }
    
    
}
