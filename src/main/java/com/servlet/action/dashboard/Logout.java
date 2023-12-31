package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet{
    // @Inject
    // Event<AuditLog> logger;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if(StringUtils.isNotBlank((String)httpSession.getAttribute("loggedInId"))){
            // invalidate
            httpSession.invalidate();

            // AuditLog auditLog = new AuditLog();
            // auditLog.setUserAction(UserAction.LOGOUT.getValue());
            // logger.fire(auditLog);

            resp.sendRedirect("./");
        }
    }    
}
