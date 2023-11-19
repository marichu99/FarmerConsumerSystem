package com.servlet.database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDataBase implements Serializable{
    private static final String url="jdbc:mysql://localhost:3306/mabera";
    private static final String user ="root";
    private static final String PASSWORD ="root";
    private MysqlDataBase() throws SQLException{
            connection = DriverManager.getConnection(url,user,PASSWORD);     
    };
    private Connection connection;
    private static MysqlDataBase database;

    public static MysqlDataBase getInstance(){
        if(database == null){
            try {
                database= new MysqlDataBase();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return database;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static MysqlDataBase getDatabase() {
        return database;
    }

    public static void setDatabase(MysqlDataBase database) {
        MysqlDataBase.database = database;
    }
    
}
