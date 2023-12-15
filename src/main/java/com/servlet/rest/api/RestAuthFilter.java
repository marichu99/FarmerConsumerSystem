package com.servlet.rest.api;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.AuthBeanI;
import com.servlet.app.model.entity.User;
import com.servlet.view.enums.UserType;

// @Provider
// @Priority(1)
public class RestAuthFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @EJB
    AuthBeanI authBean;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        Method method = resourceInfo.getResourceMethod();

        if(method.isAnnotationPresent(DenyAll.class) || !method.isAnnotationPresent(RolesAllowed.class)){
            abort(containerRequestContext, "End point not allowed");
            return;
        }
        // get the headers
        final MultivaluedMap<String, String> headers = containerRequestContext.getHeaders();

        // get the authorization header
        List<String> authorization = headers.get("Authorization");

        // if there are no authorization headers, abort
        if(authorization == null || authorization.isEmpty() || authorization.get(0) == null){
            abort(containerRequestContext, "Authentication not provided");
            return;
        }
        String basicAuth =authorization.get(0);
        
        if(!basicAuth.contains("Basic")){
            abort(containerRequestContext, "Basic Authentication is required");
            return;
        }
        // remove the Basic from the authorization to remain with base64 encode username and password
        String base64Auth = basicAuth.replace("Basic", "").trim();

        System.out.println("Encoded username and password "+base64Auth);

        byte[] decodedUserAndPass = Base64.getDecoder().decode(base64Auth);

        String[] userNameandPwd = new String(decodedUserAndPass,StandardCharsets.UTF_8).split(":");

        User user = new User();
        user.setUsername(userNameandPwd[0]);
        user.setPassword(userNameandPwd[1]);
        user.setUserType(UserType.USER);

        try{
            user = authBean.authenticatUser(user);
        }catch(Exception e){
            abort(containerRequestContext, e.getMessage());
        }
    }

    private void abort(ContainerRequestContext containerRequestContext, String message) {
        containerRequestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
                .entity(new RestResponseWrapper(false, message)).type(MediaType.APPLICATION_JSON).build());
    }

}
