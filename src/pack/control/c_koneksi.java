/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.control;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author faizaaulia
 */
public class c_koneksi {
    
    public static ResultSet executeQuery (String SQL) {
        ResultSet rs = null;
        Connection koneksi = setKoneksi();
        try {
            Statement st = (Statement) koneksi.createStatement();
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } return rs;
    }

    public static int execute(String SQL) {
        int status = 0;
        Connection koneksi = setKoneksi();
        try {
            Statement st = (Statement) koneksi.createStatement();
            status = st.executeUpdate(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } return status;
    }
    
    public static Connection setKoneksi() {
        String konString = "jbdc:mysql://localhost:3306/toko";
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.jbdc.Driver");
            koneksi = (Connection) DriverManager.getConnection(konString,"root","");
            System.out.println("Koneksi Berhasil!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal!");
        } catch (SQLException ex) {
            Logger.getLogger(c_koneksi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Koneksi Gagal!");
        } return koneksi;
    }
    
    public static Object getConnection() {
        return null;
    }
    
    Connection con = null;
    Statement set = null;
    ResultSet rs = null;
    String sql = null;
    
    private java.sql.Statement st;
    
    public c_koneksi() {
        try {
            con = (Connection) DriverManager.getConnection("jbdc:mysql://localhost:3306?toko","root","");
            st = con.createStatement();
        } catch (Exception a) {
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal!"+a);
        }
    }
}
