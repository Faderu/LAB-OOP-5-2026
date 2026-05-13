public class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();
                int persen = (stok * 100) / kapasitas;
                
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < 10; i++) {
                    bar.append(i < (persen / 10) ? "#" : "-");
                }
                bar.append("]");
                
                System.out.println("\n--- STATUS GUDANG: " + bar + " " + persen + "% ---");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Monitoring dimatikan.");
        }
    }
}