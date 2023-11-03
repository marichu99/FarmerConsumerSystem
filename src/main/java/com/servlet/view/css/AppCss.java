package com.servlet.view.css;

import java.io.Serializable;

public class AppCss implements Serializable{
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
    "</style>";

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
    
}
