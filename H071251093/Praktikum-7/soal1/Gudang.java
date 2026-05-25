package soal1;
public class Gudang {
    private int stok = 0;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah) {
        while (stok + jumlah > kapasitasMaksimal) {
            try {
                System.out.println("Gudang penuh, pemasok menunggu...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        stok += jumlah;
        System.out.println(Thread.currentThread().getName()
                + " menambah " + jumlah
                + " barang. Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah) {
        while (stok < jumlah) {
            try {
                System.out.println("Stok kosong, kurir menunggu...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        stok -= jumlah;
        System.out.println(Thread.currentThread().getName()
                + " mengambil " + jumlah
                + " barang. Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}