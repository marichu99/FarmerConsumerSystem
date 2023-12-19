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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.servlet.app.bean.AuditLogBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.bean.PurchasedProductBeanI;
import com.servlet.app.model.entity.AuditLog;
import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.PurchasedProduct;
import com.servlet.view.enums.ProductCategory;
import com.servlet.view.enums.UserAction;

@Path("/home")
public class ProductRestApi extends BaseRestApi {

    private static final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    @EJB
    private ProductBeanI productBean;

    @EJB
    AuditLogBeanI auditLogBean;

    @EJB
    PurchasedProductBeanI purchasedProductBean;

    @RolesAllowed("lOGGED_IN")
    @Path("/add")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@QueryParam("category") int productID, @QueryParam("value") int quantity) {

        Product product = productBean.getProductByID(productID);
        product.setId(productID);
        product.setProdQuantity(quantity);

        // update the Purchased Product table too
        PurchasedProduct purchasedProduct = new PurchasedProduct();
        purchasedProduct.setProductName(product.getProductName());
        purchasedProduct.setProdQuantity(quantity);
        purchasedProduct.setProductCategory(product.getProductCategory());
        purchasedProduct.setPrice(quantity*product.getPrice());

        purchasedProductBean.addOrUpdate(purchasedProduct);

        productBean.addOrUpdate(product);
        return respond();
    }

    @RolesAllowed("lOGGED_IN")
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("category") String category, @QueryParam("value") String value) {     

        if (category != null) {
            if (category.equals("ProductCategory")) {
                System.out.println("The code reaches here too");

                Product product = new Product();
                if (!value.equals("all")) {                    
                    product.setProductCategory(Enum.valueOf(ProductCategory.class, value));
                }

                List<Product> allProducts = productBean.list(product);

                return respond(allProducts);
            } else if (category.equals("UserAction")) {
                System.out.println("The code reaches here too");
                
                AuditLog auditLog = new AuditLog();
                auditLog.setUserAction(Enum.valueOf(UserAction.class, value).getValue());
                List<AuditLog> allAuditLogs = auditLogBean.list(auditLog);

                return respond(toJson(allAuditLogs));
            }
        }
        return respond(productBean.allElements(new Product()));
    }

    private String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace(); 
            return "{}"; 
        }
    }
}