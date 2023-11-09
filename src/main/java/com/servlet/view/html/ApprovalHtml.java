package com.servlet.view.html;

import java.io.Serializable;

public class ApprovalHtml  implements Serializable{
    private String approvaString =  "    <!-- div for approvals -->\n" +
    "    <section class=\"farm_produce\" id=\"approvalSect\">                                            \n" +
    "            <div class=\"prod_row\" id=\"usersApproval\">\n" +
    "                <div class=\"main\" id=\"main\"> \n" +
    "                    <form>\n" +
    "\n" +
    "                        <div class=\"row\">\n" +
    "                            <div class=\"col\">\n" +
    "                                <h3 class=\"title\" onclick=\"window.location.href='productDetail.php'\"> YOUR APPROVAL STATUS IS: </h3>\n" +
    "                                <div class=\"detailsApproved\">\n" +
    "                                    <h3 class=\"mode\"><img src=\"icons/check.svg\" class=\"icons\" id=\"checked\" />Approved</h3>\n" +
    "                                </div>\n" +
    "                                <div class=\"detailsApproved\">\n" +
    "                                    <span>Dear @ </span><br/>\n" +
    "                                    <p>Your details have been approved and you can <a href=\"sell.php\">sell</a> on the platform.</p>\n" +
    "                                </div>\n" +
    "                                \n" +
    "                                <div class=\"detailsApproved\">\n" +
    "                                    <h3 class=\"modeNot\"><img src=\"icons/times.svg\" class=\"icons\" id=\"checked\" /></i>REJECTED</h3>\n" +
    "                                </div>\n" +
    "                                <div class=\"detailsApproved\">\n" +
    "                                    <span>Dear @ </span><br/>\n" +
    "                                    <p>Your request for seller approval has been rejected by the admin. If you wish to appeal kindly reach out to them @ ukulimabora44@gmail.com</p>\n" +
    "                                </div>\n" +
    "                             \n" +
    "                                <p>You can request for a seller's approval at the <a href=\"sell.php\">sell</a> on the platform.</p>\n" +
    "                            </div>                                                \n" +
    "                        </div>      \n" +
    "                    </form>      \n" +
    "                </div>\n" +
    "            </div>                \n" +
    "    </section>\n" ;

    public String getApprovaString() {
        return approvaString;
    }

    public void setApprovaString(String approvaString) {
        this.approvaString = approvaString;
    }
    
    
}
