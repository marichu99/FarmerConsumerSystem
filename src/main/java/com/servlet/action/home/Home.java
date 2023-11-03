package com.servlet.action.home;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.servlet.view.html.AppPage;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter printWriter = resp.getWriter();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        resp.sendRedirect("./app/Home.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        PrintWriter printWriter = resp.getWriter();
        // TODO Auto-generated method stub
        HttpSession httpSession = req.getSession();
        String session = (String) httpSession.getAttribute("loggedInId");
        if (StringUtils.isNotBlank(session)) {
            printWriter.write("<b>Welcome to the Home Page " + ctx.getAttribute("email") + "</b>+");
            printWriter.write("<br/>");
            printWriter.write("\n" +
                    "You can log out here <a href = \"./logout\"> Logout </a>");
            String htmlPage = "<form action=\"products.php\" enctype=\"multipart/form-data\" method=\"POST\">\n" +
                    "    <div class=\"row\">\n" +
                    "        <div class=\"col\">\n" +
                    "            <h3 class=\"title\">Product Details</h3>\n" +
                    "            <a href=\"customerDash.php\">Dashboard</a>\n" +
                    "            <div class=\"user\">\n" +
                    "                <label>Product Name</label>\n" +
                    "                <input type=\"text\" placeholder=\"E.g. Names...\" name=\"prodName\"/>\n" +
                    "            </div>\n" +
                    "            <div class=\"user\">\n" +
                    "                <label>Product Description:</label>\n" +
                    "                <input type=\"text-area\" placeholder=\"Please type in a description\" name=\"prodDescription\"/>\n"
                    +
                    "            </div>\n" +
                    "            <div class=\"user\">\n" +
                    "                <label>Select Image:</label>\n" +
                    "                <input type=\"file\" value=\"Select an Image\" name=\"prodImg\"/>\n" +
                    "            </div>\n" +
                    "            <div class=\"user\">\n" +
                    "                <label>Product Price Per Kilo:</label>\n" +
                    "                <input type=\"number\" placeholder=\"Enter Price per product\" name=\"prodPrice\"/>\n"
                    +
                    "            </div>\n" +
                    "            <div class=\"flex\">\n" +
                    "                <div class=\"user\">\n" +
                    "                    <label>Country:</label>\n" +
                    "                    <input type=\"text\" placeholder=\"Kenya\" name=\"prodCountry\"/>\n" +
                    "                </div>\n" +
                    "                <div class=\"user\">\n" +
                    "                    <label>Product Location:</label>\n" +
                    "                    <input type=\"text\" placeholder=\"E.g. New York\" name=\"prodLocation\"/>\n" +
                    "                </div>\n" +
                    "                <div class=\"user\">\n" +
                    "                    <label>Product Quantity (Kilos):</label>\n" +
                    "                    <input type=\"number\" placeholder=\"E.g. 20...\" name=\"prodQuantity\"/>\n" +
                    "                </div>\n" +
                    "            </div>\n" +
                    "            <input type=\"submit\" value=\"Submit\" class=\"submit\" name=\"submit\"/>\n" +
                    "    </div>\n" +
                    "</form>";

            new AppPage().renderHtml(req, resp, 0, htmlPage);
        } else {
            resp.sendRedirect("/");
        }
    }
}
