import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainGudang{

    public static void main(String[] args) {

        Gudang gudang = new Gudang(50);

        ExecutorService executor =
                Executors.newFixedThreadPool(6);

        for (int i = 0; i < 2; i++) {
            executor.execute(new Pemasok(gudang));
        }

        for (int i = 0; i < 3; i++) {
            executor.execute(new Kurir(gudang));
        }

        executor.execute(new Monitoring(gudang));

        try {

            Thread.sleep(15000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        executor.shutdown();

        try {

            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {

                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();

            Thread.currentThread().interrupt();
        }

        System.out.println("Sistem selesai.");
    }
}