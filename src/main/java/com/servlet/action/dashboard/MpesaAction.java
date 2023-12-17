package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MpesaAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // serialize the payment
        // Payment payment = serializeForm(Payment.class, req.getParameterMap());

        String endPoint = req.getParameter("endPoint");
        resp.sendRedirect(endPoint);
    }

}
