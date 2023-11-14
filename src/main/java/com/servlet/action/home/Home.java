package com.servlet.action.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.view.css.AllPageCss;
import com.servlet.view.html.EverythingHtml;

@WebServlet(urlPatterns = "/home")
public class Home extends HttpServlet {
    EverythingHtml allHtml = new EverythingHtml();
    AllPageCss allCss = new AllPageCss();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("./app/Home.html");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       

        // new AppPage().renderHtml(req, resp, 0, allHtml.getAllHtml(),allCss.getCssCode());

        resp.sendRedirect("./app/index.jsp");
    }
}
