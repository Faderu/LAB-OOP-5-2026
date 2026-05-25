import java.util.concurrent.*;

public class CentralWarehouse {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(10);
        ExecutorService executor = Executors.newFixedThreadPool(5); // 2 Pemasok, 3 Kurir

        Thread monitorThread = new Thread(new Monitoring(gudang));
        monitorThread.start();

        for (int i = 0; i < 2; i++) executor.execute(new Pemasok(gudang));
        for (int i = 0; i < 3; i++) executor.execute(new Kurir(gudang));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Waktu Habis, Menghentikan Sistem ---");

        monitorThread.interrupt();

        executor.shutdownNow();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Sistem berhenti paksa.");
            } else {
                System.out.println("Seluruh sistem berhasil dihentikan.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
