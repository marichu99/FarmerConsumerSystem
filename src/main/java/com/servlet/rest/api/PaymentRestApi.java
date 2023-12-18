package com.servlet.rest.api;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.PaymentBeanI;
import com.servlet.app.model.entity.Payment;

@Path("/malipo")
public class PaymentRestApi extends BaseRestApi{

    @EJB
    PaymentBeanI paymentBean;
    
    @RolesAllowed("LOGGED_IN")
    @Path("/add")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@QueryParam("value") Double price) {

        Payment payment = new Payment();
        payment.setPrice(price);

        paymentBean.addOrUpdate(payment);
        return respond();
    }
    
}
