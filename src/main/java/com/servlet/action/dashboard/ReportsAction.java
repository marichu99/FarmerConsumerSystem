package com.servlet.action.dashboard;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.servlet.app.bean.PaymentBeanI;
import com.servlet.app.bean.ProductBeanI;
import com.servlet.app.bean.PurchasedProductBeanI;
import com.servlet.app.model.entity.PurchasedProduct;
import com.servlet.view.enums.ProductCategory;

@WebServlet(urlPatterns = "/reports")
public class ReportsAction extends BaseAction {

    @EJB
    PaymentBeanI paymentBean;

    @EJB
    ProductBeanI productBean;

    @EJB
    PurchasedProductBeanI purchasedProductBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = StringUtils.trimToEmpty(req.getParameter("type"));
        String mode = StringUtils.trimToEmpty(req.getParameter("mode"));
        String value = StringUtils.trimToEmpty(req.getParameter("value"));
        String search = StringUtils.trimToEmpty(req.getParameter("search"));
        String category = StringUtils.trimToEmpty(req.getParameter("category"));

        // get the search params
        searchByCategory(req, resp, category, purchasedProductBean.list(new PurchasedProduct()), mode, search, value,
                new PurchasedProduct());
        if (StringUtils.isEmpty(category) || StringUtils.isEmpty(category)) {
            toRender(req, resp, PurchasedProduct.class, purchasedProductBean.list(new PurchasedProduct()),
                    ProductCategory.class);
        }
        // renderSpecific(req, resp, Payment.class, paymentBean.list(new Payment()),
        // ProductCategory.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        super.doPost(req, resp);
    }

    public List<PurchasedProduct> searchByName(String search, List<PurchasedProduct> allProducts) {
        if (StringUtils.isNotBlank(search)) {
            System.out.println("The searcg value is " + search);
            allProducts = purchasedProductBean.searchByName(search, allProducts);
        }
        return allProducts;
    }

    public void searchByCategory(HttpServletRequest req, HttpServletResponse resp, String category,
            List<PurchasedProduct> allProducts, String mode, String search, String value,
            PurchasedProduct thisProduct) {
        if (category.equals("ProductCategory")) {

            thisProduct.setProductCategory(Enum.valueOf(ProductCategory.class, value));

            // check whether an addional search param has been implemented
            allProducts = searchByName(search, allProducts);

            toRender(req, resp, PurchasedProduct.class, allProducts, ProductCategory.class);
        } else if (!category.equals("ProductCategory") && StringUtils.isNotBlank(search)) {

            // check whether an addional search param has been implemented
            allProducts = searchByName(search, allProducts);

            toRender(req, resp, PurchasedProduct.class, allProducts, ProductCategory.class);
        }
    }

    public void toRender(HttpServletRequest req, HttpServletResponse resp, Class<?> entityClazz,
            List<PurchasedProduct> renderedProducts, Class<?> selectClazz) {
        try {
            renderSpecific(req, resp, PurchasedProduct.class, renderedProducts, ProductCategory.class);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
