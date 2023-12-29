package com.servlet.utils;

import java.io.Serializable;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.servlet.view.enums.UserType;

@Stateless
@Remote
public class GlobalBean implements Serializable {
    private static String userEmail;
    private static UserType userType;
    private static String endpoint;
    private static boolean showButtons;
    private static Double totalBought;
    private static Double totalSold;

    public static String getUserEmail() {
        return userEmail;
    }

    public static void setUserEmail(String userEmail) {
        GlobalBean.userEmail = userEmail;
    }

    public static UserType getUserType() {
        return userType;
    }

    public static void setUserType(UserType userType) {
        GlobalBean.userType = userType;
    }

    public static String getEndpoint() {
        return endpoint;
    }

    public static void setEndpoint(String endpoint) {
        GlobalBean.endpoint = endpoint;
    }

    public static boolean isShowButtons() {
        return showButtons;
    }

    public static void setShowButtons(boolean showButtons) {
        GlobalBean.showButtons = showButtons;
    }

    public static Double getTotalBought() {
        return totalBought;
    }

    public static void setTotalBought(Double totalBought) {
        GlobalBean.totalBought = totalBought;
    }

    public static Double getTotalSold() {
        return totalSold;
    }

    public static void setTotalSold(Double totalSold) {
        GlobalBean.totalSold = totalSold;
    }

}
