package com.servlet.view.css;

import java.io.Serializable;

public class AppCss implements Serializable {
    private String style = "<style>" +
            "body{" +
            "    min-height: 100vh;" +
            "    background-color: aliceblue;" +
            "    display:flex;" +
            "    justify-content:space-between;" +
            "    flex-direction: row;" +
            "}" +
            ".navlets{" +
            "    display: flex;" +
            "    flex-direction: row;" +
            "    position: relative;" +
            "    top: 0;" +
            "    left: 0;" +
            "    height: 100%;" +
            "    width: 100%;" +
            "}" +
            ".nav{" +
            "    display: flex;" +
            "    flex-direction: column;" +
            "    width: 250px;" +
            "    border-right: 1px solid grey;" +
            "    transition: 1.5s;" +
            "}" +
            ".bodySection{" +
            "    display:flex;" +
            "    flex-direction: column; " +
            "    width:50%"+
            "}" +
            ".prodDetails{" +
            "    display:flex;" +
            "    flex-wrap:wrap;"+
            "}" +
            ".topSection {" +
                "display: flex;" +
                "justify-content: space-between;" +
                "gap: 40px;" +
            "}" +
            ".button {\n" +
                "  background-color: #04AA6D; /* Green */\n" +
                "  border-radius: 10px;" +
                "  color: white;\n" +
                "  padding: 10px 15px;" +
                "  text-align: center;\n" +
                "  text-decoration: none;\n" +
                "  display: inline-block;\n" +
                "  font-size: 16px;\n" +
            "}"+
            ".button:hover {\n" +
                "  background-color: #04AA6D; /* Green */\n" +
                "  color: white;\n" +
            "}"+
            ".navClose{" +
            "    width: 75px;" +
            "}" +
            ".logoName{" +
            "    padding: 10px;" +
            "    margin: 10px;" +
            "    margin-left: 45px;" +
            "    margin-bottom: 5px;" +
            "    justify-content: center;" +
            "}" +
            ".logo_name{" +
            "    font-family: sans-serif;" +
            "    font-size: 25px;" +
            "    font-weight: bolder;" +
            "    left: 20px;" +
            "}" +
            ".menu-items{" +
            "    top: 60px;" +
            "    /* background-color: rgb(253, 180, 180); */" +
            "    border-radius: 20px;" +
            "    height: calc(100vh - 75px);" +
            "    margin: 5px;" +
            "    display: flex;" +
            "    flex-direction: column;" +
            "    justify-content: space-between;" +
            "}" +
            ".menu-items ul li a{" +
            "    text-decoration: none;" +
            "}" +
            ".menu-items ul li{" +
            "    list-style: none;" +
            "    padding: 10px;" +
            "    margin: 10px;" +
            "}" +
            ".menu-items ul li a:hover .link-name," +
            ".menu-items ul li a:hover .icon{" +
            "    color: grey;" +
            "}" +
            ".approvals{" +
            "    padding: 5px 10px;" +
            "    border-radius: 20px;" +
            "    background-color: brown;" +
            "    color: whitesmoke;" +
            "    font-weight: bold;" +
            "    font-size: large;" +
            "    text-align: center;" +
            "    text-transform: uppercase;" +
            "}" +
            "headerH3{" +
            "   height: 34px;" +
            "}" +
            ".link-name{" +
            "    font-family: sans-serif;" +
            "    font-size: large;" +
            "    color: black;" +
            "    font-weight: bold;" +
            "    outline: none;" +
            "    border: none;" +
            "    background: none;" +
            "}" +
            ".icon{" +
            "    font-size: 15px;" +
            "    min-width: 29px;" +
            "    height: 25px;" +
            "    color: grey;" +
            "    cursor: pointer;" +
            "}" +
            ".dashboard{" +
            "    height: 100vh;" +
            "    /* background-color: blanchedalmond; */" +
            "    width: 70%;" +
            "    margin: 15px;" +
            "}" +
            ".dashboard .top{" +
            "    display: flex;" +
            "    justify-content: space-between;" +
            "    padding: 10px 14px;" +
            "}" +
            ".search-box{" +
            "    border: none;" +
            "    height: 35px;" +
            "    border-radius: 5px;" +
            "    padding: 8px 14px;" +
            "}" +
            ".input-box{" +
            "    outline: none;" +
            "    position: relative;" +
            "    height: 28px;" +
            "    border: none;" +
            "    background-color: aliceblue;" +
            "    text-align: center;" +
            "}" +
            ".top{" +
            "    height: 50px;" +
            "}" +
            ".acc-details{" +
            "    height: 100px;" +
            "    width: 200px;" +
            "    background-color: rgb(250, 229, 229);" +
            "    border-radius: 15px;" +
            "    transition: transform .5s;" +
            "    display: flex;" +
            "    flex-direction: column;" +
            "}" +
            ".acc-details:hover{" +
            "    transform: scale(1.1);" +
            "    box-shadow: 1px solid grey;" +
            "}" +
            ".header-deets{" +
            "    display: flex;" +
            "    flex-direction:row;" +
            "    justify-content: space-between;" +
            "    margin-left: 100px;" +
            "    margin-right: 100px;" +
            "    margin-top: 50px;" +
            "}" +
            ".header-deets .acc-span-deets{" +
            "    position: relative;" +
            "    top: 1px;" +
            "    padding:  3px;" +
            "    margin: 8px;" +
            "    margin-top: 10px;" +
            "    font-family: sans-serif;" +
            "    font-size: large;" +
            "    font-weight: 10px;" +
            "}" +
            ".recentContainer{" +
            "    display: flex;" +
            "    justify-content: space-between;" +
            "    align-items: center;" +
            "    flex-direction: row;" +
            "    margin: 25px;" +
            "    padding: 10px 15px;" +
            "}" +
            ".recentTitle{" +
            "    font-weight: bold;" +
            "    font-size: large;" +
            "    font-family: serif;" +
            "}" +
            ".recent{" +
            "    display: flex;" +
            "    flex-direction: column;" +
            "}" +
            ".recenData{" +
            "    padding: 8px;" +
            "    font-size: 15px;" +
            "}" +
            ".sectionDeets{" +
            "    display: flex;" +
            "    justify-content: space between;" +
            "}" +
            ".sectionDeets h3{" +
            "    background-color: rgb(192, 192, 253);" +
            "    color: white;" +
            "    padding: 14px;" +
            "    width: 150px;" +
            "    border-radius: 15px;" +
            "    margin: 15px;" +
            "}" +
            ".sectionDeets select{" +
            "    position: relative;" +
            "    height: 5vh;" +
            "    top: 30px;" +
            "}" +
            ".myTable{" +
            "    width: 100%;" +
            "}" +
            ".myTable td{" +
            "    text-align: left;" +
            "}" +
            ".myTable th{" +
            "    text-align: left;" +
            "    background-color: rgb(252, 152, 152);" +
            "}" +
            ".myTable .key{" +
            "    border-radius: 12px;" +
            "    background-color: rgb(243, 121, 121);" +
            "}" +
            ".navContainer{" +
            "    width: 20%;" +
            "}" +
            // CSS FOR THE ADD TO CART PAGE
            ".recentContainer{\n" +
            "    margin-left: 40px;\n" +
            "    padding: 10px 15px;\n" +
            "    margin-right: 100px;\n" +
            "}\n" +
            ".recentTitle{\n" +
            "    font-weight: bold;\n" +
            "    font-size: large;\n" +
            "    font-family: serif;\n" +
            "}\n" +
            ".recent{\n" +
            "    display: flex;\n" +
            "    flex-direction: column;\n" +
            "}\n" +
            ".recenData{\n" +
            "    padding: 8px;\n" +
            "    font-size: 15px;\n" +
            "}\n" +
            ".myTable{\n" +
            "    width: 50%;\n" +
            "}\n" +
            ".myTable td{\n" +
            "    text-align: center;\n" +
            "    padding: 5px 15px;\n" +
            "}\n" +
            ".myTable th{\n" +
            "    text-align: center;\n" +
            "    padding: 8px 15px;\n" +
            "    background-color: rgb(252, 152, 152);\n" +
            "}\n" +
            ".image_prod{\n" +
            "    width: 200px;\n" +
            "    height: 150px;\n" +
            "    border-radius: 20px;\n" +
            "}\n" +
            ".numQuantity{\n" +
            "    width: 150px;\n" +
            "    height: 34px;\n" +
            "    border-radius: 10px;\n" +
            "    padding: 8px 14px;\n" +
            "}\n" +
            ".myTable i{\n" +
            "    color: red;\n" +
            "    font-size: 30px;\n" +
            "    text-transform: uppercase;\n" +
            "    transition: transform .5s;\n" +
            "    cursor: pointer;\n" +
            "}\n" +
            ".myTable i:hover{\n" +
            "    transform: scale(1.1);\n" +
            "}\n" +
            ".Container{\n" +
            "    display: flex;\n" +
            "    flex-direction: row;\n" +
            "    flex-wrap: wrap;\n" +
            "}\n" +
            ".checkout{\n" +
            "    display: flex;\n" +
            "    align-items: center;\n" +
            "    justify-content: center;\n" +
            "    flex-direction: column;\n" +
            "    border-radius: 10px;\n" +
            "    background-color: bisque;\n" +
            "    height: 200px;\n" +
            "    margin: 15px;\n" +
            "    padding: 8px 10px;\n" +
            "}\n" +
            ".submit{\n" +
            "    width: 100%;\n" +
            "    font-size: 17px;\n" +
            "    color: white;\n" +
            "    cursor: pointer;\n" +
            "    background-color: rgb(99, 87, 87);\n" +
            "    border-radius: 10px;\n" +
            "    text-align: center;\n" +
            "    height: 34px;\n" +
            "    font-family: 'Times New Roman', Times, serif;\n" +
            "    text-transform: uppercase;\n" +
            "    transition: transform .5s;\n" +
            "}\n" +
            ".submit:hover{\n" +
            "    background-color: rgb(36, 35, 35);\n" +
            "    transform: scale(0.9);\n" +
            "}\n" +
            "#errText{\n" +
            "    position: relative;\n" +
            "}\n" +
            ".priceText{\n" +
            "    font-size: 30px;\n" +
            "    font-weight: 700;\n" +
            "    color: rgb(12, 95, 12);\n" +
            "    text-align: center;\n" +
            "    text-transform: uppercase;\n" +
            "    padding: 15px;\n" +
            "}\n" +
            "@media only screen and (max-width: 700px){\n" +
            "    .myTable{\n" +
            "        width: 30%;\n" +
            "    }\n" +
            "    .image_prod{\n" +
            "        width: 142px;\n" +
            "        height: 130px;\n" +
            "    }\n" +
            "    .numQuantity {\n" +
            "        width: 90px;\n" +
            "    }\n" +
            "    .recentContainer{\n" +
            "        margin-left: 3px;\n" +
            "    }\n" +
            "}"+
            // CSS FOR THE PRODUCT FORMS
            " {" +
            "    display: flex;" +
            "    justify-content: center;" +
            "    align-items: center;" +
            "    background: linear-gradient( rgba(88, 88, 88, 0.2),rgba(182, 180, 180, 0.4));" +
            "    min-height: 100vh;" +
            "    padding-top: 20px;" +
            "    padding-bottom: 10px;" +
            "}" +
            "  form{" +
            "    background-color: white;" +
            "    border-radius: 20px;" +
            "    padding: 20px;" +
            "    width: 500px;" +
            "}" +
            "  form .row{" +
            "    display: flex;" +
            "    flex-wrap: wrap;" +
            "    gap: 15px;" +
            "}" +
            "  form .row .col{" +
            "    flex: 1 1 250px;" +
            "}" +
            "  form .row .col .title{" +
            "    font-size: 20px;" +
            "    color: black;" +
            "    text-transform: uppercase;" +
            "}" +
            "  form .row .col .user{" +
            "    margin: 10px 0;" +
            "    display: flex;" +
            "    flex-direction: column;" +
            "    padding: 5px 12px;" +
            "}" +
            "  form .row .col .user label{" +
            "    margin-bottom: 5px;" +
            "}" +
            "  form .row .col .user input{" +
            "    width: 100%;" +
            "    border: 1px solid grey;" +
            "    padding: 10px 15px;" +
            "    font-size: 15px;" +
            "    text-transform: none;" +
            "    border-radius: 10px;" +
            "}" +
            "  form .row .col .user input:focus{" +
            "    border: 1px solid black;" +
            "}" +
            "  form .row .col .flex{" +
            "    display: flex;" +
            "    justify-content: space-between;" +
            "}" +
            "  form .submit{" +
            "    width: 100%;" +
            "    font-size: 17px;" +
            "    color: white;" +
            "    cursor: pointer;" +
            "    background-color: rgb(99, 87, 87);" +
            "    border-radius: 10px;" +
            "    height: 34px;" +
            "    font-family: 'Times New Roman', Times, serif;" +
            "    text-transform: uppercase;" +
            "    transition: transform .5s;" +
            "}" +
            "  form .submit:hover{" +
            "    background-color: rgb(36, 35, 35);" +
            "    transform: scale(0.9);" +
            "}" +
            "input.message{" +
            "    height: 80px;" +
            "}" +
            ".farm_produce{" +
            "    width: 70%;" +
            "    padding-top: 10px;" +
            "    text-align: center;" +
            "    margin: 10px;" +
            "}" +
            ".users{" +
            "    width: 60%;" +
            "    padding-top: 10px;" +
            "    text-align: center;" +
            "    margin: auto;" +
            "    display:none;" +
            "}" +
            ".prod_row{" +
            "    margin-top: 5%;" +
            "    display: none;" +
            "    justify-content: space-between;" +
            "    padding-bottom: 0;" +
            "    flex-wrap: wrap;" +
            "}" +
            ".prod_row{" +
            "    margin-top: 5%;" +
            "    display: flex;" +
            "    justify-content: space-between;" +
            "    flex-direction: column;" +
            "    flex-wrap: wrap;" +
            "}" +
            ".prod_item{" +
            "    flex: 1;" +
            "    gap: 10px;" +
            "    padding: 0;" +
            "    margin: 10px;" +
            "    text-align: start;" +
            "    transition: transform .5s;" +
            "}" +
            ".prod_item:hover{" +
            "    transform: scale(1.1);" +
            "}" +
            ".image_prod{" +
            "    width: 200px;" +
            "    height: 150px;" +
            "    border-radius: 20px;" +
            "}" +
            ".prodName{" +
            "    font-weight: bold;" +
            "    font-size: 20px;" +
            "}" +
            ".prodLocation{" +
            "    font-weight: 300;" +
            "    font-size: 15px;" +
            "    font-size: small;" +
            "}" +
            ".prodPrice{" +
            "    font-weight: bold;" +
            "    font-size: 15px;" +
            "    color: dark-blue;" +
            "}" +
            ".farm_produce h1{" +
            "    font-size: 50px;" +
            "    font-weight: bold;" +
            "    font-style: normal;" +
            "}" +

            "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

}
