package com.servlet.action;

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

@WebServlet(urlPatterns = "/home")
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
        if (httpSession != null) {
            String session = (String) httpSession.getAttribute("loggedInId");
            if (StringUtils.isNotBlank(session)) {
                printWriter.write("<html>\n");
                printWriter.write("<body>\n");

                printWriter.write("<br/>\n");
             

                String htmlPage = "<form action=\"./produce\" enctype=\"multipart/form-data\" method=\"POST\">\n" +
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
                        "                <textarea placeholder=\"Please type in a description\" name=\"prodDescription\"></textarea>\n"
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
                        "                <div class \"user\">\n" + 
                        "                    <label>Product Quantity (Kilos):</label>\n" +
                        "                    <input type=\"number\" placeholder=\"E.g. 20...\" name=\"prodQuantity\"/>\n"
                        +
                        "                </div>\n" +
                        "            </div>\n" +
                        "            <input type=\"submit\" value=\"Submit\" class=\"submit\" name=\"submit\"/>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</form>\n";


                printWriter.write("</body>\n");
                printWriter.write("</html>\n");

                new AppPage().renderHtml(req, resp, 0, htmlPage);
            } else {
                resp.sendRedirect("/");
            }
        } else {
            // if the session is null then redirect them to the login page

            // resp.sendRedirect("./login");
        }
    }
}
