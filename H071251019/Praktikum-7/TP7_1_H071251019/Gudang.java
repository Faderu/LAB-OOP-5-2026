package TP7_1_H071251019;

class Gudang {
    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }
    
    public synchronized void tambahstok(int jumlah, String nama) throws InterruptedException{
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println(nama + " menunggu... Stok saat ini: " + stok + "/" + kapasitasMaksimal);
            wait(); // membuat thread menunggu, berhenti bekerja, karena stok penuh
        }

        stok += jumlah;
        System.out.println("\n=STOK DITAMBAHKAN=\n" + nama + " menambahkan " + jumlah + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);
        notifyAll(); // membangunkan thread yang menunggu, ini yang bekerja jika true
    }

    public synchronized void ambilstok(int jumlah, String nama) throws InterruptedException{
        while (stok < jumlah) {
            System.out.println(nama + " menunggu... Stok saat ini: " + stok + "/" + kapasitasMaksimal);
            wait(); // stok kurang 
        }

        stok -= jumlah;
        System.out.println("\n=STOK DIAMBIL=\n" + nama + " mengambil " + jumlah + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
} // akhir
