package com.servlet.app.bean;

import java.io.IOException;

public interface MpesaBeanI {
    String authenticate() throws IOException;

    String STKPushSimulation(String businessShortCode, String password, String timestamp, String transactionType,
            String amount, String phoneNumber, String partyA, String partyB, String callBackURL,
            String accountReference, String transactionDesc) throws IOException;
}
