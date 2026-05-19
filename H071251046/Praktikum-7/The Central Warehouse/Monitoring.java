public class Monitoring implements Runnable {
    private final Gudang gudang;

    public Monitoring(Gudang gudang) { this.gudang = gudang; }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitas();
                int persen = (stok * 100) / kapasitas;
                
                StringBuilder sb = new StringBuilder("[");
                for (int i = 0; i < 10; i++) {
                    sb.append(i < (stok * 10 / kapasitas) ? "#" : "-");
                }
                sb.append("] ").append(persen).append("%");

                System.out.println("Status Gudang: " + sb.toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}