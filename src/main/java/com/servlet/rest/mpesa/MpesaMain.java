package com.servlet.rest.mpesa;

import java.io.IOException;

import com.servlet.rest.mpesa.constants.Constants;

public class MpesaMain {

    public static void main(String[] args) throws IOException{
        Mpesa mpesa = new Mpesa(Constants.APP_KEY, Constants.APP_SECRET);
        // System.out.println(mpesa.authenticate());
        String stkString = mpesa.STKPushSimulation("174379","MTc0Mzc5YmZiMjc5ZjlhYTliZGJjZjE1OGU5N2RkNzFhNDY3Y2QyZTBjODkzMDU5YjEwZjc4ZTZiNzJhZGExZWQyYzkxOTIwMTcwODI0MTU1MDU1","20170824155055","CustomerPayBillOnline","1","254799692741","254799692741","174379",Constants.callBackUrl,Constants.accountRefence,Constants.transactionDesc);
        System.out.println(stkString);
        // mpesa.registerURL(null, null, null, null)

    
    }
    
}
