package com.bilgeadam.utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class ConnectionProvider {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public boolean  openConnection(){
        try {
            Driver.class.forName("org.postgresql.Driver");
            DatabaseConnection.getConnection();
            System.out.println(DatabaseConnection.dbName+" veritabanına başarılı bir şekilde bağlanıldı");
            return  true;
        } catch (Exception e) {
            System.out.println("Veri tabanına baglanılamadı");
            System.out.println(e.getMessage());

           return  false;
        }
    }
    public void closeConnection(){
        try {
            Connection connection=DatabaseConnection.getConnection();
            if (!connection.isClosed()){
               connection.close();
                System.out.println("Baglantı Sonlandırıldı");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public PreparedStatement  getPreparedStatement(String sql){
        if (openConnection()){
            try {
               preparedStatement=DatabaseConnection.getConnection().prepareStatement(sql);
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        return  preparedStatement;
    }




        public Optional<ResultSet> getData(PreparedStatement preparedStatement){

                try {
                    resultSet=preparedStatement.executeQuery();
                    closeConnection();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    closeConnection();
                }

            return Optional.ofNullable(resultSet);
        }

}
