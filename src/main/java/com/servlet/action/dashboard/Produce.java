package com.servlet.action.dashboard;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.model.entity.Product;
import com.servlet.database.Database;

@WebServlet("/produce")
public class Produce extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // TODO Auto-generated method stub
            super.doGet(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // TODO Auto-generated method stub
            // get the existing database instance
            Database dbInstance = Database.getDbInstance();
            // lets access the produce from the database through the same instance
            dbInstance.getProducts().add(new Product(1, req.getParameter("prodName"), req.getParameter("prodDescription"),
            Double.valueOf(req.getParameter("prodPrice")), Integer.parseInt(req.getParameter("prodQuantity"))));
        }
    }
    

