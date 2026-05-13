import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(15);
        
        ExecutorService pemasokPool = Executors.newFixedThreadPool(2);
        ExecutorService kurirPool = Executors.newFixedThreadPool(3);

        Thread monitoringThread = new Thread(new Monitoring(gudang));
        monitoringThread.start();

        for (int i = 1; i <= 2; i++) {
            pemasokPool.execute(new Pemasok(gudang, "Pemasok-" + i));
        }

        for (int i = 1; i <= 3; i++) {
            kurirPool.execute(new Kurir(gudang, "Kurir-" + i));
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n[!] Waktu habis. Menghentikan sistem...");
        pemasokPool.shutdownNow();
        kurirPool.shutdownNow();
        monitoringThread.interrupt();

        try {
            if (pemasokPool.awaitTermination(5, TimeUnit.SECONDS) && kurirPool.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("\n[OK] Semua thread berhasil dihentikan.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}