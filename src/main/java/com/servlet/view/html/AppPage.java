package com.servlet.view.html;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.view.css.AppCss;
import com.servlet.view.toolbar.TopBar;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class AppPage implements Serializable {

    public void renderHtml(HttpServletRequest req, HttpServletResponse resp,
       int activeMenu, String content) throws IOException {

        HttpSession session = req.getSession();

        ServletContext ctx = req.getServletContext();

        PrintWriter print = resp.getWriter();

        print.write("<!DOCTYPE html>" +
            "<html>" +

            "<head>" +
                new AppCss().getStyle() +
            "</head>" +

            "<body>" +

            new TopBar().menu(activeMenu) +

            "<h3>" + ctx.getInitParameter("AppName") + "<h3>" +
            "<br/>&nbsp;<br/>" +
            "<h3>Welcome: " + session.getAttribute("username") + "</h3><br/>");

        print.write(content);
        print.write("<a href=\"./logout\">Logout</a>" +
            "</body>" +
            "</html>");


    }
}
