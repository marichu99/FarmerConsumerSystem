package com.servlet.app.bean;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.servlet.app.model.entity.User;
import com.servlet.database.MysqlDataBase;
import com.servlet.view.enums.UserType;

@Stateless
@Local
public class AuthBean implements AuthBeanI, Serializable {
    @EJB
    MysqlDataBase database;

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
