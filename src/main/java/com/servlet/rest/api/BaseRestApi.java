package com.servlet.rest.api;

import javax.ws.rs.core.Response;

public abstract class BaseRestApi {

    Response respond() {
        return Response.status(Response.Status.OK).entity(new RestResponseWrapper()).build();
    }

    Response respond(Object object) {
        return Response.status(Response.Status.OK).entity(object).build();
    }

    Response respond(RestResponseWrapper wrapper) {
        return Response.status(wrapper.isSuccess() ? Response.Status.OK : Response.Status.INTERNAL_SERVER_ERROR)
                .entity(wrapper).build();
    }

    Response respond(byte[] excelBytes, String download) {
        if (download.equals("download")) {
            return Response.ok(excelBytes, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
                    .header("Content-Disposition", "attachment; filename=data.xlsx").build();
        }else{
            return Response.serverError().build();
        }
    }
}