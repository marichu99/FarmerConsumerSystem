package com.servlet.view.html;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.Product;

public class HtmlComponents implements Serializable {
    public static String gridView(List<Product> models) {
        String allProduce = "<div class ='prodDetails'>";
        for (Product product :models){         
            allProduce += "<div class='prod_item'>" +
                    "    <img src='https://www.google.com/url?sa=i&url=https%3A%2F%2Fstock.adobe.com%2Fsearch%3Fk%3Dmaize%2Bgrain&psig=AOvVaw2rA6wS_Q_uKw9iBuACnkOJ&ust=1699402854196000&source=images&cd=vfe&ved=0CBIQjRxqFwoTCMDKuI7PsIIDFQAAAAAdAAAAABAE' class='image_prod'/><br/>"
                    +
                    "    <span class='prodName'>" + product.getProductName() + "</span><br/>" +
                    "    <span class='prodLocation'>" + product.getProductDescription() + "</span><br/>" +
                    "    <span class='prodPrice'>" + product.getPrice() * product.getProdQuantity() + "</span><br/>" +
                    "</div>";
        } 
        allProduce += "</div>";
        // loop though the array of declared fields and add the HTML

        return allProduce;
    }

    public static String form(Class<?> model) {
        Field[] fields = model.getDeclaredFields();
        String htmlPage = "<form action=\"./produce\" method=\"POST\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col\">\n" +
                "            <h3 class=\"title\">Product Details</h3>\n" +
                "               <form action=\"./produce\" method=\"POST\">\n";
                // "    <div class=\"row\">\n" +
                // "        <div class=\"col\">\n" +
                // "            <h3 class=\"title\">Product Details</h3>\n";
        for (Field field : fields) {
            String fieldName = field.getName();
            // lets check if there is an anotation for this field
            if (!field.isAnnotationPresent(FarmerHtmlFormField.class))
                continue;
            // if the annotation is present then we get the various annotations for the
            // various forms present
            FarmerHtmlFormField formField = field.getAnnotation(FarmerHtmlFormField.class);
            htmlPage += "<div class=\""
                    + (StringUtils.isBlank(formField.className()) ? fieldName : formField.className()) + "\">\n" +
                    "                <label>"
                    + (StringUtils.isBlank(formField.labelName()) ? fieldName : formField.labelName()) + "</label>\n" +
                    "                <input type=\""
                    + (StringUtils.isBlank(formField.formType()) ? fieldName : formField.formType())
                    + "\" placeholder=\""
                    + (StringUtils.isBlank(formField.placeHolder()) ? fieldName : formField.placeHolder())
                    + "\" name=\"" + fieldName + "\"/>\n" +
                    "     </div>\n";
        }
        htmlPage += "<input type=\"submit\" value=\"Submit\" class=\"submit\" name=\"submit\"/>\n";
        htmlPage += "</div>\n" +
                "    </div>\n" +
                "</form>\n";
        return htmlPage;
    }
}
