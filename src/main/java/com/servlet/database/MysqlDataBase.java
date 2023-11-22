package com.servlet.database;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

@SuppressWarnings({"rawtypes","unchecked"})
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
    public static <T> List<T> select(Class<T> filter) {
    try {
        Class<?> clazz = filter;
        System.out.println();
        System.out.println("Clazz>>>>>>>>>>" + clazz.getName());

        if (!clazz.isAnnotationPresent(DbTable.class))
            return new ArrayList<>();

        DbTable dbTable = clazz.getAnnotation(DbTable.class);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT * FROM ")
                .append(dbTable.name()).append(";");
        Connection conn = MysqlDataBase.getInstance().getConnection();
        System.out.println("###############################"+stringBuilder.toString());
        PreparedStatement preparedStatement = conn.prepareStatement(stringBuilder.toString());

        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> result = new ArrayList<>();

        while (resultSet.next()) {
            T object = (T) clazz.getDeclaredConstructor().newInstance();

            for (Field field : clazz.getDeclaredFields()) {
                DbTableColumn dbColumn = field.getAnnotation(DbTableColumn.class);
                if (dbColumn != null) {
                    String columnName = dbColumn.colName();

                    Object value = resultSet.getObject(columnName);
                    // Convert java.sql.Date to java.time.LocalDate if needed
                    if (value instanceof java.sql.Date && field.getType().equals(java.time.LocalDate.class)) {
                        value = ((java.sql.Date) value).toLocalDate();
                    }

                    // Convert java.sql.Time to java.time.LocalTime if needed
                    if (value instanceof java.sql.Time && field.getType().equals(java.time.LocalTime.class)) {
                        value = ((java.sql.Time) value).toLocalTime();
                    }
                    // convert the value to enum if needed
                    if(field.getType().isEnum() && value instanceof String){
                        value = Enum.valueOf((Class<Enum>) field.getType(), (String) value);
                    }
                    field.setAccessible(true);
                    field.set(object, value);
                }
            }

            result.add(object);
        }
        return result;

    } catch (SQLException | InvocationTargetException | InstantiationException | IllegalAccessException |
             NoSuchMethodException ex) {
        throw new RuntimeException(ex);
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

    public static void delete(Object entity,int productID){
        try{
            Class<?> clazz = entity.getClass();
            if(!clazz.isAnnotationPresent(DbTable.class))
                return;

            DbTable dbTable = clazz.getAnnotation(DbTable.class);
            List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            String columnID ="";
            for(Field field : fields){
                if(!field.isAnnotationPresent(DbTableColumn.class))
                    continue;
                field.setAccessible(true);
                if(field.get(entity) == null)
                    continue;                
                DbTableColumn dbTableColumn = field.getAnnotation(DbTableColumn.class);
                // get the column that has id in it
                if(dbTableColumn.colName().contains("Id")){
                    columnID=dbTableColumn.colName();
                }
            }
            String queryBuilder = "DELETE * FROM "+
                    dbTable.name()+" WHERE "+
                    columnID+" ="+
                    productID;
            
            System.out.println("Query####################: "+ queryBuilder);
            PreparedStatement preparedStatement = MysqlDataBase.getInstance().getConnection().prepareStatement(queryBuilder);
            preparedStatement.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
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
