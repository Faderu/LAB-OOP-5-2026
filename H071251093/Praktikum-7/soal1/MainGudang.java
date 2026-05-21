package soal1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainGudang {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(50);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Thread monitoring = new Thread(new Monitoring(gudang));
        monitoring.start();

        for (int i = 0; i < 2; i++) {
            executor.execute(new Pemasok(gudang));
        }

        for (int i = 0; i < 3; i++) {
            executor.execute(new Kurir(gudang));
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdownNow();
        monitoring.interrupt();

        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sistem Gudang Berhenti.");
    }
}