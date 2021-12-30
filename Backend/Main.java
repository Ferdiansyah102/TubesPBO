/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;

/**
 *
 * @author ACER
 */
public class Main {
    public static void main(String[] args) {
        Penumpang pn1 = new Penumpang("Ferdianyah","085856004598", "Probolinggo");
        Kategori kt1 = new Kategori("Bisnis",250000);
        Pesawat ps1 = new Pesawat(kt1,"Garuda","Bisnis",2000000);
        Garuda gd1 = new Garuda("Garuda",2000000);
        Transaksi tr1 = new Transaksi(pn1, ps1,2, 2250000);
        pn1.naikTransportasi(gd1);
        tr1.info();
        System.out.println("====================================");
        Penumpang pn2 = new Penumpang("Wahyu Kurnia","082216506091", "Semarang");
        Kategori kt2 = new Kategori("Utama",300000);
        Pesawat ps2 = new Pesawat(kt2,"Batik Air","Utama",1000000);
        BatikAir BA = new BatikAir("Batik Air",1000000);
        Transaksi tr2 = new Transaksi(pn2, ps2,3, 1300000);
        pn2.naikTransportasi(BA);
        tr2.info();
        System.out.println("=====================================");
        Penumpang pn3 = new Penumpang("Tirta","082345234654", "Jakarta");
        Kategori kt3 = new Kategori("Ekonomi",150000);
        Pesawat ps3 = new Pesawat(kt3,"Lion Air","Ekonomi",1500000);
        LionAir LA = new LionAir("Lion Air",1500000);
        Transaksi tr3 = new Transaksi(pn3, ps3,2, 1650000);
        pn3.naikTransportasi(LA);
        tr3.info();
        
    }
}
