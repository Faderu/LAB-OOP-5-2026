package TP7_1_H071251019;

import java.util.Random;

class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random random; // untuk barang acak
    String nama;
    
    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.random = new Random(); 
        this.nama = nama;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int jumlahAmbil = random.nextInt(5) + 1; //random 1-5
                gudang.ambilstok(jumlahAmbil, nama);
                Thread.sleep(random.nextInt(1001) + 2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
} //akhir
