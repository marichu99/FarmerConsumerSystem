package com.servlet.app.model.entity;

import java.util.Date;

import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.database.helper.DbTableID;
import com.servlet.view.html.annotation.HtmlTableColHeader;

@DbTable(name = "logs")
public class AuditLog {
    
    @DbTableColumn(colName ="logId",colDescription = "INT NOT NULL INCREMENT")
    @DbTableID
    @HtmlTableColHeader(header = "Log ID")
    private int logId;

    @DbTableColumn(colName = "user", colDescription = "VARCHAR(255)")
    @HtmlTableColHeader(header = "User")
    private String userEmail;

    @DbTableColumn(colName = "Date",colDescription = "DATE")
    @HtmlTableColHeader(header = "TimeStamp")
    private Date date;

    @DbTableColumn(colName = "last_visited",colDescription = "VARCHAR(255)")
    @HtmlTableColHeader(header = "Last Page Visited")
    private String lastVisited;

    
    public AuditLog() {
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(String lastVisited) {
        this.lastVisited = lastVisited;
    }

    

}   

