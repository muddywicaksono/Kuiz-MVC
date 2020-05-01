package mvc;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Model {
    //mengkoneksikan ke database
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/film";//nama database kita di slash terakhir
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;//untuk perintah query

    public Model() {
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    public void insertFilm(String judul, String tipe, String episode,String genre, String rating, String status){
        try {
            String query = "INSERT INTO `list`(`judul`, `tipe`, `episode`, `genre`, `status`,`rating`) VALUES ('"+judul+"','"+tipe+"','"+episode+"' ,'"+genre+"','"+status+"','"+rating+"')";
            //String '"+String+"' kalau Int "+int+"
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query); //execute querynya
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public String[][] readFilm(){
        try{
            int jmlData = 0;//menampung jumlah data

            String data[][] = new String[getBanyakData()][7]; //baris, kolom nya ada 7

            String query = "SELECT * FROM `list` ORDER BY `list`.`judul`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                data[jmlData][0] = resultSet.getString("nomor"); //kolom nama harus sama besar kecilnya dgn database
                data[jmlData][1] = resultSet.getString("judul");
                data[jmlData][2] = resultSet.getString("tipe");
                data[jmlData][3] = resultSet.getString("episode");
                data[jmlData][4] = resultSet.getString("genre");
                data[jmlData][5] = resultSet.getString("status");
                data[jmlData][6] = resultSet.getString("rating");
                jmlData++; //barisnya berpindah terus
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public int getBanyakData(){//menghitung jumlah baris
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "Select * from `list`"; //pengambilan dara dalam java dari database
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ //lanjut kedata selanjutnya jmlData bertambah
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteFilm (String judul) {
        try{
            String query = "DELETE FROM `list` WHERE `judul` = '"+judul+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    void refreshFilm() {

    }
}
