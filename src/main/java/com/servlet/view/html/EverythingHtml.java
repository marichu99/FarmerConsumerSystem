package com.servlet.view.html;

public class EverythingHtml{
    private String allHtml = "<div class=\"dashboard\">\n" +
    "    <!-- div for the top level stuff -->\n" +
    "    <div class =\"top\">\n" +
    "        <div class=\"search-box\">\n" +
    "        <img src=\"icons/user-circle.jpg\" class=\"icon\"/>\n" +
    "        <span></span>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "    <!-- div for the header content -->\n" +
    "    \n" +
    "    <!-- div for sign up to users -->\n" +
    "\n" +
    "    <!-- div for products -->\n" +
    "    <section class=\"farm_produce\" id=\"farms\">        \n" +
    "        <h3>Featured Farm Products</h3>\n" +
    "        <div class=\"prod_row\" id=\"farm_produces\">\n" +
    "            <!-- all products -->\n" +
    "\n" +
    "            <div class=\"prod_item\">                            \n" +
    "                <img src='prodIMG/' class=\"image_prod\"/><br/>\n" +
    "                <span class=\"prodName\"></span><br/>\n" +
    "                <span class=\"prodLocation\"></span><br/>\n" +
    "                <span class=\"prodPrice\"></span><br/>\n" +
    "            </div>\n" +
    "          \n" +
    "    </div>\n" +
    "    \n" +
    " </section>         \n" +
  
    "    <!-- div for ?PurchaseApprovals? -->\n" +
    "    <section class=\"farm_produce\" id=\"approvalSect\">        \n" +
    "    <h3 id=\"userHead\">Request for Sell Approval</h3>                    \n" +
    "        <div class=\"prod_row\" id=\"PurchaseApprovals\">                  \n" +
    "          <!-- all products -->\n" +
    "\n" +
    "            <div class=\"prod_item\">\n" +
    "                <span></span>\n" +
    "                <img src='prodIMG/' class=\"image_prod\"/><br/>\n" +
    "                <span class=\"prodName\">Buyer Name:</span><br/>              \n" +
    "                 \n" +
    "                <div className=\"fpRating\">\n" +
    "                    <button class=\"approveUser\" onclick=\"window.location.href=''\">APPROVE SALE</a></button>\n" +
    "                    <button class=\"rejectUser\" onclick=\"window.location.href=''\">REJECT SALE</a></button><BR/>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "                              \n" +
    "        </div>\n" +
    "    \n" +
    "    </section>\n" +
    "\n" +
    "</div>";

    public String getAllHtml() {
        return allHtml;
    }

    public void setAllHtml(String allHtml) {
        this.allHtml = allHtml;
    }

    
    

}