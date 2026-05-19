/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.model;
import com.pbo.responsi.dto.CartItemDTO;
import com.pbo.responsi.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lab Informatika
 */
public class MySQLRepository implements  CartRepository{
    private final DatabaseConnection databaseConnection;
    public MySQLRepository(){
        this.databaseConnection = DatabaseConnection.getInstance();
    }
    @Override
    public List<CartRepository> getAll(){
        List<CartRepository> carts = new ArrayList<>();
        String sql = "SELECT Nama_Barang, harga, qty, total FROM cart ORDER BY name";
        try(Connection conn = databaseConnection.getConnection(
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))){
            
                while(rs.next()){
                    CartRepository cart = new CartRepository(
                        rs.getString("Nama Barang"),
                        rs.getInt("Harga"),
                        rs.getInt("qty"),
                        rs.getInt("total")
                    );
                    carts.add(cart);
                } catch (SQLException e){
                     System.out.println("Eror getAll : " + e.getMessage());
                     e.printStackTrace();
                }
                return carts;  
    }
    
            public CartRepository getByld(String name){
                String sql = "SELECT Nama_Barang, harga, qty, total FROM cart WHERE "
            }
}
