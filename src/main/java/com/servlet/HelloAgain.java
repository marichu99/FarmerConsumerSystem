package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/mabera")
public class HelloAgain extends GenericServlet{

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter printWriter = res.getWriter();
        printWriter.print("<b>Hello Again"+req.getParameter("name")+"</b>");
        throw new UnsupportedOperationException("Unimplemented method 'service'");
    }
    
}
