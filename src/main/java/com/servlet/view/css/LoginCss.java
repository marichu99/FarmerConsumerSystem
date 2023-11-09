package com.servlet.view.css;

import java.io.Serializable;

public class LoginCss implements Serializable{
    private String cssStyles = "<style>" +
    "*{" +
    "    margin: 0;" +
    "    padding: 0;" +
    "}" +
    "body .marichu{" +
    "    height: 100%;" +
    "    width: 100%;" +
    "    background: linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)), url(\"../images/background.jpg\");" +
    "    background-size: cover;" +
    "    background-position: center;" +
    "    position: absolute;" +
    "    align-items: center;" +
    "    display: flex;" +
    "    justify-content: center;" +
    "}" +
    ".button-box{" +
    "    width: 220px;" +
    "    margin-left: 20px;" +
    "    margin-top: 40px;" +
    "    box-shadow: 0 0 20px 9px #ff61241f;" +
    "    position: relative;" +
    "    border-radius: 30px;" +
    "    margin-bottom: 0;" +
    "}" +
    ".toggle-btn{" +
    "    padding: 10px 30px;" +
    "    cursor: pointer;" +
    "    background: transparent;" +
    "    border: 0;" +
    "    outline: none;" +
    "    position: relative;" +
    "}" +
    "#buttonz{" +
    "    top: 0;" +
    "    left: 0;" +
    "    position: absolute;" +
    "    width: 110px;" +
    "    height:100%;" +
    "    background: linear-gradient(to right ,#ff105d,#ffad06);" +
    "    border-radius: 30px;" +
    "    transition: .5s;" +
    "}" +
    ".login{" +
    "    width: 40%;" +
    "    height: 90%;" +
    "    box-shadow: 0 0 3px 0 rgba(0,0,0,0.3);" +
    "    padding: 20px;" +
    "    border-radius: 10px;" +
    "    position: relative;" +
    "    background: #fff;" +
    "    overflow: hidden;" +
    "}" +
    "#confirmOtp{" +
    "    height: 25px;" +
    "    width: 100px;" +
    "    border-radius: 12px;" +
    "    background: grey;" +
    "    transition: transform .5s;" +
    "    text-transform: uppercase;" +
    "}" +
    "#confirmOtp:hover{" +
    "    transform: scale(1.1);" +
    "    color: aliceblue;" +
    "    background-color: rgb(44, 43, 43);" +
    "}" +
    ".submitForm{" +
    "    margin: 0;" +
    "}" +
    ".input-box{" +
    "    border-radius: 10px;" +
    "    padding: 10px;" +
    "    bottom: 0;" +
    "    margin: 5px 0;" +
    "    margin-right: 10px;" +
    "    margin-left: 20px;" +
    "    width: 50%;" +
    "    border: 1px solid #ff105d;" +
    "    outline: none;" +
    "}" +
    ".loginDiv{" +
    "    margin-top: 40px;" +
    "}" +
    "a:hover{" +
    "    color:red;" +
    "}" +
    ".btn-submit{" +
    "    background: linear-gradient(to right, #ff105d, #ffad06);" +
    "    width: 50%;" +
    "    padding: 10px;" +
    "    border-radius: 20px;" +
    "    font-size: 15px;" +
    "    margin-top: 20px;" +
    "    margin-left: 20px;" +
    "    border:none;" +
    "    outline: none;" +
    "    cursor: pointer;" +
    "}" +
    "/*  */" +
    "#login{" +
    "    left: 50px;" +
    "}" +
    "#signup{" +
    "    margin-left: 15px;" +
    "}" +
    ".input-group{" +
    "    top:20px;" +
    "    position: absolute;" +
    "    transition: .5s;" +
    "    margin-left: 20px;" +
    "    width: 65%;" +
    "}" +
    ".signBtn{" +
    "    background: linear-gradient(to right, #ff105d, #ffad06);" +
    "    width: 50%;" +
    "    padding: 10px;" +
    "    border-radius: 20px;" +
    "    font-size: 15px;" +
    "    margin: 10px;" +
    "    border:none;" +
    "    outline: none;" +
    "    cursor: pointer;" +
    "    font-size: large;" +
    "    font-weight: 200;" +
    "}" +
    ".navbar{" +
    "    width: 85%;" +
    "    padding: 30px;" +
    "    margin-left: 95px;" +
    "    justify-content: space-between;" +
    "    display: flex;" +
    "    align-items: center;" +
    "    gap: 10px;" +
    "}" +
    ".navbar span{" +
    "    font-size: large;" +
    "    padding: 20px;" +
    "    font-weight: bold;" +
    "    color: rgb(4, 8, 12);" +
    "    border-radius: 10px;" +
    "    background-color: rgb(199, 253, 253);" +
    "}" +
    ".navbar ul li{" +
    "    text-decoration: none;" +
    "    display: inline;" +
    "    padding: 20px;" +
    "    font-weight: bold;" +
    "    color: rgb(9, 16, 22);" +
    "}" +
    ".navbar ul li:hover{" +
    "    background-color: brown;" +
    "    transition: .5s;" +
    "    border-radius: 20px;" +
    "}" +
    ".navbar ul li a:hover {" +
    "    color: aliceblue;" +
    "}" +
    ".navbar ul li a{" +
    "    text-decoration: none;" +
    "    color: rgb(9, 16, 22);" +
    "}" +
    ".navbar ul li a i{" +
    "    font-size: larger;" +
    "}" +
    ".content{" +
    "    width: 100%;" +
    "    position: absolute;" +
    "    top: 50%;" +
    "    transform: translateY(-50%);" +
    "    text-align: center;" +
    "    color: rgb(129, 158, 184);" +
    "}" +
    ".button{" +
    "    width: 150px;" +
    "    margin: 20px 10px;" +
    "    padding: 15px 0;" +
    "    border: 2px solid brown;" +
    "    border-radius: 25px;" +
    "    background: transparent;" +
    "    text-align: center;" +
    "    font-weight: bold;" +
    "    color: rgb(166, 201, 231);" +
    "}" +
    "nav .fa{" +
    "    display: none;" +
    "}" +
    "/* styles the form labels */" +
    ".form-label{" +
    "    padding: 5px 10px;" +
    "}" +
    "/* styling the error messages */" +
    "#firstSignValid{" +
    "    flex-direction: row;" +
    "}" +
    "/* styling divs in the sign up and login forms */" +
    ".input-detail{" +
    "    display: flex;" +
    "    flex-direction: row;" +
    "}" +
    ".input-detail i{" +
    "    font-size: 25px;" +
    "    text-align: center;" +
    "    padding-top: 5px;" +
    "}" +
    "#openPass ,#openPassConfirm{" +
    "    display: none;" +
    "}" +
    "#eyeClosedPass{" +
    "    display: flex;" +
    "}" +
    ".loginLink{" +
    "    padding: 20px;" +
    "}" +
    "/* style the login form */" +
    ".loginContainer{" +
    "    width: 30%;" +
    "    height: 70%;" +
    "    box-shadow: 0 0 3px 0 rgba(0,0,0,0.3);" +
    "    padding: 20px;" +
    "    border-radius: 10px;" +
    "    position: relative;" +
    "    background: #fff;" +
    "    overflow: hidden;" +
    "}" +
    "/* style the input group of the login form */" +
    ".login-input-group{" +
    "    top: 100px;" +
    "}" +
    "/* style the forgot password text */" +
    ".forgotPass{" +
    "    margin-left: 30px;" +
    "    margin-top: 20px;" +
    "    text-transform: uppercase;" +
    "    cursor: pointer;" +
    "}" +
    "/* style for the otp div */" +
    ".sendOtp{" +
    "    padding: 10px 15px;" +
    "}" +
    "@media only screen and (max-width :700px){" +
    "   .loginContainer{" +
    "       width: 68%;" +
    "   }" +
    "   .input-group{" +
    "       margin-left: 5px;" +
    "       width: 90%;" +
    "   }" +
    "   .login{" +
    "        width: 70%;" +
    "        height: 75%;" +
    "   }" +
    "}" +
    "</style>";

    public String getCssStyles() {
        return cssStyles;
    }

    public void setCssStyles(String cssStyles) {
        this.cssStyles = cssStyles;
    }    
    
}
