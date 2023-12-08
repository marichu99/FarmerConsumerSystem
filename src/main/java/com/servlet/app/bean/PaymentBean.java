package com.servlet.app.bean;

import java.time.LocalDateTime;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import com.servlet.app.model.entity.AuditLog;
import com.servlet.app.model.entity.Payment;
import com.servlet.utils.GlobalBean;
import com.servlet.utils.PaymentNoGenerator;
import com.servlet.view.enums.UserAction;


@Stateless
@Remote
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI{
    @Inject
    @Named("Payment")
    PaymentNoGenerator paymentNoGenerator;

    @Inject
    private Event<AuditLog> logger;
    @Override

    // the payment will observe the payment entity
    public void addOrUpdate(Payment entity) {
        // TODO Auto-generated method stub

        entity.setTxnNumber(paymentNoGenerator.generate());
        getGenericDao().addOrUpdate(entity);

        // update the logs
        AuditLog auditLog = new AuditLog(GlobalBean.getUserEmail(), LocalDateTime.now(), UserAction.BUY.getValue());
        logger.fire(auditLog);
    }

    // get some responses from the DB to store them
    
}
