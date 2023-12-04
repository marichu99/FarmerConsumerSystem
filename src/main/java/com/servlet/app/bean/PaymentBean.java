package com.servlet.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import com.servlet.app.model.entity.Payment;
import com.servlet.utils.PaymentNoGenerator;


@Stateless
@Remote
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI{
    @Inject
    @Named("Payment")
    PaymentNoGenerator paymentNoGenerator;

    @Inject
    private Event<Payment> payment;
    @Override

    // the payment will observe the payment entity
    public void addOrUpdate(@Observes Payment entity) {
        // TODO Auto-generated method stub

        entity.setTxnNumber(paymentNoGenerator.generate());
        getGenericDao().addOrUpdate(entity);
    }

    // get some responses from the DB to store them
    
}
