package com.servlet.view.html;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

public class HtmlComponents extends HttpServlet {
    public static String gridView(List<Product> models) {

        String allProduce = "<div class ='prodDetails'>";
        for (Product product : models) {
            allProduce += "<div class=\"prod_item\">\n" +
                    "    <div class=\"imgDiv\">\n" +
                    "        <img src='./images/corn.jpg' class=\"image_prod\"/><br/>\n" +
                    "    </div>\n" +
                    "    <div class=\"deetsDiv\">\n" +
                    "        <span class=\"prodName\">" + product.getProductName() + "</span><br/>\n" +
                    "        <span class=\"prodLocation\">" + product.getProductDescription() + "</span><br/>\n" +
                    "        <span class=\"prodPrice\">" + product.getPrice() + "</span><br/>\n" +
                    "        <div class=\"innerButtons\">\n" +
                    "            <button class='buttonRemove' onclick=\"window.location.href='./produce?type=product&productID="
                    + product.getProductId() + "&mode=remove'\">Remove</button>\n" +
                    "            <button class=\"buttonEdit\" onclick=\"openForm(" + product.getProductId()
                    + ")\">Edit</button>\n" +
                    "            <button class='button' onclick=\"window.location.href='./cart?mode=add&productId="
                    + product.getProductId() + "'\">Buy</button>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>";
        }
        allProduce += "</div>";
        allProduce += "<div class=\"form-popup\" id=\"myForm\">\n" +
                "    <form action=\"./produce\" class=\"form-container\" method=\"POST\">\n" +
                "        <h2>Edit Details</h2>\n" +
                "        <input type=\"hidden\" id=\"hiddenId\" name=\"productId\">\n" +
                "        <input type=\"hidden\" value=\"update\" name=\"product\">\n" +
                "        <label for=\"email\"><b>Product Name</b></label>\n" +
                "        <input type=\"text\" placeholder=\"Enter product name\" name=\"productName\" required>\n" +
                "        <label for=\"psw\"><b>Product Description</b></label>\n" +
                "        <input type=\"text\" placeholder=\"Enter product description\" name=\"productDescription\" required>\n"
                +
                "        <label for=\"email\"><b>Product Quantity</b></label>\n" +
                "        <input type=\"number\" placeholder=\"Enter desired quantity\" name=\"prodQuantity\" required>\n"
                +
                "        <label for=\"psw\"><b>Price</b></label>\n" +
                "        <input type=\"number\" placeholder=\"Enter desired price per Quantity\" name=\"price\" required>\n"
                +
                "        <button type=\"submit\" class=\"btn\">Edit</button>\n" +
                "        <button type=\"button\" class=\"btn cancel\" onclick=\"closeForm()\">Close</button>\n" +
                "    </form>\n" +
                "</div>";
        allProduce += "<script type=\"text/javascript\">\n" +
                "    function openForm(productId) {\n" +
                "        document.getElementById(\"myForm\").style.display = \"flex\";\n" +
                "        document.getElementById(\"hiddenId\").value = productId;\n" +
                "    }\n\n" +
                "    function closeForm() {\n" +
                "        document.getElementById(\"myForm\").style.display = \"none\";\n" +
                "    }\n" +
                "</script>";
        // lets pass the objects using httpsessions

        // loop though the array of declared fields and add the HTML

        return allProduce;
    }

    public static String form(Class<?> model) {
        Database database = Database.getDbInstance();
        Field[] fields = model.getDeclaredFields();
        String htmlPage = "    <div class='main'>" +
                " <form action=\"./produce\"  method=\"POST\">\n" ;
        htmlPage+= " <input type=\"hidden\" value=\"" + (database.getProducts().size() + 1)
                + "\" class=\"submit\" name=\"productId\"/>\n"+
                "    <div class=\"row\">\n" +
                "        <div class=\"col\">\n" +
                "            <h3 class=\"title\">Product Details</h3>\n" +
                "               <form action=\"./produce\" method=\"POST\">\n";
        // " <div class=\"row\">\n" +
        // " <div class=\"col\">\n" +
        // " <h3 class=\"title\">Product Details</h3>\n";
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
                "</form>\n" +
                "    </div>\n";
        return htmlPage;
    }

