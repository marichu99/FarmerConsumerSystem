package com.servlet.app.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;

// @DbTable(name = "table")
@Entity
@Table(name = "payment")
@HtmlTable(deleteUrl = "")
public class Payment {
    @HtmlTableColHeader(header = "Date")
    @Column(name = "Date", columnDefinition = "")
    private Date transactionDate;

    @HtmlTableColHeader(header = "Transaction Number")
    @Column(name = "txnNumber", columnDefinition = "VARCHAR(255)")
    private String txnNumber;

    @HtmlTableColHeader(header = "Price")
    @Column(name = "Price", columnDefinition = "DOUBLE")
    private Double Price;

    public Payment() {
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTxnNumber() {
        return txnNumber;
    }

    public void setTxnNumber(String txnNumber) {
        this.txnNumber = txnNumber;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    } 

}
