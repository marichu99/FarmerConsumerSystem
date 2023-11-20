package com.servlet.app.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.servlet.app.model.entity.User;
import com.servlet.database.Database;
import com.servlet.database.MysqlDataBase;

public class UserBean<T> extends GenericBean<User> implements UserBeanI{
    Database database = Database.getDbInstance();
    Connection connection = MysqlDataBase.getInstance().getConnection();
    public boolean registerUser(User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into users (email,username,password,usertype) values(?,?,?,?)");
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2,user.getUsername());
            preparedStatement.setString(3,user.getPassword());
            preparedStatement.setString(4,user.getUserType().name());

            int noUpdated = preparedStatement.executeUpdate();
            if(noUpdated>0){
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
               
    }
}
  
