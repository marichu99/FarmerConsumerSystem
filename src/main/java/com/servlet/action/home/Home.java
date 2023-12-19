package com.servlet.action.home;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.servlet.action.dashboard.BaseAction;
import com.servlet.app.bean.AuditLogBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.AuditLog;
import com.servlet.app.model.entity.Product;
import com.servlet.rest.mpesa.constants.Constants;
import com.servlet.utils.GlobalBean;
import com.servlet.view.enums.ProductCategory;
import com.servlet.view.enums.UserAction;

@WebServlet(urlPatterns = "/home")
public class Home extends BaseAction {
    @EJB
    private ProductBeanI productBean;

    @EJB
    AuditLogBeanI auditLogBean;

    @PersistenceContext
    EntityManager em;

    @EJB
    GlobalBean globalBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("./app/Home.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        @SuppressWarnings({ "rawtype" })
        HttpSession httpSession = req.getSession();
        String userType = (String) httpSession.getAttribute("userType");

        // get the request parameters if any
        String category = StringUtils.trimToEmpty(req.getParameter("category"));
        String value = StringUtils.trimToEmpty(req.getParameter("value"));
        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));

        // the below is code to remove the logs
        if (type.equals("logs")) {
            if (mode.equals("remove")) {

                // get the id that has been passed
                if (StringUtils.isNotBlank(req.getParameter("id"))) {
                    int logID = Integer.parseInt(req.getParameter("id"));

                    // get the product by ID
                    AuditLog auditLog = auditLogBean.getByID(logID,new AuditLog());

                    auditLogBean.delete(auditLog);

                }
            }
        }

        if (category.equals("ProductCategory")) {
            Product product = new Product();
            product.setProductCategory(Enum.valueOf(ProductCategory.class, value));
            product.setProductOwner(GlobalBean.getUserEmail());
            List<Product> allProducts = productBean.list(product);

            String fullUrl = getEndPoint(req, resp);
            // update the globalbean and set the endpoint
            GlobalBean.setEndpoint(fullUrl);

            // JsonFetcher.convertJsonToExcel(Product.class, allProducts);

            renderSpecific(req, resp, Product.class, allProducts, ProductCategory.class);
        } else if (category.equals("UserAction")) {
            AuditLog auditLog = new AuditLog();
            auditLog.setUserAction(Enum.valueOf(UserAction.class, value).getValue());
            List<AuditLog> allAuditLogs = auditLogBean.list(auditLog);

            String fullUrl = getEndPoint(req, resp);
            // update the globalbean and set the endpoint
            GlobalBean.setEndpoint(fullUrl);
            renderSpecific(req, resp, AuditLog.class, allAuditLogs, UserAction.class);
        } else {

            if (userType.equals("user")) {
                // endPoint for all the products
                GlobalBean.setEndpoint(Constants.endpoint);

                Product product = new Product();
                product.setProductOwner(GlobalBean.getUserEmail());
                renderSpecific(req, resp, Product.class, productBean.list(product), ProductCategory.class);
            } else if (userType.equals("admin")) {
                // endPoint for all the logs
                GlobalBean.setEndpoint(Constants.endpoint);
                GlobalBean.setEndpoint(Constants.endpointLogs);
                renderSpecific(req, resp, AuditLog.class, auditLogBean.allElements(new AuditLog()), UserAction.class);
            }

        }

    }

    private String getEndPoint(HttpServletRequest req, HttpServletResponse resp) {
        String baseUrl = "http://localhost:8080/farmer-system-app/rest" + req.getServletPath() + "/list";
        String queryParams = req.getQueryString();
        String fullUrl = "";
        if (StringUtils.isNotBlank(queryParams)) {
            fullUrl = baseUrl.concat("?").concat(queryParams).toString();
        }
        return fullUrl;
    }
}
