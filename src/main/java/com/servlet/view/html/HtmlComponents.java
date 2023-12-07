package com.servlet.view.html;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.model.entity.CartProduct;
import com.servlet.app.model.entity.Product;
import com.servlet.database.helper.DbTableID;
import com.servlet.utils.GlobalBean;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;

public class HtmlComponents extends HttpServlet {

    @EJB
    private static GlobalBean globalBean;

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
                    + product.getId() + "&mode=remove'\">Remove</button>\n" +
                    "            <button class=\"buttonEdit\" onclick=\"openForm(" + product.getId()
                    + ")\">Edit</button>\n" +
                    "            <button class='button' onclick=\"window.location.href='./cart?mode=add&productId="
                    + product.getId() + "'\">Buy</button>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</div>";
        }
        allProduce += "</div>";
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

    public static String popUpForm(Class<?> model) {
        Field[] fields = model.getDeclaredFields();
        HtmlTable htmlTable = model.getAnnotation(HtmlTable.class);

        String popUpForm = "<div class=\"form-popup\" id=\"myForm\">\n" +
                "    <form action=\"" + htmlTable.addUrl() + "\" class=\"form-container\" method=\""
                + htmlTable.action() + "\">\n" +
                "<input type=\"hidden\" value=\"update\" name=\"" + model.getSimpleName() + "\">\n" +
                "        <h2>Edit Details</h2>\n";
        for (Field field : fields) {

            // check if the field is an id column
            if (field.isAnnotationPresent(DbTableID.class)) {
                popUpForm += "<input type=\"hidden\" id=\"hiddenId\" name=\"" + field.getName() + "\">\n";
            }
            if (field.isAnnotationPresent(FarmerHtmlFormField.class) && !field.isAnnotationPresent(FarmerEnumAnnot.class)) {
                FarmerHtmlFormField farmerFormField = field.getAnnotation(FarmerHtmlFormField.class);
                popUpForm += "        <label for=\"email\"><b>" + farmerFormField.formName() + "</b></label>\n" +
                        "        <input type=\"" + farmerFormField.formType() + "\" placeholder=\""
                        + farmerFormField.placeHolder() + "\" name=\"" + field.getName() + "\" required>\n";
            }
            String optionString = "";
            if (field.isAnnotationPresent(FarmerEnumAnnot.class)) {                
                boolean isFieldEnum = field.getType().isEnum();
                if (isFieldEnum) {
                    Class<?> enumClass = field.getType();
                    optionString = "<select class=" + field.getName() + " id=" + field.getName() + " name=\"" + field.getName() + "\">\n";
                    for (Object category : enumClass.getEnumConstants()) {
                        optionString += "<option value=\"" + category + "\">" + (category)
                                + "</option>\n";
                    }
                    optionString += "</select>";
                    popUpForm+=optionString;
                }
            }
        }
        popUpForm += "<button type=\"submit\" class=\"btn\">Edit</button>\n" +
                "        <button type=\"button\" class=\"btn cancel\" onclick=\"closeForm()\">Close</button>\n" +
                "    </form>\n" +
                "</div>";
        return popUpForm;
    }
    
    public static String form(Class<?> model) {
        Class<?> clazz = model;
        String owner = "";
        if (clazz.equals(Product.class)) {
            owner = GlobalBean.getUserEmail();
            System.out.println("The owner is ###############  " + owner);
        }
        Field[] fields = model.getDeclaredFields();
        // get the location of where the form will be posted
        HtmlTable htmlTable = clazz.getAnnotation(HtmlTable.class);

        String htmlPage = "<div class='main'>" +
                " <form action=\"" + htmlTable.addUrl() + "\"  method=\"" + htmlTable.action() + "\">\n";
        htmlPage += "<div class=\"row\">\n" +
                "        <div class=\"col\">\n" +
                "            <h3 class=\"title\"> Details</h3>\n" +
                (StringUtils.isNotBlank(owner)
                        ? new String("<input type=\"hidden\" value=\"" + owner + "\"  name=\"productOwner\"/>\n")
                        : "");

        for (Field field : fields) {
            String fieldName = field.getName();
            // lets check if there is an anotation for this field
            if (!field.isAnnotationPresent(FarmerHtmlFormField.class))
                continue;
            boolean isOptionField = field.isAnnotationPresent(FarmerEnumAnnot.class);
            String optionString = "";
            boolean isFieldEnum = field.getType().isEnum();
            if (isFieldEnum) {
                Class<?> enumClass = field.getType();
                optionString = "<select class=" + fieldName + " id=" + fieldName + " name=\"" + fieldName + "\">\n";
                for (Object category : enumClass.getEnumConstants()) {
                    optionString += "<option value=\"" + category + "\">" + (category)
                            + "</option>\n";
                }
                optionString += "</select>";
            }
            // if the annotation is present then we get the various annotations for the
            // various forms present
            FarmerHtmlFormField formField = field.getAnnotation(FarmerHtmlFormField.class);
            // we come up with an options field to check whether the annotated field is an
            // option so as not to give it an input field
            htmlPage += "<div class=\""
                    + (StringUtils.isBlank(formField.className()) && !isOptionField ? fieldName : formField.className())
                    + "\">\n" +
                    "                <label>"
                    + (StringUtils.isBlank(formField.labelName()) && !isOptionField ? fieldName : formField.labelName())
                    + "</label>\n"
                    + ((isFieldEnum) ? optionString : StringUtils.EMPTY) +
                    "                <input type=\""
                    + (StringUtils.isBlank(formField.formType()) && !isOptionField ? fieldName : formField.formType())
                    + "\" placeholder=\""
                    + (StringUtils.isBlank(formField.placeHolder()) && !isOptionField ? fieldName
                            : formField.placeHolder())
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
            int modelINdex= models.indexOf(cartProduct);
            shoppinCartHTML += "<tr id=\"\">\n" +
                    "\n" +
                    "                   <td><img src='./images/corn.jpg' class=\"image_prod\" /><br /></td>\n" +
                    "\n" +
                    "                   <td id=\"prodQuantity\"><p id=\"errText"+modelINdex+"\"></p><input type=\"number\" placeholder=\"Choose Quantity\" name=\"numQuantity\" class=\"numQuantity\" id=\"numQuantity\"  onkeyup=\"calculatePrice(event,"+modelINdex+")\"/>/ <span id=\"totalQuantity"+modelINdex+"\">"
                    + cartProduct.getProdQuantity() + "</span></td>\n" +
                    "<input type='hidden' name='hiddenQuantity' id='hiddenQuantity"+modelINdex+"' name='hiddenQuantity"+modelINdex+"' value='"+cartProduct.getProdPrice()+"'\n/>"+
                    "\n" +
                    "                   <td>" + cartProduct.getProdPrice() + " Kshs</td>\n" +
                    "\n" +
                    "                   <td id=comPrice"+modelINdex+"> Total Price "
                    + cartProduct.getProdQuantity() * cartProduct.getProdPrice() + "</td>\n" +
                    "\n" +
                    "                   <td><i class=\"uil uil-trash-alt\" onclick=\"window.location.href='./produce?mode=remove&type=cart&productID="
                    + cartProduct.getId() + "'\"></i></td>\n";
            sumProducts += cartProduct.getProdPrice() * cartProduct.getProdQuantity();
        }

        shoppinCartHTML += "       </table>\n" +
                "   </div>\n" +
                "   <div class=\"checkout\">\n" +
                "       <h3 class=\"checkOutHeader\">The Total Comprehensive Price is: " + sumProducts + "</h3>\n" +
                "       <input type=\"hidden\" value=\""+models.size()+"\" id=\"numIterations\"/>\n" +
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
        trBuilder.append("<table class=" + htmlTable.className() + "><tr>");

        List<Field> fields = new ArrayList<>(Arrays.asList(dataClass.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(dataClass.getDeclaredFields()));

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
                Object id = null;
                try {
                    id = dataClass.getMethod("getId").invoke(data);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                        | NoSuchMethodException | SecurityException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

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
                // append an edit and delete button for every product
                trBuilder.append("<td><button class = 'buttonEdit' onclick='openForm(" + id + ")'>EDIT</button></td>");
                trBuilder.append(
                        "<td><button class = 'buttonRemove' onclick= \"window.location.href= '" + htmlTable.deleteUrl()
                                + ""
                                + id + "'\">DELETE</button></td>");

                trBuilder.append("<tr>");

            }
        }

        trBuilder.append("</table>");
        
        trBuilder.append("<p>"+GlobalBean.getUserEmail()+"</p>");

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

    @Override
    public ServletContext getServletContext() {
        // TODO Auto-generated method stub
        return super.getServletContext();
    }
}
