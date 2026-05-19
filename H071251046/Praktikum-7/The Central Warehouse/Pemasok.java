import java.util.Random;

public class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang) { this.gudang = gudang; }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000 + random.nextInt(1000));
                gudang.tambahStok(1);
            }
        } catch (InterruptedException e) {}
    }
}