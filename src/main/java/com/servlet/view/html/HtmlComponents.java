package com.servlet.view.html;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;

public class HtmlComponents implements Serializable {
    public static String gridView(List<Product> models) {
        String allProduce = "<div class ='prodDetails'>";
        for (Product product : models){         
            allProduce += "<div class='prod_item'>" +
                    "    <img src='https://github.com/marichu99/uniProjo/blob/Main/prodIMG/Yellow-beans.jpeg' class='image_prod'/><br/>"                    +
                    "    <span class='prodName'>" + product.getProductName() + "</span><br/>" +
                    "    <span class='prodLocation'>" + product.getProductDescription() + "</span><br/>" +
                    "    <span class='prodPrice'>" + product.getPrice() * product.getProdQuantity() + "</span><br/>" +
                    "    <button class='button'>Buy</button>"+
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
    public static String cartItems(List<CartProduct> models){
        String shoppinCartHTML = "<div class=\"Container\">\n" +
        "   <div class=\"recentContainer\">\n" +
        "       <table class=\"myTable\">\n"+
        "               <tr>\n" +
        "                    <th>Product</th>\n" +
        "                    <th>Product Quantity</th>\n" +
        "                    <th>Product Price</th>\n" +
        "                    <th>Total Price</th>\n" +
        "               </tr>\n";
        Double sumProducts = 0.0;
        for(CartProduct cartProduct : models){
            shoppinCartHTML+="<tr id=\"\">\n" +
                "\n" +
                "                   <td><img src='prodIMG/' class=\"image_prod\" /><br /></td>\n" +
                "\n" +
                "                   <td id=\"prodQuantity\"><input type=\"number\" placeholder=\"Choose Quantity\" name=\"numQuantity\" class=\"numQuantity\" id=\"numQuantity\"  />/ <span id=\"totalQuantity\">"+cartProduct.getProdQuantity()+"</span></td>\n" +
                "\n" +
                "                   <td>"+cartProduct.getProdPrice()+" Kshs</td>\n" +
                "\n" +
                "                   <td id=\"\"> Total Price "+cartProduct.getProdQuantity()*cartProduct.getProdPrice()+"</td>\n" +
                "\n" +
                "                   <td><i class=\"uil uil-trash-alt\" onclick=\"window.location.href=''\"></i></td>\n";
            sumProducts+=cartProduct.getProdPrice()*cartProduct.getProdQuantity();
        }

        shoppinCartHTML +=        
        "       </table>\n" +
        "   </div>\n" +
        "   <div class=\"checkout\">\n" +
        "       <h3 class=\"checkOutHeader\">The Total Comprehensive Price is: "+sumProducts+"</h3>\n" +
        "       <input type=\"hidden\" value=\"\" id=\"numIterations\"/>\n" +
        "       <span class=\"priceText\"></span>\n" +
        "       <input class=\"submit\" name=\"submit\" value=\"proceed to checkout\" />\n" +
        "   </div>\n" +
        "</div>\n";
        return shoppinCartHTML;  
    }
}
