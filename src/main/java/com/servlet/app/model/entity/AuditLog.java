package com.servlet.app.model.entity;

import java.time.LocalDateTime;

import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.view.html.annotation.HtmlTableColHeader;

@DbTable(name = "logs")
public class AuditLog extends BaseEntity {

    @DbTableColumn(colName = "user", colDescription = "VARCHAR(255)")
    @HtmlTableColHeader(header = "User")
    private String userEmail;

    @DbTableColumn(colName = "Date", colDescription = "DATE")
    @HtmlTableColHeader(header = "TimeStamp")
    private LocalDateTime date;

    @DbTableColumn(colName = "user_action", colDescription = "VARCHAR(255)")
    @HtmlTableColHeader(header = "User Action")
    private String userAction;

    public AuditLog() {
    }

    public AuditLog(String userEmail, LocalDateTime date, String userAction) {
        this.userEmail = userEmail;
        this.date = date;
        this.userAction = userAction;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getUserAction() {
        return userAction;
    }

    public void setUserAction(String userAction) {
        this.userAction = userAction;
    }

}
