package com.servlet.app.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.servlet.view.html.annotation.HtmlTable;
import com.servlet.view.html.annotation.HtmlTableColHeader;

// @DbTable(name = "logs")
@Entity
@Table(name = "logs")
@HtmlTable(deleteUrl = "./home?type=logs&mode=remove&id=")

public class AuditLog extends BaseEntity {

    @Column(name = "user", columnDefinition = "VARCHAR(255)")
    @HtmlTableColHeader(header = "User")
    private String userEmail;

    @Column(name = "Date", columnDefinition = "DATE")
    @HtmlTableColHeader(header = "TimeStamp")
    private LocalDateTime date;

    @Column(name = "userAction", columnDefinition = "VARCHAR(255)")
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
