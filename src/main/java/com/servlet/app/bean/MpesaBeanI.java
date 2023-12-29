package com.servlet.app.bean;

import java.io.IOException;

public interface MpesaBeanI {
    String authenticate() throws IOException;

    String STKPushSimulation(String amount, String phoneNumber) throws IOException;
}
