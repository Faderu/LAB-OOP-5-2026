package Kurir;

import java.util.Scanner;

public class Main {
    static String getWilayah(String wilayah) {
        wilayah = wilayah.toLowerCase();
        if (wilayah.equals("makassar") || wilayah.equals("gowa")) return "A";
        if (wilayah.equals("maros") || wilayah.equals("pangkep")) return "B";
        if (wilayah.equals("barru") || wilayah.equals("parepare")) return "C";

        return "Tidak Diketahui";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Kurir kurirA = new Kurir("Kurir A", "A");
        Kurir kurirB = new Kurir("Kurir B", "B");
        Kurir kurirC = new Kurir("Kurir C", "C");

        System.out.print("Nama Paket: ");
        String namaBarang = input.nextLine();

        System.out.print("Lokasi Pengambilan: ");
        String asal = input.nextLine();

        System.out.print("Lokasi pengantaran: ");
        String tujuan = input.nextLine();

        Paket paket = new Paket(namaBarang, asal, tujuan);

        String wilayahAsal = getWilayah(asal);
        String wilayahTujuan = getWilayah(tujuan);

        System.out.println("\n=== ALUR PENGIRIMAN ===");

        if (wilayahAsal.equals("A")) kurirA.ambilPaket(paket);
        else if (wilayahAsal.equals("B")) kurirB.ambilPaket(paket);
        else if (wilayahAsal.equals("C")) kurirC.ambilPaket(paket);

        if (wilayahAsal.equals(wilayahTujuan)) {
            System.out.println("Langsung diantar oleh kurir yang sama");
        }
        else if (wilayahAsal.equals("A") && wilayahTujuan.equals("B")) {
            System.out.println("Kurir A menuju Gudang AB");
            kurirA.serahTerima(kurirB);
            kurirB.kirimPaket(tujuan);
        }
        else if (wilayahAsal.equals("B") && wilayahTujuan.equals("C")) {
            System.out.println("Kurir B menuju Gudang BC");
            kurirB.serahTerima(kurirC);
            kurirC.kirimPaket(tujuan);
        }
        else if (wilayahAsal.equals("A") && wilayahTujuan.equals("C")) {
            System.out.println("Kurir A menuju Gudang AB");
            kurirA.serahTerima(kurirB);

            System.out.println("Kurir B menuju Gudang BC");
            kurirB.serahTerima(kurirC);

            kurirC.kirimPaket(tujuan);
        }

        input.close();
        
    }
}