    public static String cartItems(List<CartProduct> models) {
        String shoppinCartHTML = "<div class=\"Container\">\n" +
                "   <div class=\"recentContainer\">\n" +
                "       <table class=\"myTable\">\n" +
                "               <tr>\n" +
                "                    <th>Product</th>\n" +
                "                    <th>Product Quantity</th>\n" +
                "                    <th>Product Price</th>\n" +
                "                    <th>Total Price</th>\n" +
                "               </tr>\n";
        Double sumProducts = 0.0;
        for (CartProduct cartProduct : models) {
            shoppinCartHTML += "<tr id=\"\">\n" +
                    "\n" +
                    "                   <td><img src='./images/corn.jpg' class=\"image_prod\" /><br /></td>\n" +
                    "\n" +
                    "                   <td id=\"prodQuantity\"><input type=\"number\" placeholder=\"Choose Quantity\" name=\"numQuantity\" class=\"numQuantity\" id=\"numQuantity\"  />/ <span id=\"totalQuantity\">"
                    + cartProduct.getProdQuantity() + "</span></td>\n" +
                    "\n" +
                    "                   <td>" + cartProduct.getProdPrice() + " Kshs</td>\n" +
                    "\n" +
                    "                   <td id=\"\"> Total Price "
                    + cartProduct.getProdQuantity() * cartProduct.getProdPrice() + "</td>\n" +
                    "\n" +
                    "                   <td><i class=\"uil uil-trash-alt\" onclick=\"window.location.href='./produce?mode=remove&type=cart&productID="
                    + cartProduct.getProductId() + "'\"></i></td>\n";
            sumProducts += cartProduct.getProdPrice() * cartProduct.getProdQuantity();
        }

        shoppinCartHTML += "       </table>\n" +
                "   </div>\n" +
                "   <div class=\"checkout\">\n" +
                "       <h3 class=\"checkOutHeader\">The Total Comprehensive Price is: " + sumProducts + "</h3>\n" +
                "       <input type=\"hidden\" value=\"\" id=\"numIterations\"/>\n" +
                "       <span class=\"priceText\"></span>\n" +
                "       <input class=\"submit\" name=\"submit\" value=\"proceed to checkout\" />\n" +
                "   </div>\n" +
                "</div>\n";
        return shoppinCartHTML;
    }

    public static String table(List<?> dataList, Class<?> dataClass) {

        if (!dataClass.isAnnotationPresent(HtmlTable.class))
            return StringUtils.EMPTY;

        HtmlTable htmlTable = dataClass.getAnnotation(HtmlTable.class);

        StringBuilder trBuilder = new StringBuilder();
        trBuilder.append("<table class="+htmlTable.className()+"><tr>");

        Field[] fields = dataClass.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(HtmlTableColHeader.class))
                continue;

            trBuilder.append("<th>")
                    .append(field.getAnnotation(HtmlTableColHeader.class).header())
                    .append("</th>");
        }

        trBuilder.append("</tr>");

        if (dataList != null && !dataList.isEmpty()) {

            for (Object data : dataList) {

                trBuilder.append("<tr>");
                for (Field field : fields) {
                    if (!field.isAnnotationPresent(HtmlTableColHeader.class))
                        continue;

                    try {
                        field.setAccessible(true);
                        trBuilder.append("<td>").append(field.get(data)).append("</td>");
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }

                trBuilder.append("<tr>");

            }
        }

        trBuilder.append("</table>");

        return trBuilder.toString();

    }

    public static String getCustomerDash() {
        String htmlContent = "<div class=\"navDeets\">\n" +
                "    <div class=\"header-deets\">\n" +
                "        <div class=\"acc-details\">\n" +
                "            <span class=\"acc-span-deets\">Sold:</span>\n" +
                "            <span class=\"acc-span-deets\">KSHS 3000</span>\n" +
                "        </div>\n" +
                "        <div class=\"acc-details\">\n" +
                "            <span class=\"acc-span-deets\">Bought:</span>\n" +
                "            <span class=\"acc-span-deets\">KSHS 5000</span>\n" +
                "        </div>\n" +
                "        <div class=\"acc-details\">\n" +
                "            <span class=\"acc-span-deets\">Totals:</span>\n" +
                "            <span class=\"acc-span-deets\">KSHS -2000</span>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"sectionDeets\">\n" +
                "        <h3>Recent Activity</h3>\n" +
                "        <select class=\"logFilters\" onchange=\"getFeature(this,'logsUser')\">\n" +
                "            <option>Choose   </option>\n" +
                "            <option>Cereals</option>\n" +
                "            <option>Fruits</option>\n" +
                "            <option>Vegetables</option>\n" +
                "            <option>Animal Produce</option>\n" +
                "        </select>\n" +
                "        <h3 class=\"export\" onclick=\"window.location.href=''\">Export Report</h3>\n"
                +
                "    </div>\n";
        return htmlContent;
    }
}
