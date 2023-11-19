package com.servlet.event;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.database.MysqlDataBase;
import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.utils.EnumTypeConverter;

@WebListener
public class AppInit implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*************** Initializing database *************");

        Connection connection = MysqlDataBase.getInstance().getConnection();
        List<Class<?>> allClasses = new ArrayList<>();
        allClasses.add(User.class);
        allClasses.add(Product.class);
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
        // let us initialize the enumConverters into strings
        EnumTypeConverter.registerEnumConverters();

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Application is undeployed or destroyed");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }

}

