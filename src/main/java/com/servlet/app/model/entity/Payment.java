package com.servlet.app.model.entity;

import java.util.Date;

import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;

@DbTable(name = "table")
@HtmlTable(deleteUrl = "")
public class Payment {
    @HtmlTableColHeader(header = "Date")
    @DbTableColumn(colName = "Date", colDescription = "")
    private Date transactionDate;

    @HtmlTableColHeader(header = "Transaction Number")
    @DbTableColumn(colName = "txnNumber", colDescription = "VARCHAR(255)")
    private String txnNumber;

    @HtmlTableColHeader(header = "Price")
    @DbTableColumn(colName = "Price", colDescription = "DOUBLE")
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
