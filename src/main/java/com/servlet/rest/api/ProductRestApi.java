package com.servlet.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;

@Path("/produces")
public class ProductRestApi  extends BaseRestApi{

    @EJB
    private ProductBeanI productBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Product product){
        productBean.addOrUpdate(product);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(productBean.allElements(new Product()));
    }
}