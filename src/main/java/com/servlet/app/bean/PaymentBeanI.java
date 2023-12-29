package com.servlet.app.bean;

import java.util.List;

import com.servlet.app.model.entity.Payment;
import com.servlet.view.enums.UserType;

public interface PaymentBeanI extends GenericBeanI<Payment>{
    void getTotalBought(UserType userType);

    void getTotalSold(UserType userType);

    List<Payment> searchByName(String productName, List<Payment> products);
}
