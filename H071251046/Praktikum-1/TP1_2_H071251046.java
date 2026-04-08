package Tugas_1;

import java.util.Scanner;

public class T1_No2 {
    public static void main(String[] args) {
        System.out.println("Input Tanggal (dd-mm-yy) :");
        Scanner t = new Scanner(System.in);
        String tgl = t.nextLine();

        String[]pisah = tgl.split("-");
        int hari = Integer.parseInt(pisah[0]);
        int bulan = Integer.parseInt(pisah[1]);
        int tahun = Integer.parseInt(pisah[2]);

        String namaBulan = "";
        if (bulan == 1) {
            namaBulan = "Januari";
        } else if (bulan == 2) {
            namaBulan = "Februari";
        } else if (bulan == 3) {
            namaBulan = "Maret";
        } else if (bulan == 4) {
            namaBulan = "April";
        } else if (bulan == 5) {
            namaBulan = "Mei";
        } else if (bulan == 6) {
            namaBulan = "Juni";
        } else if (bulan == 7) {
            namaBulan = "Juli";
        } else if (bulan == 8) {
            namaBulan = "Agustus";
        } else if (bulan == 9) {
            namaBulan = "September";
        } else if (bulan == 10) {
            namaBulan = "Oktober";
        } else if (bulan == 11) {
            namaBulan = "November";
        } else if (bulan == 12) {
            namaBulan = "Desember";
        } else {
            System.out.println("Bulan tidak valid");
        }

        if (tahun >= 0 && tahun <= 30) {
            tahun += 2000;
        } else if (tahun >= 31 && tahun <= 99) {
            tahun += 1900;
        } else {
            System.out.println("Tahun tidak valid");
        }

        System.out.println("Hasil:\n" + hari + " " + namaBulan + " " + tahun);
    }
}
