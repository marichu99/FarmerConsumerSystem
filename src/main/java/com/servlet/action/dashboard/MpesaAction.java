package com.servlet.action.dashboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@WebServlet(urlPatterns = "MpesaAction")
public class MpesaAction extends BaseAction {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // serialize the payment
        // Payment payment = serializeForm(Payment.class, req.getParameterMap());

        String amount = req.getParameter("amount");
        String phoneNumber =  req.getParameter("phoneNumber");

        String endPoint = "http://localhost:8080/farmer-system-app/rest/payment/push?amount=23&phoneNumber=254799692741";
        OkHttpClient client = new OkHttpClient();

        

        Request request = new Request.Builder()
                .url(endPoint)
                .build();

        try {
            Response response = client.newCall(request).execute();

            // Get the response code
            int statusCode = response.code();
            System.out.println("Response Code: " + statusCode);

            // Read the response data
            String responseData = response.body().string();
            System.out.println("Response Data: " + responseData);

        } catch (IOException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(endPoint);
    }

}
