package com.servlet.action.dashboard;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.app.bean.PaymentBeanI;
import com.servlet.app.model.entity.Payment;
import com.servlet.view.html.HtmlComponents;

public class PaymentAction extends BaseAction {
    @EJB
    PaymentBeanI paymentBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        renderPage(req, resp, 0, HtmlComponents.table( paymentBean.allElements(new Payment()),Payment.class));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }
    
}
