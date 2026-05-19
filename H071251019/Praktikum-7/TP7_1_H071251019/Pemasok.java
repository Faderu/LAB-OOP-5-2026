package TP7_1_H071251019;

import java.util.Random;

class Pemasok implements Runnable{
    private final Gudang gudang;
    private final Random random; // untuk barang acak
    String nama;
    
    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.random = new Random(); 
        this.nama = nama;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()) { // selagi thrad tidak di hentikam akan terus jalan
            try {
                int jumlahBarang = random.nextInt(10) + 1; // random 1 - 10
                gudang.tambahstok(jumlahBarang, nama);   
                Thread.sleep(random.nextInt(1001) + 1000); // waktu 1-2 detik
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
        }

    }
} // akhir
