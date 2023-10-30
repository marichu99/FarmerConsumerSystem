package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class HelloServlet implements Servlet{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("The Hello servlet has been created !!");
    }

    @Override
    public ServletConfig getServletConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getServletInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void init(ServletConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter printWriter = res.getWriter();
        printWriter.print("<b>Hello World</b>");
    }    
}
