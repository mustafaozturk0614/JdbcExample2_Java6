package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
Icrud ı olusturlaım
save metodu yazalım


- update--> idsine gore futbolcuyu guncelleyelim
 */



public class FutbolcuRepository implements ICrud<Futbolcu> {
    private String sql="";
    private ConnectionProvider connectionProvider;
    public FutbolcuRepository() {
        this.connectionProvider = new ConnectionProvider();
    }

    @Override
    public void save(Futbolcu futbolcu) {
        sql="insert into futbolcu(isim,mevki,forma_no,takim_id) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
            preparedStatement.setString(1, futbolcu.getIsim());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3, futbolcu.getFormaNo());
            preparedStatement.setLong(4,futbolcu.getTakimId());
            preparedStatement.executeUpdate();
            connectionProvider.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Futbolcu futbolcu) {

    sql="update futbolcu set isim=?,mevki=?,forma_no=?,deger=?,takim_id=? where id=?";
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.setString(1, futbolcu.getIsim());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3, futbolcu.getFormaNo());
            preparedStatement.setLong(4,futbolcu.getDeger());
            preparedStatement.setLong(5,futbolcu.getTakimId());
            preparedStatement.setLong(6,futbolcu.getId());
          int etkilenenVeri=preparedStatement.executeUpdate();
          if (etkilenenVeri>0){
              System.out.println("Guncelleme Basarılı");
          }else{
              System.out.println("Guncelleme Basarısız");
          }

            connectionProvider.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(Long id) {
        sql="delete from futbolcu where id=?";
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            connectionProvider.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Futbolcu> findAll() {
        sql="select * from futbolcu";
        Futbolcu futbolcu=null;
        List<Futbolcu> futbolcular=new ArrayList<>();
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        Optional<ResultSet> resultSet =connectionProvider.getData(preparedStatement);
        try {
            while (resultSet.get().next()){
                String isim=resultSet.get().getString(2);
                String mevki=resultSet.get().getString("mevki");// veya 3
                int formaNo=resultSet.get().getInt("forma_no"); //veya 4
                long deger=resultSet.get().getLong("deger");//veya 5
                long takimId=resultSet.get().getLong("takim_id");//veya 6
                long id=resultSet.get().getLong("id");
                futbolcu= new  Futbolcu(id,isim,mevki,formaNo,deger,takimId);
                futbolcular.add(futbolcu);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  futbolcular;
    }

    @Override
    public Optional<Futbolcu> findbyId(Long id) {
     //   sql=" select * from futbolcu where id="+id;
        Futbolcu futbolcu=null;
        sql=" select * from futbolcu where id=?";
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.setLong(1,id);
        Optional<ResultSet> resultSet =connectionProvider.getData(preparedStatement);//// getData(sql)
            while (resultSet.get().next()){
                String isim=resultSet.get().getString(2);
                String mevki=resultSet.get().getString("mevki");// veya 3
                int formaNo=resultSet.get().getInt("forma_no"); //veya 4
                long deger=resultSet.get().getLong("deger");//veya 5
                long takimId=resultSet.get().getLong("takim_id");//veya 6
            futbolcu= new  Futbolcu(id,isim,mevki,formaNo,deger,takimId);
            return  Optional.of(futbolcu);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
