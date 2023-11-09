package com.servlet.view.html;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.view.css.LoginCss;

public class HtmlComponents extends HttpServlet{
    public static String gridView(List<Product> models) {
        
        String allProduce = "<div class ='prodDetails'>";
        for (Product product : models){         
            allProduce += "<div class='prod_item'>" +
                    "       <img src='https://github.com/marichu99/uniProjo/blob/Main/prodIMG/Yellow-beans.jpeg' class='image_prod'/><br/>"                    +
                    "       <span class='prodName'>" + product.getProductName() + "</span><br/>" +
                    "       <span class='prodLocation'>" + product.getProductDescription() + "</span><br/>" +
                    "       <span class='prodPrice'>" + product.getPrice() * product.getProdQuantity() + "</span><br/>" +
                    "       <button class='button'>Buy</button>"+
                    "      </div>";
        } 
        allProduce += "</div>";
        // lets pass the objects using httpsessions
        
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
    public static String loginForm(){
        String htmlForm = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                new LoginCss().getCssStyles()+
                "  <link rel=\"stylesheet\" href=\"https://unicons.iconscout.com/release/v4.0.0/css/line.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "  <div class=\"marichu\">\n" +
                "    <div class=\"loginContainer\">\n" +
                "      <div class=\"button-box\">\n" +
                "        <div id=\"buttonz\"></div>\n" +
                "        <button class=\"toggle-btn\" onclick=\"login()\">Login</button>\n" +
                "        <button class=\"toggle-btn\"><a href=\"./sign\">Sign Up</a></button>\n" +
                "      </div>\n" +
                "      <form action=\"./login\" method=\"POST\" id=\"login\" class=\"login-input-group\">\n" +
                "        <div class=\"loginDiv\">\n" +
                "          <label class=\"form-label\">Enter your Email:</label>\n" +
                "          <div class=\"input-detail\">\n" +
                "            <input id=\"email\" placeholder=\"Enter your Email address\" type=\"email\" name=\"email\" class=\"input-box\" onkeyup=\"checkFormValidation(event)\"><br>\n" +
                "          </div>\n" +
                "          <label class=\"form-label\">Enter your Password:</label>\n" +
                "          <div class=\"input-detail\">\n" +
                "            <input id=\"password\" placeholder=\"Enter your password\" name=\"password\" class=\"input-box\" onchange=\"checkFormValidation(event)\" onkeyup=\"checkFormValidation(event)\" type=\"password\"><br><i class=\"uil uil-eye\" id=\"openPass\" onclick=\"hidePass('password','pass')\"></i><i class=\"uil uil-eye-slash\" onclick=\"showPass('password','pass')\" id=\"eyeClosedPass\"></i>\n" +
                "          </div>\n" +
                "          <input type=\"submit\" id=\"submit\" class=\"btn-submit\"><br>\n" +
                "          <p onclick=\"window.location.href='forgotPass.php'\" class=\"forgotPass\">Forgot Password</p>\n" +
                "          <p id=\"emailValidation\"></p>\n" +
                "          <p id=\"passwordValidation\"></p>\n" +
                "        </div>\n" +
                "      </form>\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <script src=\"js/login.js\" type=\"text/javascript\"></script>\n" +
                "</body>\n" +
                "</html>";
        return htmlForm;
    }
}
