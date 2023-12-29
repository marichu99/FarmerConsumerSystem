package com.servlet.rest.api;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.MpesaBeanI;
import com.servlet.rest.mpesa.Mpesa;
import com.servlet.rest.mpesa.constants.Constants;

@Path("/payment")
public class MpesaAuthRest extends BaseRestApi {

    @EJB
    MpesaBeanI mpesaBean;

    @Path("/auth")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    private Response auth() throws IOException {
        System.out.println("The code has reached here");
        Mpesa mpesa = new Mpesa(Constants.APP_KEY, Constants.APP_SECRET);
        return respond(mpesa.authenticate());

        // return respond(new RestResponseWrapper("Failed to authenticate"));
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() throws IOException {
        // return respond(userBean.allElements(new User()));
        Mpesa mpesa = new Mpesa(Constants.APP_KEY, Constants.APP_SECRET);
        return respond(mpesa.authenticate());
    }

    @Path("/registerUrl")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUrl() throws IOException {
        // return respond(userBean.allElements(new User()));
        Mpesa mpesa = new Mpesa(Constants.APP_KEY, Constants.APP_SECRET);

        return respond(mpesa.registerURL(Constants.shortCode, Constants.responseType, Constants.confirmationUrl,
                Constants.validationUrl));
    }

    @RolesAllowed("LOGGED_IN")
    @Path("/push")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response push(@QueryParam("amount") String amount, @QueryParam("phoneNumber") String phoneNumber ) throws IOException {
        String stkPush = mpesaBean.STKPushSimulation(amount, phoneNumber);
        return respond(stkPush);
    }
}
