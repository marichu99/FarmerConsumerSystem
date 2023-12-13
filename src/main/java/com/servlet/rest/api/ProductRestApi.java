package com.servlet.rest.api;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.model.entity.Product;
import com.servlet.utils.JsonFetcher;
import com.servlet.view.enums.ProductCategory;

@Path("/home")
public class ProductRestApi extends BaseRestApi {

    @EJB
    private ProductBeanI productBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Product product) {
        productBean.addOrUpdate(product);
        return respond();
    }

    @RolesAllowed("lOGGES_IN")
    @Path("/list")
    @GET
    // @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("type") String type, @QueryParam("value") String value) {
        System.out.println("The code reaches here");

        if (type != null) {
            if (type.equals("productType")) {
                Product product = new Product();
                product.setProductCategory(Enum.valueOf(ProductCategory.class, value));
                List<Product> allProducts =productBean.list(product);
                byte[] excelBytes = JsonFetcher.convertJsonToExcel(Product.class, allProducts);
                // return respond(excelBytes,"download");
                return respond(allProducts);
            }
        }
        return respond(productBean.allElements(new Product()));
    }
}