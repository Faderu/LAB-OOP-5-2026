public class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitas) {
        this.kapasitasMaksimal = kapasitas;
    }

    public synchronized void tambahStok(int jumlah, String namaPemasok) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("[!] Gudang Penuh. " + namaPemasok + " menunggu...");
            wait();
        }
        stok += jumlah;
        System.out.printf("[+] %s menambah %d. Stok saat ini: %d\n", namaPemasok, jumlah, stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah, String namaKurir) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println("[?] Stok tidak cukup untuk " + namaKurir + ". Menunggu...");
            wait();
        }
        stok -= jumlah;
        System.out.printf("[-] %s mengambil %d. Stok saat ini: %d\n", namaKurir, jumlah, stok);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}