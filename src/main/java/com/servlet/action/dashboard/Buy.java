package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.database.Database;
import com.servlet.view.html.AppPage;
import com.servlet.view.html.HtmlComponents;
@WebServlet(urlPatterns = "/buy")
public class Buy extends HttpServlet{
private Database database = Database.getDbInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        new AppPage().renderHtml(req, resp, 0, HtmlComponents.gridView(database.getProducts()),StringUtils.EMPTY);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}
