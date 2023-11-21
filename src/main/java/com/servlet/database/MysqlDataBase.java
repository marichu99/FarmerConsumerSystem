package com.servlet.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.servlet.app.model.entity.Product;
import com.servlet.app.model.entity.User;
import com.servlet.database.helper.DbTable;
import com.servlet.database.helper.DbTableColumn;
import com.servlet.view.enums.ProductCategory;

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
                sqlStatement.append(dtTableColumn.colName()).append(" ").append(dtTableColumn.colDescription()).append(",");
            }
            sqlStatement.append(")");
            System.out.println(sqlStatement.toString());
            try {
                connection.prepareStatement(sqlStatement.toString().replace(",)", ")")).executeUpdate();                
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void insert(Object entity){
        try{
            Class<?> clazz = entity.getClass();
            if(!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);
            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            StringBuilder columnBuilder = new StringBuilder();
            StringBuilder paramPLaceHolderBuilder = new StringBuilder();
            List<Object> parameters = new ArrayList<>();

            for(Field field : fields){
                if(!field.isAnnotationPresent(DbTableColumn.class))
                    continue;
                field.setAccessible(true);
                if(field.get(entity) == null)
                    continue;
                
                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);

                columnBuilder.append(dbTableColumn.colName()).append(",");
                paramPLaceHolderBuilder.append("?").append(",");
                parameters.add(field.get(entity));
            }
            String queryBuilder = "insert into "+
                    dbTable.name()+"("+
                    columnBuilder+")"+
                    " values("+
                    paramPLaceHolderBuilder+
                    ")";
            
            String query = queryBuilder.replace(",)", ")");
            System.out.println("Query####################: "+ query);
            PreparedStatement preparedStatement = MysqlDataBase.getInstance().getConnection().prepareStatement(query);
            int paramIdx=1;
            for(Object param : parameters){     
                System.out.println(param);           
                if(param.getClass().isAssignableFrom(Integer.class))
                    preparedStatement.setInt(paramIdx++, (int)param);
                else if(param.getClass().isAssignableFrom(Double.class))
                    preparedStatement.setDouble(paramIdx++, (Double)param);
                else if(param instanceof Enum)
                    preparedStatement.setString(paramIdx++,((Enum<?>)param).name());
                else
                    preparedStatement.setString(paramIdx++, (String)param);
            }
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Product product = new Product(1, "Mabera", "mabera mabera", 25.0, 12,ProductCategory.CEREALS);
        insert(product);
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
