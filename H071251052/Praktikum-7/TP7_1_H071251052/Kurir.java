import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;
    private final String nama;
    private final Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(3) + 1;
                gudang.ambilStok(jumlah, nama);
                Thread.sleep(2000 + random.nextInt(1001));
            }
        } catch (InterruptedException e) {
            System.out.println(nama + " berhenti mengantar.");
        }
    }
}