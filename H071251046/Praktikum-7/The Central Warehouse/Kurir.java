import java.util.Random;

public class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Kurir(Gudang gudang) { this.gudang = gudang; }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(2000 + random.nextInt(1000));
                gudang.ambilStok(1);
            }
        } catch (InterruptedException e) {}
    }
}