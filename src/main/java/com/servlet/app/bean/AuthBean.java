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
                    .prepareStatement("select username,password from user where username=? and password=? limit=1");
            preparedStatement.setString(0, loginUser.getUsername());
            preparedStatement.setString(0, loginUser.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();

            User user = new User();
            while (resultSet.next()) {
                user.setEmail(resultSet.getString("username"));
                user.setUsername(resultSet.getString("password"));
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
