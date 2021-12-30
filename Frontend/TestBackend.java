/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frontend;
/**
 *
 * @author ACER
 */
import Backend.*;
import java.sql.Date;
import java.sql.*;
public class TestBackend {
    public static void main(String[] args) {
//     //Penumpang
//        Penumpang Penumpang1 = new Penumpang("Ferdiansyah", "Probolinggo", "085856004598");
//        Penumpang Penumpang2 = new Penumpang("Tirta", "Lumajang", "082234567892");
//        Penumpang Penumpang3 = new Penumpang("Meli", "Malang", "08123456789");
//        Penumpang Penumpang4 = new Penumpang("Nia", "Jember", "081234555444");
//        
//        Penumpang1.save();
//        Penumpang2.save();
//        Penumpang3.save();
//        Penumpang4.save();
//        Penumpang2.setAlamat("Jember");
//        Penumpang2.save();
//        Penumpang3.delete();
//        
//        for (Penumpang a : new Penumpang().getAll()) {
//            System.out.println("NamaPenumpang: " + a.getNamaPenumpang() + ", Alamat: " + a.getAlamat()
//            + ", Telepon: " + a.getTelepon());
//        }
//        for (Penumpang a : new Penumpang().search("Tirta")) {
//            System.out.println("Nama: " + a.getNamaPenumpang() + ", Alamat: " + a.getAlamat()
//            + ", Telepon: " + a.getTelepon());
//        }   
        
//        //Kategori
//        Kategori Kategori1 = new Kategori("Utama",300000);
//        Kategori Kategori2 = new Kategori("Utama",300000);
//        Kategori Kategori3 = new Kategori("Utama",300000);
//        Kategori Kategori4 = new Kategori("Ekonomi",150000);
//        
//        Kategori1.save();
//        Kategori3.save();
//        Kategori4.save();
//        Kategori2.setNamaKategori("Bisnis");
//        Kategori2.setTipeKursi(250000);
//        Kategori2.save();
//        Kategori3.delete();
//        
//        for (Kategori a : new Kategori().getAll()) {
//            System.out.println("NamaKategori: " + a.getNamaKategori() + ", tipeKursi: " + a.getTipeKursi());
//        }
//        for (Kategori a : new Kategori().search("Bisnis")) {
//            System.out.println("NamaKategori: " + a.getNamaKategori() + ", tipeKursi: " + a.getTipeKursi());
//        }   
        
//        // Pesawat
//        Kategori kt1 = new Kategori().getById(1);
//        Kategori kt2 = new Kategori().getById(3);
//        Kategori kt3 = new Kategori().getById(4);
//        
//        Pesawat pesawat1 = new Pesawat( kt1,"Garuda","Utama",2000000);
//        Pesawat pesawat2 = new Pesawat(kt2,"Lion Air","Ekonomi",1500000);
//        Pesawat pesawat3 = new Pesawat(kt3,"Lion Air","Ekonomi",1500000);
//        Pesawat pesawat4 = new Pesawat(kt3,"Lion Air","Bisnis",1500000);
//        
//        pesawat1.save();
//        pesawat2.save();
//        pesawat4.save();
//        pesawat2.setNamaPesawat("Batik Air");
//        pesawat2.setJenisPesawat("Utama");
//        pesawat2.setHargaTiket(1000000);
//        pesawat2.save();
//        pesawat3.delete();
//        
//        
//        new Pesawat().getAll().stream().forEach((a) -> {
//            System.out.println("Id Kategori: " + a.getKategori().getIdKategori() 
//                                + " namaPesawat : " + a.getNamaPesawat()
//                                + " jenisPesawat : " + a.getJenisPesawat()
//                                + " hargaTiket : "+ a.getHargaTiket());
//        });

        //Transaksi
        Penumpang pnm1 = new Penumpang().getById(1);
        Penumpang pnm2 = new Penumpang().getById(2);
        Penumpang pnm3 = new Penumpang().getById(4);
        
        Pesawat Ps1 = new Pesawat().getById(1);
        Pesawat Ps2 = new Pesawat().getById(2);
        Pesawat Ps3 = new Pesawat().getById(3);
        
        Transaksi trn1 = new Transaksi(pnm1,Ps1,2,4500000);
        Transaksi trn2 = new Transaksi(pnm2,Ps2,2,2600000);
        Transaksi trn3 = new Transaksi(pnm3,Ps2,2,2600000);
        Transaksi trn4 = new Transaksi(pnm3,Ps3,2,3300000);
        
        trn1.save();
        trn2.save();
        trn4.save();
        trn3.setPesawat(Ps3);
        trn3.setJumlahTiket(4);
        trn3.setTotalBayar(4600000);
        trn3.save();
        trn3.delete();
        
        
        new Transaksi().getAll().stream().forEach((b) -> {
            System.out.println("Id Penumpang: " + b.getPenumpang().getIdPenumpang() 
                                + " Id Pesawat: " + b.getPesawat().getIdPesawat()
                                + " jumlahTiket : " + b.getJumlahTiket()
                                + " totalBayar : "+ b.getTotalBayar());
        });
        
    }    
}
