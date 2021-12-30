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
public class Pesawat implements ITiket{
    private int idPesawat;
    protected String namaPesawat;
    protected String jenisPesawat;
    protected Kategori kategori = new Kategori();
    protected int hargaTiket;

    
    public Pesawat(){
        
    }
    public Pesawat(Kategori kategori,String namaPesawat, String jenisPesawat,int hargaTiket){
        this.kategori = kategori;
        this.namaPesawat = namaPesawat;
        this.jenisPesawat = jenisPesawat;
        this.hargaTiket = hargaTiket;        
    }

    public void setIdPesawat(int idPesawat) {
        this.idPesawat = idPesawat;
    }

    public void setNamaPesawat(String namaPesawat) {
        this.namaPesawat = namaPesawat;
    }

    public void setJenisPesawat(String jenisPesawat) {
        this.jenisPesawat = jenisPesawat;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public void setHargaTiket(int hargaTiket) {
        this.hargaTiket = hargaTiket;
    }

    public int getIdPesawat() {
        return idPesawat;
    }

    public String getNamaPesawat() {
        return namaPesawat;
    }

    public String getJenisPesawat() {
        return jenisPesawat;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getHargaTiket() {
        return hargaTiket;
    }
    
    
    public int hargaTiket1(){
        hargaTiket+= kategori.tipeKursi;
        return hargaTiket;
    }
    public void cetakTiket(){
        System.out.println("ID Pesawat       : "+ idPesawat);
        System.out.println("Nama Pesawat     : "+namaPesawat);
        System.out.println("Harga Pesawat    : "+ hargaTiket);
        System.out.println("Tipe Kursi       : "+ kategori.namaKategori);
        System.out.println("Harga Tipe Kursi : "+kategori.tipeKursi);
    }
    
    // GUI
    public Pesawat getById(int id){
        Pesawat pst = new Pesawat();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                    + " p.idPesawat AS idPesawat,"
                                    + " a.idKategori AS idKategori,"
                                    + " p.namaPesawat AS namaPesawat,"
                                    + " p.jenisPesawat AS jenisPesawat,"
                                    + " p.hargaTiket AS hargaTiket"                                    
                                    + " FROM Pesawat p"
                                    + " INNER JOIN kategori a ON p.idKategori = a.idKategori"
                                    + " WHERE p.idPesawat = '"+id+"'");
        try {
            while(rs.next()){
                pst = new Pesawat();
                pst.setIdPesawat(rs.getInt("idPesawat"));
                pst.getKategori().setIdKategori(rs.getInt("idKategori"));
                pst.setNamaPesawat(rs.getString("namaPesawat"));
                pst.setJenisPesawat(rs.getString("jenisPesawat"));
                pst.setHargaTiket(rs.getInt("hargaTiket"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pst;
    }

    public ArrayList<Pesawat> getAll(){
        ArrayList<Pesawat> ListPesawat = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT"
                                    + " p.idPesawat AS idPesawat,"
                                    + " a.idKategori AS idKategori,"
                                    + " p.namaPesawat AS namaPesawat,"
                                    + " p.jenisPesawat AS jenisPesawat,"
                                    + " p.hargaTiket AS hargaTiket"                                    
                                    + " FROM Pesawat p"
                                    + " INNER JOIN kategori a ON p.idKategori = a.idKategori");
        try {
            while(rs.next()){
                Pesawat pst = new Pesawat();
                pst.setIdPesawat(rs.getInt("idPesawat"));
                pst.getKategori().setIdKategori(rs.getInt("idKategori"));
                pst.setNamaPesawat(rs.getString("namaPesawat"));
                pst.setJenisPesawat(rs.getString("jenisPesawat"));
                pst.setHargaTiket(rs.getInt("hargaTiket"));

                ListPesawat.add(pst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPesawat;
    }

    public ArrayList<Pesawat> search(String keyword){
        ArrayList<Pesawat> ListPesawat = new ArrayList();
        ResultSet rs = DBHelper.selectQuery("SELECT"
                                    + " p.idPesawat AS idPesawat,"
                                    + " a.idKategori AS idKategori,"
                                    + " p.namaPesawat AS namaPesawat,"
                                    + " p.jenisPesawat AS jenisPesawat,"
                                    + " p.hargaTiket AS hargaTiket"                                    
                                    + " FROM Pesawat p"
                                    + " INNER JOIN kategori a ON p.idKategori = a.idKategori"
                                    + " FROM Pesawat p"
                                    + " INNER JOIN kategori a ON p.idKategori = a.idKategori"
                                    + " WHERE a.idKategori LIKE '%"+keyword+"%'");
        try {
            while(rs.next()){
                Pesawat pst = new Pesawat();
                pst.setIdPesawat(rs.getInt("idPesawat"));
                pst.getKategori().setIdKategori(rs.getInt("idKategori"));
                pst.setNamaPesawat(rs.getString("namaPesawat"));
                pst.setJenisPesawat(rs.getString("jenisPesawat"));
                pst.setHargaTiket(rs.getInt("hargaTiket"));

                ListPesawat.add(pst);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPesawat;
    }

    public void save(){
        int empty = 0;
        if(getById(idPesawat).getIdPesawat() == 0){
        String SQL = "INSERT INTO Pesawat VALUES ("
                        + " '"+ empty +"', "
                        + " '"+this.getKategori().getIdKategori()+"',"
                        + " '"+this.getNamaPesawat()+"',"
                        + " '"+this.getJenisPesawat()+"',"
                        + " '"+this.getHargaTiket()+"'"
                        + " )";
        this.idPesawat = DBHelper.insertQueryGetId(SQL);
        }else{
        String SQL = "UPDATE Pesawat SET"
                    + " idKategori = '"+this.getKategori().getIdKategori()+"',"
                    + " namaPesawat = '"+this.getNamaPesawat()+"',"
                    + " jenisPesawat = '"+this.getJenisPesawat()+"',"
                    + " hargaTiket = '"+this.getHargaTiket()+"'"
                    + " WHERE idPesawat = '"+this.idPesawat+"'";
        DBHelper.executeQuery(SQL);
        }
    }

    public void delete(){
        String SQL = "DELETE FROM Pesawat WHERE idPesawat = '"+this.idPesawat+"'";
        DBHelper.executeQuery(SQL);
    }
}
