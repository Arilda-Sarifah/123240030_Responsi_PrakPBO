/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pbo.responsi.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Lab Informatika
 */
public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private Connection connection;
    private DatabaseConnection(){
        try {
            String url = "jdbc:mysql:http://localhost/phpmyadmin/index.php?route=/database/structure&db=keranjang_belanja";
            String user = "root";
            String password = "";
            this.connection = DriverManager.getConnection(url);
            System.out.println("Koneksi Database berhasil");
        } catch (SQLException e){
            throw new RuntimeException("Koneksi gagal : " + e);
        }
    }
    
    public static DatabaseConnection getInstance(){
        if(instance == null){
            synchronized (DatabaseConnection.class) {
                if(instance == null){
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }
    
    public Connection gConnection(){
        try{
            if(connection == null || connection.isClosed()){
                String url = "jdbc:mysql:http://localhost/phpmyadmin/index.php?route=/database/structure&db=keranjang_belanja";
            String user = "root";
            String password = "";
            this.connection = DriverManager.getConnection(password);
                System.out.println("Koneksi database berhasil");
            }
        }catch (SQLException e){
            System.out.println("Eror mengecek koneksi : " + e.getErrorCode());
        }
        return  connection;
    }
}
