package com.servlet.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.Payment;

@Stateless
@Remote
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI{
        
    
}
