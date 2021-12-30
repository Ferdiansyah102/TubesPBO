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
public class Transaksi{
    private int idTransaksi;
    private Penumpang penumpang = new Penumpang();
    private Pesawat pesawat = new Pesawat();
    Kategori kategori;
    private int jumlahTiket;
    private double totalBayar;
    
    public Transaksi(){
    }
    public Transaksi(Penumpang penumpang, Pesawat pesawat,int jumlahTiket, double totalBayar){
        this.penumpang = penumpang;
        this.pesawat=pesawat;
        this.jumlahTiket = jumlahTiket;
        this.totalBayar= totalBayar;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setPenumpang(Penumpang penumpang) {
        this.penumpang = penumpang;
    }

    public void setPesawat(Pesawat pesawat) {
        this.pesawat = pesawat;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setJumlahTiket(int jumlahTiket) {
        this.jumlahTiket = jumlahTiket;
    }

    public void setTotalBayar(double totalBayar) {
        this.totalBayar = totalBayar;
    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public Penumpang getPenumpang() {
        return penumpang;
    }

    public Pesawat getPesawat() {
        return pesawat;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getJumlahTiket() {
        return jumlahTiket;
    }

    public double getTotalBayar() {
        return totalBayar;
    }
    
    public int getTotal(){
        totalBayar = (int)(pesawat.hargaTiket1()* jumlahTiket );
        return getTotal();
    }
    public void info(){
        System.out.println("==============================");
        System.out.println("ID Transaksi     : "+ idTransaksi);
        penumpang.info();
        pesawat.cetakTiket();
        System.out.println("Jumlah Tiket     : "+jumlahTiket);
        System.out.println("Total Bayar      : "+ getTotalBayar());
        System.out.println("==============================");
    }     
    // GUI
    public Transaksi getById(int id){
        Transaksi transaksi = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                    + " p.idTransaksi AS idTransaksi,"
                                    + " p.jumlahTiket AS jumlahTiket,"
                                    + " p.totalBayar AS totalBayar," 
                                    + " a.idPenumpang AS idPenumpang,"
                                    + " b.idPesawat AS idPesawat"                                
                                    + " FROM transaksi p"
                                    + " INNER JOIN Penumpang a ON p.idPenumpang = a.idPenumpang"
                                    + " INNER JOIN Pesawat b ON p.idPesawat = b.idPesawat"
                                    + " WHERE p.idTransaksi = '"+id+"'");
        try {
            while(rs.next()){
                transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("idTransaksi"));
                transaksi.getPenumpang().setIdPenumpang(rs.getInt("idPenumpang"));
                transaksi.getPesawat().setIdPesawat(rs.getInt("idPesawat"));
                transaksi.setJumlahTiket(rs.getInt("jumlahTiket"));
                transaksi.setTotalBayar(rs.getInt("totalBayar"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transaksi;
    }

    public ArrayList<Transaksi> getAll(){
        ArrayList<Transaksi> ListTransaksi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT"
                                    + " p.idTransaksi AS idTransaksi,"
                                    + " p.jumlahTiket AS jumlahTiket,"
                                    + " p.totalBayar AS totalBayar," 
                                    + " a.idPenumpang AS idPenumpang,"
                                    + " b.idPesawat AS idPesawat"                                
                                    + " FROM transaksi p"
                                    + " INNER JOIN Penumpang a ON p.idPenumpang = a.idPenumpang"
                                    + " INNER JOIN Pesawat b ON p.idPesawat = b.idPesawat");
        try {
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("idTransaksi"));
                transaksi.getPenumpang().setIdPenumpang(rs.getInt("idPenumpang"));
                transaksi.getPesawat().setIdPesawat(rs.getInt("idPesawat"));
                transaksi.setJumlahTiket(rs.getInt("jumlahTiket"));
                transaksi.setTotalBayar(rs.getInt("totalBayar"));

                ListTransaksi.add(transaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public ArrayList<Transaksi> search(String keyword){
        ArrayList<Transaksi> ListTransaksi = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                    + " p.idTransaksi AS idTransaksi,"
                                    + " p.jumlahTiket AS jumlahTiket,"
                                    + " p.totalBayar AS totalBayar," 
                                    + " a.idPenumpang AS idPenumpang,"
                                    + " b.idPesawat AS idPesawat"                                
                                    + " FROM transaksi p"
                                    + " INNER JOIN Penumpang a ON p.idPenumpang = a.idPenumpang"
                                    + " INNER JOIN Pesawat b ON p.idPesawat = b.idPesawat"
                                    + " WHERE a.idPenumpang LIKE '%"+keyword+"%'"
                                    + " OR b.idPesawat LIKE '%"+keyword+"%'");
        try {
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setIdTransaksi(rs.getInt("idTransaksi"));
                transaksi.getPenumpang().setIdPenumpang(rs.getInt("idPenumpang"));
                transaksi.getPesawat().setIdPesawat(rs.getInt("idPesawat"));
                transaksi.setJumlahTiket(rs.getInt("jumlahTiket"));
                transaksi.setTotalBayar(rs.getInt("totalBayar"));

                ListTransaksi.add(transaksi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListTransaksi;
    }

    public void save(){
        int empty = 0;
        if(getById(idTransaksi).getIdTransaksi() == 0){
        String SQL = "INSERT INTO Transaksi VALUES ("
                        + " '"+ empty +"', "
                        + " '"+this.getPenumpang().getIdPenumpang()+"',"
                        + " '"+this.getPesawat().getIdPesawat()+"',"
                        + " '"+this.getJumlahTiket()+"',"
                        + " '"+this.getTotalBayar()+"'"
                        + " )";
        this.idTransaksi = DBHelper.insertQueryGetId(SQL);
        }else{
        String SQL = "UPDATE Transaksi SET"
                    + " idPenumpang = '"+this.getPenumpang().getIdPenumpang()+"',"
                    + " idPesawat = '"+this.getPesawat().getIdPesawat()+"',"
                    + " jumlahTiket = '"+this.getJumlahTiket()+"',"
                    + " totalBayar = '"+this.getTotalBayar()+"'"
                    + " WHERE idPesawat = '"+this.idTransaksi+"'";
        DBHelper.executeQuery(SQL);
        }
    }

    public void delete(){
        String SQL = "DELETE FROM Transaksi WHERE idTransaksi = '"+this.idTransaksi+"'";
        DBHelper.executeQuery(SQL);
    }
    
}
