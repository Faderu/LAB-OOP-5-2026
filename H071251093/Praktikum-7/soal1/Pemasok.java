package soal1;
import java.util.Random;

public class Pemasok implements Runnable {
    private Gudang gudang;
    private Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(10) + 1;

                gudang.tambahStok(jumlah);

                Thread.sleep((random.nextInt(2) + 1) * 1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}