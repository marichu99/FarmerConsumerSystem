package com.servlet.app.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.servlet.app.model.entity.User;
import com.servlet.database.MysqlDataBase;
import com.servlet.utils.HashText;
import com.servlet.view.enums.UserType;

@Stateless
@Remote
public class AuthBean implements AuthBeanI{
    @EJB
    MysqlDataBase database;
    @Inject
    HashText hashText;
    public User authenticatUser(User loginUser) {

        try{
            if(loginUser.getUserType() == UserType.USER)
                loginUser.setPassword(hashText.hash(loginUser.getPassword()));
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
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
            System.out.println(user.getEmail());
            System.out.println(user.getUserType());
            return user;
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
