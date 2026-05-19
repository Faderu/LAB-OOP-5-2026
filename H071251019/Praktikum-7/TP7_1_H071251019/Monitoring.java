package TP7_1_H071251019;

class Monitoring implements Runnable{
     private final Gudang gudang;
    
    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                int stok = gudang.getStok();
                int maks = gudang.getKapasitasMaksimal();
                double persen = (stok * 100.0) / maks;

                int panjangBar = 20;
                int isi = (int) (persen / 100 * panjangBar);
                int kosong = panjangBar - isi;

                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < isi; i++) bar.append("#");
                for (int i = 0; i < kosong; i++) bar.append("-");
                bar.append("]");
                
                System.out.printf("\nStatus Gudang: %s %.0f%% (%d/%d barang)%n%n", bar, persen, stok, maks);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
