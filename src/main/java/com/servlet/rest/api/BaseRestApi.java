package com.servlet.rest.api;

import javax.ws.rs.core.Response;

public class BaseRestApi {

    public Response respond() {
        return Response.status(Response.Status.OK).entity(new RestResponseWrapper()).build();
    }

    public Response respond(Object object) {
        return Response.status(Response.Status.OK).entity(object).build();
    }

    public Response respond(RestResponseWrapper wrapper) {
        return Response.status(wrapper.isSuccess() ? Response.Status.OK : Response.Status.INTERNAL_SERVER_ERROR)
                .entity(wrapper).build();
    }

   
}