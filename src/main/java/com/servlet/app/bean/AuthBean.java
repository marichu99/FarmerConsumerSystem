package com.servlet.app.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.servlet.app.model.entity.User;
import com.servlet.database.MysqlDataBase;
import com.servlet.view.enums.UserType;

public class AuthBean implements AuthBeanI, Serializable {

    MysqlDataBase database = MysqlDataBase.getInstance();

    public User authenticatUser(User loginUser) {

        PreparedStatement preparedStatement;
        try {
            preparedStatement = database.getConnection()
                                .prepareStatement("select * from user where email=? and password=?");
            preparedStatement.setString(1, loginUser.getEmail());
            preparedStatement.setString(2, loginUser.getPassword());

            System.out.println(preparedStatement.toString());
            ResultSet resultSet = preparedStatement.executeQuery();

            User user = new User();
            while (resultSet.next()) {
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(Enum.valueOf(UserType.class,resultSet.getString("usertype")));
            }
            return user;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
