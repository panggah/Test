/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi_juragan_beras;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ASPIREV5471G
 */
public class Koneksi {
    public Statement state;
    public Connection connect;
    public String url = "jdbc:mysql://localhost/db_tugasakhir";
    
    public void koneksiDbtugas(){
        try {
        connect = DriverManager.getConnection(url,"root","123");
        System.err.println("Koneksi berhasil");
        state = connect.createStatement();
        } catch (Exception e) {
            System.err.println("Cek url, username atau password");
        }
    }
public ResultSet ambilData (String q){
        ResultSet rs =null;
        koneksiDbtugas();
        try {
            state= connect.createStatement();
            rs= state.executeQuery(q);
            String bisa = "Data Berhasil Diambil";
            JOptionPane.showMessageDialog(null, bisa);
        } catch (SQLException e) {
            //System.out.println("Error Pengambilan Data:"+e);
            JOptionPane.showMessageDialog(null, "ERROR PENGAMBILAN DATA");
        }
        return rs;
    }

public boolean simpanData(String q){
    koneksiDbtugas();
    try {
            state=connect.createStatement();
            state.executeUpdate(q);
            String sukses = "Berhasil di Simpan";
            JOptionPane.showMessageDialog(null, sukses);
            return true;
        } catch (SQLException e) {
            //System.out.println("Error Penyimpanan Data :"+e);
            JOptionPane.showMessageDialog(null, "ERROR PENYIMPANAN DATA");
            return false;
        }
    }
}

