package com.servlet.app.bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.servlet.app.model.entity.AuditLog;
import com.servlet.app.model.entity.Payment;
import com.servlet.utils.GlobalBean;
import com.servlet.utils.PaymentNoGenerator;
import com.servlet.view.enums.UserAction;
import com.servlet.view.enums.UserType;

@Stateless
@Remote
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI {
    @Inject
    @Named("Payment")
    PaymentNoGenerator paymentNoGenerator;

    @Inject
    private Event<AuditLog> logger;

    @PersistenceContext
    EntityManager em;

    @Override
    public void addOrUpdate(Payment entity) {
        // TODO Auto-generated method stub

        entity.setTransactionDate(LocalDateTime.now());

        entity.setTxnNumber(paymentNoGenerator.generate());

        entity.setBuyer(GlobalBean.getUserEmail());

        getGenericDao().addOrUpdate(entity);

        // update the logs
        AuditLog auditLog = new AuditLog(GlobalBean.getUserEmail(), LocalDateTime.now(), UserAction.BUY.getValue());
        logger.fire(auditLog);
    }

    @Override
    public void getTotalBought(UserType userType) {
        Object sum = null;
        if (userType.equals(UserType.USER)) {
            // get the currently logged in user
            sum = em.createNativeQuery(
                    "SELECT sum(Price) from payment WHERE buyer =\"" + GlobalBean.getUserEmail() + "\"")
                    .getSingleResult();
        } else if (userType.equals(UserType.ADMIN)) {
            sum = em.createNativeQuery("SELECT sum(Price) from payment ").getSingleResult();
        }
        GlobalBean.setTotalBought(((Number) sum).doubleValue());
    }

    @Override
    public void getTotalSold(UserType userType) {
        Object sum = null;
        if (userType.equals(UserType.USER)) {
            // get the currently logged in user
            sum = em.createNativeQuery(
                    "SELECT sum(Price) from PurchasedProducts WHERE productOwner =\"" + GlobalBean.getUserEmail() + "\"")
                    .getSingleResult();
        } else if (userType.equals(UserType.ADMIN)) {
            sum = em.createNativeQuery("SELECT sum(Price) from PurchasedProducts ").getSingleResult();
        }
        GlobalBean.setTotalSold(((Number) sum).doubleValue());
    }

    @Override
    public List<Payment> searchByName(String productName, List<Payment> products) {
        
        List<Payment> searchedProducts = new ArrayList<>();
        for(Payment product : products){
            if(product.getTxnNumber().equals(productName)){
                System.out.println("A product has been found");
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }
    public PaymentNoGenerator getPaymentNoGenerator() {
        return paymentNoGenerator;
    }

    public void setPaymentNoGenerator(PaymentNoGenerator paymentNoGenerator) {
        this.paymentNoGenerator = paymentNoGenerator;
    }

    public Event<AuditLog> getLogger() {
        return logger;
    }

    public void setLogger(Event<AuditLog> logger) {
        this.logger = logger;
    }

    // get some responses from the DB to store them

}
