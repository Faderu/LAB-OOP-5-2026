package TP7_1_H071251019;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("    The Central Warehouse    ");
        System.out.println("=============================");

        Gudang gudang = new Gudang(30);
        ExecutorService poolPemasok = Executors.newFixedThreadPool(2);
        poolPemasok.submit(new Pemasok(gudang, "Pemasok 1"));
        poolPemasok.submit(new Pemasok(gudang, "Pemasok 2"));

        ExecutorService poolKurir = Executors.newFixedThreadPool(3);
        poolKurir.submit(new Kurir(gudang, "Kurir 1"));
        poolKurir.submit(new Kurir(gudang, "Kurir 2"));
        poolKurir.submit(new Kurir(gudang, "Kurir 3"));

        Thread monitorThread = new Thread(new Monitoring(gudang), "Monitor");
        monitorThread.setDaemon(true);
        monitorThread.start();
        System.out.println("\nSistem berjalan selama 15 detik...");

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            System.out.println("Thread terganggu.");;
        }

        System.out.println("\n==================================");
        System.out.println("Waktu Habis. Menghentikan Sistem...");
        System.out.println("==================================");

        poolPemasok.shutdownNow();
        try {
            if (!poolPemasok.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Pemasok masih berjalan, memaksa shutdown...");
                poolPemasok.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        poolKurir.shutdownNow();
        try {
            if (!poolKurir.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Kurir masih berjalan, memaksa shutdown...");
                poolKurir.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        monitorThread.interrupt();

        System.out.println("Semua thread dihentikan. Sistem Warehouse ditutup.");
        System.out.println("Stok akhir di gudang: " + gudang.getStok() + " barang.");
    }
} // akhir
