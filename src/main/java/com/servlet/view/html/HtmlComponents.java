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
import com.servlet.app.model.entity.PaymentDetails;
import com.servlet.app.model.entity.Product;
import com.servlet.database.helper.DbTableID;
import com.servlet.utils.GlobalBean;
import com.servlet.view.html.annotation.FarmerEnumAnnot;
import com.servlet.view.html.annotation.FarmerGridView;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.FileTypeAnnot;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;
import com.servlet.view.html.annotation.PaymentTypeAnnotation;

public class HtmlComponents extends HttpServlet {

    @EJB
    private static GlobalBean globalBean;

    public static String gridView(Class<?> clazz, List<?> entityList) {

        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

        System.out.println("The class name is " + clazz.getSimpleName());
        String allProduce = "<div class ='prodDetails'>";

        for (Object object : entityList) {
            String imgName = "";
            for (Field field : fields) {
                if (field.isAnnotationPresent(FileTypeAnnot.class)) {
                    field.setAccessible(true);
                    try {
                        imgName = (String) field.get(object);
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
            allProduce += "  <div class=\"prod_item\">\n" +
                    "           <div class=\"imgDiv\">\n" +
                    "            <img src='./images/" + imgName + "' class=\"image_prod\"/><br/>\n" +
                    "           </div>\n" +
                    "           <div class=\"deetsDiv\">\n";

            Object id = null;
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    if (field.get(object) != null) {

                        try {
                            id = clazz.getMethod("getId").invoke(object);
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
                                | NoSuchMethodException | SecurityException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        if (field.isAnnotationPresent(FarmerGridView.class)) {
                            allProduce += "        <span class=\"" + field.getName() + "\">" + field.get(object)
                                    + "</span><br/>\n";
                        }
                    }
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (clazz.isAnnotationPresent(HtmlTable.class)) {
                HtmlTable htmlTable = clazz.getAnnotation(HtmlTable.class);
                allProduce+=  " <div class=\"innerButtons\">\n";
                if(GlobalBean.isShowButtons()){
                    allProduce+= "<button class='button' onclick=\"window.location.href='" + htmlTable.addToCart()
                        + ""
                        + id + "'\">Buy</button>\n";
                }else{
                    allProduce += " <button class='buttonRemove' onclick=\"window.location.href='"
                        + htmlTable.deleteUrl() + ""
                        + id + "&mode=remove'\">Remove</button>\n" +
                        "            <button class=\"buttonEdit\" onclick=\"openModal('element')\">Edit</button>\n";
                }
                allProduce+="<input type=\"hidden\" id=\"hiddenIdTable"+id+"\" value=\"" + id + "\">";
                allProduce+=       
                        "     </div>\n" +
                        " </div>\n";

            }
            allProduce += " </div>\n";

        }
        allProduce += "</div>";
        allProduce+=myModal(clazz, false);

        return allProduce;
    }

    public static String popUpForm(Class<?> model) {

        List<Field> fields = new ArrayList<>(Arrays.asList(model.getSuperclass().getDeclaredFields()));
        fields.addAll(Arrays.asList(model.getDeclaredFields()));
        HtmlTable htmlTable = model.getAnnotation(HtmlTable.class);

        String popUpForm = "<div class=\"form-popup\" id=\"myForm\">\n";
        if (model.isAnnotationPresent(PaymentTypeAnnotation.class)) {
            popUpForm += "    <form  class=\"form-container\" onsubmit=\" return false;\">\n";
        } else {
            popUpForm += " <form action=\"" + htmlTable.addUrl() + "\" class=\"form-container\" method=\""
                    + htmlTable.action() + "\">\n" +
                    "<input type=\"hidden\" value=\"update\" name=\"" + model.getSimpleName() + "\">\n" +
                    "        <h2>Edit Details</h2>\n";
        }
        for (Field field : fields) {

            // check if the field is an id column
            if (field.isAnnotationPresent(DbTableID.class)) {
                popUpForm += "<input type=\"hidden\" id=\"hiddenId\" name=\"" + field.getName() + "\">\n";
            }
            if (field.isAnnotationPresent(FarmerHtmlFormField.class)
                    && !field.isAnnotationPresent(FarmerEnumAnnot.class)) {
                FarmerHtmlFormField farmerFormField = field.getAnnotation(FarmerHtmlFormField.class);
                popUpForm += "        <label for=\"email\"><b>" + farmerFormField.formName() + "</b></label>\n" +
                        "        <input type=\"" + farmerFormField.formType() + "\" placeholder=\""
                        + farmerFormField.placeHolder() + "\" name=\"" + field.getName() + "\" id=\""
                        + (StringUtils.isEmpty(farmerFormField.className()) ? field.getName()
                                : farmerFormField.className())
                        + "\" required>\n";
            }
            String optionString = "";
            if (field.isAnnotationPresent(FarmerEnumAnnot.class)) {
                boolean isFieldEnum = field.getType().isEnum();
                if (isFieldEnum) {
                    Class<?> enumClass = field.getType();
                    optionString = "<select class=" + field.getName() + " id=" + field.getName() + " name=\""
                            + field.getName() + "\">\n";
                    for (Object category : enumClass.getEnumConstants()) {
                        optionString += "<option value=\"" + category + "\">" + (category)
                                + "</option>\n";
                    }
                    optionString += "</select>";
                    popUpForm += optionString;
                }
            }
        }
        if (model.isAnnotationPresent(PaymentTypeAnnotation.class)) {
            popUpForm += "<input type=\"submit\" name=\"submit\" value=\"Pay\"/> ";
        } else {
            popUpForm += "<input name=\"submit\" type=\"submit\" class=\"btn\" value=\"Edit\"> " +
                    "        <button type=\"button\" class=\"btn cancel\" onclick=\"closeForm()\">Close</button>\n" +
                    "    </form>\n" +
                    "</div>";
        }
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

        String enctype = "";
        boolean isEnctypePresent = false;
        if (clazz.isAnnotationPresent(FileTypeAnnot.class)) {
            FileTypeAnnot imageTypeAnnot = clazz.getAnnotation(FileTypeAnnot.class);
            enctype = imageTypeAnnot.enctype();
            isEnctypePresent = true;
        }

        String htmlPage = "<div class='main'>" +
                " <form action=\"" + htmlTable.addUrl() + "\"  method=\"" + htmlTable.action() + "\""
                + (isEnctypePresent ? enctype : StringUtils.EMPTY) + "\">\n";
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
            boolean isFileTypeAnnotPresent = false;
            FileTypeAnnot fileTypeAnnot = field.getAnnotation(FileTypeAnnot.class);
            ;
            if (field.isAnnotationPresent(FileTypeAnnot.class)) {
                fileTypeAnnot = field.getAnnotation(FileTypeAnnot.class);
                isFileTypeAnnotPresent = true;
            }

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
                    + "\" name=\"" + formField.formName()
                    + "\" accept = " + (isFileTypeAnnotPresent ? fileTypeAnnot.accept() : StringUtils.EMPTY) + "/>\n" +
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
            int modelINdex = models.indexOf(cartProduct);
            shoppinCartHTML += "<tr id=\"\">\n" +
                    "\n" +
                    "                   <td><img src='./images/"+cartProduct.getImageName()+"' class=\"image_prod\" /><br /></td>\n" +
                    "\n" +


                    "                   <td id=\"prodQuantity\"><p id=\"errText" + modelINdex
                    + "\"></p><input type=\"number\" placeholder=\"Choose Quantity\" name=\"numQuantity\" class=\"numQuantity\" id=\"numQuantity"
                    + modelINdex + "\"  onkeyup=\"calculatePrice(event,"
                    + modelINdex + ")\"/>/ <span id=\"totalQuantity" + modelINdex + "\">"
                    + cartProduct.getProdQuantity() + "</span></td>\n" +


                    "<input type='hidden' name='hiddenQuantity' id='hiddenQuantity" + modelINdex
                    + "' name='hiddenQuantity" + modelINdex + "' value='" + cartProduct.getProdPrice() + "'\n/>" +
                    "\n" +

                    "<input type='hidden' name='hiddenProductID' id='hiddenProductID" + modelINdex
                    + "' name='hiddenProductID" + modelINdex + "' value='" + cartProduct.getProductID() + "'\n/>" +
                    "\n" +

                    "<input type='hidden' name='hiddenUpdatedQuantity' id='hiddenUpdatedQuantity" + modelINdex
                    + "' name='hiddenUpdatedQuantity" + modelINdex + "'\n/>" +
                    "\n" +


                    "                   <td>" + cartProduct.getProdPrice() + " Kshs</td>\n" +

                    
                    "\n" +
                    "<input type=\"hidden\" value=\"" + cartProduct.getProdQuantity() * cartProduct.getProdPrice()
                    + "\" id=\"totalPricePerProductH" + modelINdex + "\"/>\n" +


                    "                   <td id=comPrice" + modelINdex + "> Total Price "
                    + "<span id=\"totalPricePerProduct" + modelINdex + "\"/>"
                    + cartProduct.getProdQuantity() * cartProduct.getProdPrice() + "</span>" +
                    "</td>\n" +


                    "\n" +
                    "                   <td><i class=\"uil uil-trash-alt\" onclick=\"window.location.href='./produce?mode=remove&type=cart&productID="
                    + cartProduct.getId() + "'\"></i></td>\n";
            sumProducts += cartProduct.getProdPrice() * cartProduct.getProdQuantity();
        }

        shoppinCartHTML += "       </table>\n" +
                "   </div>\n" +
                "   <div class=\"checkout\">\n" +
                "       <h3 class=\"checkOutHeader\">The Total Comprehensive Price is: </h3>\n" +
                "       <input type=\"hidden\" value=\"" + models.size() + "\" id=\"numIterations\"/>\n" +
                "       <span class=\"priceText\">"+sumProducts+"</span>\n" +
                "       <button id='myBtn' class=\"submit\" onclick=\"openModal('checkout')\">proceed to checkout</button>" +
                
                "   </div>\n" +
                "</div>\n";          
                shoppinCartHTML+=myModal(PaymentDetails.class,true);      
        return shoppinCartHTML;
    }

    public static String myModal(Class<?> dataClazz,boolean showPrice){
        String modalString = "<!-- The Modal -->" +
                        "<div id='myModal' class='modal'>" +

                        "<div class='modal-content'>" +
                        "<span class='close' onclick=\"closeModal()\">&times;</span>" +
                        "<input type=\"hidden\" value=\"\" id=\"hiddenFinalPrice\"/>\n" ;
                        if(showPrice){
                            modalString+="<span class=\"priceText\">The Total Price is KSHS <span class=\"finalPrice\"></span></span>\n";
                        }
                        modalString+= popUpForm(dataClazz) +
                        "</div>" +
                        "</div>";
            return modalString;
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

                trBuilder.append("<input type=\"hidden\" id=\"hiddenIdTable"+id+"\" value=\"" + id + "\">");
                trBuilder.append("<td><button class = 'buttonEdit' onclick=\"openModal('element',"+id+")\">EDIT</button></td>");
                trBuilder.append(
                        "<td><button class = 'buttonRemove' onclick= \"window.location.href= '" + htmlTable.deleteUrl()
                                + ""
                                + id + "'\">DELETE</button></td>");

                trBuilder.append("<tr>");

            }
        }

        trBuilder.append("</table>");

        trBuilder.append("<p>" + GlobalBean.getUserEmail() + "</p>");
        trBuilder.append(myModal(dataClass, false));

        return trBuilder.toString();

    }

    public static String getCustomerDash(Class<?> dataClass, String location) {

        List<Field> fields = new ArrayList<>(Arrays.asList(dataClass.getDeclaredFields()));

        fields.remove(fields.size() - 1);

        // check whether this is an admin

        String htmlContent = "<div class=\"navDeets\">\n" +
                "    <div class=\"header-deets\">\n" +
                "        <div class=\"acc-details\">\n" +
                "            <span class=\"acc-span-deets\">Sold:</span>\n" +
                "            <span class=\"acc-span-deets\">KSHS 0</span>\n" +
                "        </div>\n" +
                "        <div class=\"acc-details\">\n" +
                "            <span class=\"acc-span-deets\">Bought:</span>\n" +
                "            <span class=\"acc-span-deets\">KSHS 0</span>\n" +
                "        </div>\n" +
                "        <div class=\"acc-details\">\n" +
                "            <span class=\"acc-span-deets\">Totals:</span>\n" +
                "            <span class=\"acc-span-deets\">KSHS 0</span>\n" +
                "        </div>\n" +
                "    </div>\n";
        htmlContent += "    <div class=\"sectionDeets\">\n";

        // if user accessing this page is an admin then we add the add user button
        if(GlobalBean.getUserType().name().equals("ADMIN")){
            htmlContent+="        <h3 onclick=\"openModal('element')\">Add User</h3>\n" ;
        }else{
            htmlContent+= "        <h3>Recent Activity</h3>\n" ;
        }
            //    htmlContent+="<input type=\"text\" id=\"search\" class=\"search-box\" name=\"search\" onchange=\"search(this)\" placeholder=\"Enter Product Name\">";
               htmlContent+=
                "        <select class=\"logFilters\" onchange=\"getFeature(this,'"+dataClass.getSimpleName()+"')\">\n" +
                "            <option>Choose   </option>\n";
        for (Field field : fields) {
            htmlContent += "<option>" + field.getName() + "</option>\n";
        }
        htmlContent += "</select>\n" +
                "        <h3 class=\"export\" onclick=\"exportReport('" + GlobalBean.getEndpoint()
                + "')\">Export Report</h3>\n"
                +
                "    </div>\n";
        // htmlContent+=myModal(User.class,false);
        return htmlContent;
    }

    public static String getForgotPasString(){
        String htmlCode = 
                "<form action=\"./sign\" method=\"POST\" id=\"login\" class=\"login-input-group\">\n" +
                "    <div class=\"loginDiv\">\n" +
                "        <jsp:useBean id=\"LoginForm\" class=\"com.servlet.app.bean.LoginForm\" scope=\"page\" />\n" +
                "        <label class=\"form-label\">Enter your Email:</label>\n" +
                "        <div class=\"input-detail\">\n" +
                "            <input id=\"email\" placeholder=\"<jsp:getProperty name='LoginForm' property='usernamePLaceholder' />\"\n" +
                "                type=\"email\" name=\"email\" class=\"input-box\" onkeyup=\"checkFormValidation(event)\"><br>\n" +
                "        </div>\n" +
                "        <label class=\"form-label\">Enter your Password:</label>\n" +
                "        <div class=\"input-detail\">\n" +
                "            <input id=\"password\" placeholder=\"Enter your password\" name=\"password\" class=\"input-box\"\n" +
                "                onchange=\"checkFormValidation(event)\" onkeyup=\"checkFormValidation(event)\" type=\"password\"><br><i\n" +
                "                class=\"uil uil-eye\" id=\"openPass\" onclick=\"hidePass('password','pass')\"></i><i class=\"uil uil-eye-slash\"\n" +
                "                onclick=\"showPass('password','pass')\" id=\"eyeClosedPass\"></i>\n" +
                "        </div>\n" +
                "        <input type=\"submit\" id=\"submit\" class=\"btn-submit\"><br>\n" +
                "        <p onclick=\"window.location.href='forgotPass.jsp'\" class=\"forgotPass\">Forgot Password</p>\n" +
                "    </div>\n" +
                "</form>";
        return htmlCode;
    }
    @Override
    public ServletContext getServletContext() {
        // TODO Auto-generated method stub
        return super.getServletContext();
    }
}
