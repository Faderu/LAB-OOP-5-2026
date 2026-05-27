import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors; 
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);

        ExecutorService pemasokPool = Executors.newFixedThreadPool(2);
        ExecutorService kurirPool = Executors.newFixedThreadPool(3);   
        Thread monitoring = new Thread(new Monitoring(gudang));

        pemasokPool.execute(new Pemasok(gudang)); 
        pemasokPool.execute(new Pemasok(gudang));

        kurirPool.execute(new Kurir(gudang)); 
        kurirPool.execute(new Kurir(gudang));
        kurirPool.execute(new Kurir(gudang));

        monitoring.start();

        try {
            Thread.sleep(15000);

            pemasokPool.shutdownNow();
            kurirPool.shutdownNow();
            monitoring.interrupt();

            pemasokPool.awaitTermination(3, TimeUnit.SECONDS);
            kurirPool.awaitTermination(3, TimeUnit.SECONDS);
            monitoring.join();
        } catch (InterruptedException e) {
            System.out.println("Program utama terganggu");
        }

        System.out.println("Sistem gudang selesai");
    }
}