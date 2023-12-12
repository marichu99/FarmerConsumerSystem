package com.servlet.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.UserBeanI;
import com.servlet.app.model.entity.User;

@Path("/sign")
public class UserRestApi extends BaseRestApi{
    @EJB
    UserBeanI userBean;
    
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)   
    
    public Response add(User user) {
        // TODO Auto-generated method stub
        userBean.addOrUpdate(user);
        return respond();
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return respond(userBean.allElements(new User()));
    }
}
