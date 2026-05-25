public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("[Pemasok] Gudang penuh, menunggu...");
            wait();
        }
        stok += jumlah;
        System.out.println("[Pemasok] Menambah " + jumlah + " barang. Stok: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("[Kurir] Stok kosong, menunggu...");
            wait();
        }
        stok -= jumlah;
        System.out.println("[Kurir] Mengambil " + jumlah + " barang. Sisa: " + stok);
        notifyAll();
    }

    public int getStok() { return stok; }
    public int getKapasitas() { return kapasitasMaksimal; }
}