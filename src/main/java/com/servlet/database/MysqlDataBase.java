package com.servlet.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;

public class MysqlDataBase implements Serializable{
    private Connection connection;
    private static MysqlDataBase database;

    private MysqlDataBase() throws SQLException, NamingException {
        Context ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:jboss/datasources/farmer-system-app");
        connection = dataSource.getConnection();
    }

    public static MysqlDataBase getInstance(){
        if(database == null){
            try {
                database= new MysqlDataBase();
            } catch (SQLException | NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return database;
    }

    public static void updateSchema(){
        System.out.println("*************** Initializing database *************");

        Connection connection = MysqlDataBase.getInstance().getConnection();
        List<Class<?>> allClasses = new ArrayList<>();
        allClasses.add(User.class);
        allClasses.add(Product.class);

        for(Class clazz : allClasses){
            if(!clazz.isAnnotationPresent(DbTable.class))
                continue;

            DbTable dbTable = (DbTable) clazz.getAnnotation(DbTable.class);

            StringBuilder sqlStatement = new StringBuilder();

            sqlStatement.append("create table if not exists ").append(dbTable.name()).append("(");

            // check if we have the DataBase annotation in that specific class
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                // if the annotation is not present in the reflection then we continue
                if(!field.isAnnotationPresent(DbTableColumn.class))
                    continue;

                // make the field accessible
                field.setAccessible(true);
                DbTableColumn dtTableColumn = field.getAnnotation(DbTableColumn.class);
                sqlStatement.append(dtTableColumn.colName()).append(" ").append(",").append(dtTableColumn.colDescription());
            }
            sqlStatement.append(")");
            try {
                connection.prepareStatement(sqlStatement.toString().replace(",)", ")")).executeQuery();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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
