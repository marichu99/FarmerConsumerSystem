package com.servlet.app.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;

// @DbTable(name = "table")
@Entity
@Table(name = "payment")
@HtmlTable(deleteUrl = "")
public class Payment extends BaseEntity{
    @HtmlTableColHeader(header = "Date")
    @Column(name = "Date", columnDefinition = "")
    private LocalDateTime transactionDate;

    @HtmlTableColHeader(header = "Transaction Number")
    @Column(name = "txnNumber", columnDefinition = "VARCHAR(255)")
    private String txnNumber;

    @HtmlTableColHeader(header = "Price")
    @Column(name = "Price", columnDefinition = "DOUBLE")
    private Double Price;

    @HtmlTableColHeader(header = "Buyer")
    @Column(name = "buyer", columnDefinition = "VARCHAR(255)")
    private String buyer;

    public Payment() {
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

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }



    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    } 

}
