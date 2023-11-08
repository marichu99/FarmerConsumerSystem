package com.servlet.view.html;

public class UserProfile {
    private String userProfile =   "    <!-- div for users -->\n" +
    "    <section class=\"farm_produce\" id=\"allUsers\">        \n" +
    "        <h3 id=\"userHead\">Featured Farm Products</h3>\n" +
    "        \n" +
    "        <div class=\"prod_row\" id=\"users\">\n" +
    "            <form action=\"profileUpload.php\" enctype=\"multipart/form-data\" method=\"POST\" >\n" +
    "                    <div class=\"row\">\n" +
    "                        <div class=\"col\">\n" +
    "                            <h3 class=\"title\" onclick=\"window.location.href='productDetail.php'\">Please Provide us with more details</h3>\n" +
    "                            <div class=\"profileHeader\">\n" +
    "                                <div class=\"userDetails\">\n" +
    "                                    <h2></h2>\n" +
    "                                    <p></p>\n" +
    "                                    \n" +
    "                                </div>\n" +
    "                                <div class=\"userImage\">\n" +
    "                                    <!-- check whether the user has uploaded the photos -->\n" +
    "\n" +
    "                                    <div class=\"profilePic\">\n" +
    "                                        <img src=\"images/>\" alt=\"\" id=\"pic\">\n" +
    "                                    </div>\n" +
    "                                    <!-- else -->\n" +
    "                                    <div class=\"profilePic\">\n" +
    "                                        <img src=\"images/profile.jpg\" alt=\"\" id=\"pic\">\n" +
    "                                    </div>\n" +
    "                                    <input type=\"file\" id=\"upload\" accept=\"Image/*\" onchange=\"readURL(this)\" value=\"Select an Image\" name=\"userIMG\"/>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                            <div class=\"details\">\n" +
    "                                <div>\n" +
    "                                    <div class=\"user\">\n" +
    "                                        <label>Change your Password</label>\n" +
    "                                        <input type=\"password\" placeholder=\"Enter your password\" name=\"password\" id=\"password\"/>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"user\">\n" +
    "                                        <label>Confirm your Password</label>\n" +
    "                                        <input type=\"password\" placeholder=\"Confirm your Password\" name=\"passwordRe\" id=\"passwordRE\"/>\n" +
    "                                    </div>\n" +
    "                                    \n" +
    "                                    <div class=\"flex\">\n" +
    "                                        <div class=\"user\">\n" +
    "                                        <input type=\"submit\" value=\"SUBMIT CHANGES\" class=\"submit\" name=\"submit\">\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                                <div>\n" +
    "                                    <div class=\"user\">\n" +
    "                                        <label id=\"passError\"></label>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"user\">\n" +
    "                                        <label id=\"passConfirm\"></label>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"flex\">\n" +
    "                                        <div class=\"user\">\n" +
    "                                        <input type=\"submit\" value=\"DELETE ACCOUNT\" class=\"submit\" name=\"delete\" id=\"delete\">\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                          </div>\n" +
    "                                \n" +
    "                    </div>\n" +
    "\n" +
    "            </form>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </section>\n";

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }
        
}
