package com.bilgeadam.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private  static DatabaseConnection instance;
    public  static final  String dbName="futbolapp";
    private static final String url="jdbc:postgresql://localhost:5656/"+dbName;
    private static final String username="postgres";
    private static final String password="root";
    private  static Connection connection;

    private DatabaseConnection(){
    }
    public  static  DatabaseConnection getInstance(){
        if (instance==null){
            return  new DatabaseConnection();
        }
        return instance;
    }
    public  static Connection getConnection() throws Exception{

            try {
                 connection= DriverManager.getConnection(url,username,password);

            } catch (SQLException e) {
                throw new Exception(e);
            }


        return  connection;
    }



}
