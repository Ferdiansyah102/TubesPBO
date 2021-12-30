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
public class Penumpang {
    private int idPenumpang;
    private String namaPenumpang,Telepon,alamat;
    
    public Penumpang(){
    }
    public Penumpang(String namaPenumpang, String alamat,String Telepon){
        this.namaPenumpang = namaPenumpang;
        this.alamat = alamat;
        this.Telepon = Telepon;        
    }

    public void setIdPenumpang(int idPenumpang) {
        this.idPenumpang = idPenumpang;
    }

    public void setNamaPenumpang(String namaPenumpang) {
        this.namaPenumpang = namaPenumpang;
    }

    public void setTelepon(String Telepon) {
        this.Telepon = Telepon;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    public int getIdPenumpang() {
        return idPenumpang;
    }

    public String getNamaPenumpang() {
        return namaPenumpang;
    }

    public String getTelepon() {
        return Telepon;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public void info(){
        System.out.println("ID Penumpang     : "+ idPenumpang);
        System.out.println("Nama Penumpang   : "+ namaPenumpang);
        System.out.println("No Handphone     : "+ Telepon);
        System.out.println("Alamat           : "+ alamat);
    }
    public void naikTransportasi(Pesawat Transportasi){
        if (Transportasi instanceof Garuda){
            System.out.println("Penumpang Menggunakan Penerbangan Garuda dengan Harga 2000000");
        }else if(Transportasi instanceof BatikAir){
            System.out.println("Penumpang Menggunakan Penerbangan Batik dengan Harga 1000000");
        }else if(Transportasi instanceof LionAir){
            System.out.println("Penumpang Menggunakan Penerbangan Lion dengan harga 1500000");
        }
    }
    
    // GUI
    public Penumpang getById(int id){
        Penumpang pnm = new Penumpang();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Penumpang WHERE idPenumpang = '" + id + "'");
                
        try {
            while(rs.next()){
                pnm = new Penumpang();
                pnm.setIdPenumpang(rs.getInt("idPenumpang"));
                pnm.setNamaPenumpang(rs.getString("namaPenumpang"));
                pnm.setAlamat(rs.getString("alamat"));
                pnm.setTelepon(rs.getString("telepon"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pnm;
    }
            
    public ArrayList<Penumpang> getAll(){
        ArrayList<Penumpang> ListPenumpang = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Penumpang");
        
        try {
            while (rs.next()) {                
                Penumpang pnm = new Penumpang();
                pnm.setIdPenumpang(rs.getInt("idPenumpang"));
                pnm.setNamaPenumpang(rs.getString("namaPenumpang"));
                pnm.setAlamat(rs.getString("alamat"));
                pnm.setTelepon(rs.getString("telepon"));
                
                ListPenumpang.add(pnm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPenumpang;
    }
    
    public ArrayList<Penumpang> search(String keyword){
        ArrayList<Penumpang> ListPenumpang = new ArrayList();
        String sql = "SELECT * FROM Penumpang WHERE "
                + "namaPenumpang LIKE '%" + keyword + "%'"
                + "OR alamat LIKE '%" + keyword + "%'";
        ResultSet rs = DBHelper.selectQuery(sql);
        
        try {
            while (rs.next()) {                
                Penumpang pnm = new Penumpang();
                pnm.setIdPenumpang(rs.getInt("idPenumpang"));
                pnm.setNamaPenumpang(rs.getString("namaPenumpang"));
                pnm.setAlamat(rs.getString("alamat"));
                pnm.setTelepon(rs.getString("telepon"));
                
                ListPenumpang.add(pnm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPenumpang;
    }
    
    public void save(){
        if(getById(idPenumpang).getIdPenumpang() == 0){
            String SQL = "INSERT INTO Penumpang (namaPenumpang, alamat, telepon) VALUES("
                    + "'" + this.namaPenumpang + "',"
                    + "'" + this.alamat + "',"
                    +"'" + this.Telepon + "'"
                    + ")";
            this.idPenumpang = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Penumpang set "
                    + "namaPenumpang = '" + this.namaPenumpang + "', "
                    + "alamat = '" + this.alamat + "',"
                    + "telepon = '" + this.Telepon + "'"
                    + " WHERE idPenumpang = '" + this.idPenumpang + "'";
            DBHelper.executeQuery(SQL);
        }
    }
    
    public void delete(){
        String SQL = "DELETE FROM Penumpang WHERE idPenumpang = '" + this.idPenumpang + "'";
        DBHelper.executeQuery(SQL);
    }

}
