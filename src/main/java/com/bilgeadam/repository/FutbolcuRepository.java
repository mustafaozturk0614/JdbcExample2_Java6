package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.util.List;

/*
Icrud ı olusturlaım
save metodu yazalım
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

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Futbolcu> findAll() {
        return null;
    }

    @Override
    public Futbolcu findbyId(Long id) {
        return null;
    }
}
