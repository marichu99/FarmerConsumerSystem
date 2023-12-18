package com.servlet.rest.api;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.AuditLogBeanI;
import com.servlet.app.model.entity.AuditLog;
import com.servlet.view.enums.UserAction;

@Path("/logs")
public class AuditLogRestApi extends BaseRestApi{
    @EJB
    AuditLogBeanI auditLogBean;
    
    @RolesAllowed("lOGGED_IN")
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("type") String type, @QueryParam("value") String value) {
        
        if (type != null) {
            if (type.equals("ProductCategory")) {
                System.out.println("The code reaches here too");

                AuditLog auditLog = new AuditLog();
                if (!value.equals("all")) {                    
                    auditLog.setUserAction(Enum.valueOf(UserAction.class, value).getValue());
                }

                List<AuditLog> allProducts = auditLogBean.list(auditLog);

                return respond(allProducts);
            } else if (type.equals("UserAction")) {
                System.out.println("The code reaches here too");
                AuditLog auditLog = new AuditLog();
                auditLog.setUserAction(Enum.valueOf(UserAction.class, value).getValue());
                List<AuditLog> allAuditLogs = auditLogBean.list(auditLog);

                return respond(allAuditLogs);
            }
        }
        return respond(auditLogBean.allElements(new AuditLog()));
    }
}
