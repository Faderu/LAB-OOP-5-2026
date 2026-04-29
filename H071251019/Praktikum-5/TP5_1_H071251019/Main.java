package TP5_1_H071251019;

public class Main {
    public static void main(String[] args) {
        KaryawanTetap xixui = new KaryawanTetap("Xixui", "H071251019", 10000000, 500000);
        for (int i = 0; i < 10; i++) xixui.absen();
        System.out.println("== Karyawan Tetap ==");
        System.out.println("Nama: " + xixui.getNama());
        System.out.println("ID karyawan: " + xixui.getIdKaryawan());
        System.out.println("Kehadiran: " + xixui.getjumlahKehadiran());
        System.out.printf("Gaji: %.0f\n", xixui.hitungGaji());
        System.out.printf("Gaji + Bonus: %.0f", xixui.hitungGaji(500000));

        System.out.println(" \n");

        KaryawanKontrak nara = new KaryawanKontrak("Nara", "H071241070", 200000);
        for (int i = 0; i < 22; i++) nara.absen();
        System.out.println("== Karyawan Kontrak ==");
        System.out.println("Nama: " + nara.getNama());
        System.out.println("ID karyawan: " + nara.getIdKaryawan());
        System.out.println("Kehadiran: " + nara.getjumlahKehadiran());
        System.out.printf("Gaji: %.0f", nara.hitungGaji());
    }
}
