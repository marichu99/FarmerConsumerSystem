package com.servlet.rest.mpesa.controller;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.rest.api.BaseRestApi;
import com.servlet.rest.api.RestResponseWrapper;
import com.servlet.rest.mpesa.Mpesa;
import com.servlet.rest.mpesa.constants.Constants;

@Path("/mpesa-payment")
public class MpesaController extends BaseRestApi {

    

    @Path("/authenticate")
    @GET
    @Produces(MediaType.APPLICATION_JSON)    
    private Response authenticate(){
        try {
            Mpesa mpesa = new Mpesa(Constants.APP_KEY, Constants.APP_SECRET);
            mpesa.authenticate();
            return respond();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return respond(new RestResponseWrapper("Failed to authenticate"));      
    }
}
