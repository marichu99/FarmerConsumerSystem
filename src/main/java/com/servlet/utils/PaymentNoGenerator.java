package com.servlet.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.inject.Named;

@Named("Payment")
public class PaymentNoGenerator implements TransactionNoGenerator{

    @Override
    public String generate() {
        // TODO Auto-generated method stub
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");

        return "PMT" + dateFormat.format(new Date()) + "-" + ThreadLocalRandom.current().nextInt(2000, 3000 + 1);
    }
        
}
