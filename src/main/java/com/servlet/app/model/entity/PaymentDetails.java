package com.servlet.app.model.entity;

import java.io.Serializable;

import com.servlet.view.html.annotation.FarmerHtmlForm;
import com.servlet.view.html.annotation.FarmerHtmlFormField;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.PaymentTypeAnnotation;

@PaymentTypeAnnotation
@FarmerHtmlForm(action = "", httpMethod = "GET")
@HtmlTable
public class PaymentDetails implements Serializable {

    @FarmerHtmlFormField(labelName = "Enter your phone number", placeHolder = "+254712345678", formName = "Kindly enter your number", className = "phoneNumber", formType = "number")
    private int contact;

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }    
}
