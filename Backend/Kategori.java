/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ACER
 */
public class Kategori implements IJenis{
    private int idKategori;
    double tipeKursi;
    String namaKategori ;
    
    public Kategori(){
        
    }
    public Kategori(String namaKategori,double tipeKursi){
        this.namaKategori = namaKategori;
        this.tipeKursi = tipeKursi;
    }

    public int getIdKategori() {
        return idKategori;
    }

    public double getTipeKursi() {
        return tipeKursi;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setIdKategori(int idKategori) {
        this.idKategori = idKategori;
    }

    public void setTipeKursi(double tipeKursi) {
        this.tipeKursi = tipeKursi;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    public double getHarga(){
        return tipeKursi;
    }
    public void info(){
        System.out.println("ID Kategori   : "+idKategori);
        System.out.println("Nama Kategori : "+namaKategori);
        System.out.println("Tipe Kursi    : " + tipeKursi);
    }
    

    public double tipeKursi(String tipe) {
        if (tipe.equals("Utama")){
            tipeKursi = 300000;
        }else if(tipe.equals("Bisnis")){
            tipeKursi = 250000;
        }else if(tipe.equals("Ekonomi")){
            tipeKursi = 150000;
        }else{
            System.out.println("SILAHKAN PILIH TIPE KURSI YANG DISEDIAKAN!!");
        }
        return tipeKursi;
    }
    
    // GUI
    public Kategori getById(int id){
        Kategori ktg = new Kategori();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Kategori WHERE idKategori = '" + id + "'");
                
        try {
            while(rs.next()){
                ktg = new Kategori();
                ktg.setIdKategori(rs.getInt("idKategori"));
                ktg.setNamaKategori(rs.getString("namaKategori"));
                ktg.setTipeKursi(rs.getDouble("TipeKursi"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ktg;
    }
            
    public ArrayList<Kategori> getAll(){
        ArrayList<Kategori> ListKategori = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Kategori");
        
        try {
            while (rs.next()) {                
                Kategori ktg = new Kategori();
                ktg.setIdKategori(rs.getInt("idKategori"));
                ktg.setNamaKategori(rs.getString("namaKategori"));
                ktg.setTipeKursi(rs.getDouble("TipeKursi"));
                ListKategori.add(ktg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public ArrayList<Kategori> search(String keyword){
        ArrayList<Kategori> ListKategori = new ArrayList();
        String sql = "SELECT * FROM Kategori WHERE "
                + "namaKategori LIKE '%" + keyword + "%'"
                + "OR tipeKursi LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try {
            while (rs.next()) {                
                Kategori ktg = new Kategori();
                ktg.setIdKategori(rs.getInt("idKategori"));
                ktg.setNamaKategori(rs.getString("namaKategori"));
                ktg.setTipeKursi(rs.getDouble("TipeKursi"));
                ListKategori.add(ktg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListKategori;
    }
    
    public void save(){
        if(getById(idKategori).getIdKategori() == 0){
            String SQL = "INSERT INTO Kategori (namaKategori, tipeKursi) VALUES("
                    + "'" + this.namaKategori + "',"
                    + "'" + this.tipeKursi + "'"
                    + ")";
            this.idKategori = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Kategori set "
                    + "namaKategori = '" + this.namaKategori + "', "
                    + "tipeKursi = '" + this.tipeKursi + "'"
                    + " WHERE idKategori = '" + this.idKategori + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM Kategori WHERE idKategori = '" + this.idKategori + "'";
        DBHelper.executeQuery(SQL);
    }

    @Override
    public double tipeKursi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
