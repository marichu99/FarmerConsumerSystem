package com.servlet.view.html;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.view.css.AppCss;
import com.servlet.view.toolbar.TopBar;

public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest req, HttpServletResponse resp,
            int activeMenu, String content, String optionalCss) throws IOException {

        HttpSession session = req.getSession();

        ServletContext ctx = req.getServletContext();

        PrintWriter print = resp.getWriter();
        print.write("<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
        
                new AppCss().getStyle());
        print.write("<link rel='stylesheet' href='https://unicons.iconscout.com/release/v4.0.0/css/line.css'>"+
                        "</head>" +
                        "<body>" +

                new TopBar().menu(activeMenu) +
                "<div class=\"bodySection\">" +
                        "<div class=\"topSection\">" +
                        "<h3 class =\"headerH3\">" + ctx.getInitParameter("AppName") + "<h3>" +
                        "<br/>&nbsp;<br/>" +
                        "<h3 class=\"headerH3\">Welcome: " + session.getAttribute("email") + "</h3><br/>" +
                        "</div>");                      
        print.write(content);
        print.write("</div>");
        print.write("<a href=\"./logout\">Logout</a>" +
                "</body>" +
                "</html>");
    }
}
