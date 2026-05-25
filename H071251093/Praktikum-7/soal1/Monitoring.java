package soal1;
public class Monitoring implements Runnable {
    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();

                System.out.println("\n=== STATUS GUDANG ===");
                System.out.println("Stok: " + stok + "/" + kapasitas);

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}