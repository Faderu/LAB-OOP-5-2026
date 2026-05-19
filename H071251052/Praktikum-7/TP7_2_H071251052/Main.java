import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random rand = new Random();

        int duration = 500 + rand.nextInt(1501);
        Thread.sleep(duration); 
        
        return 50 + rand.nextInt(151);
    }
}


public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        ConcurrentHashMap<String, Integer> hasilMap = new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(10);
        
        DataProcessor processor = new DataProcessor();
        long startTime = System.currentTimeMillis();

        System.out.println("Memulai Indexing Paralel...\n");

        for (int i = 1; i <= 10; i++) {
            final String docName = "Dokumen_" + i + ".txt";

            executor.execute(() -> {
                try {
                    int jumlahKata = processor.process(docName);
                    
                    hasilMap.put(docName, jumlahKata);

                    System.out.println("[" + Thread.currentThread().getName() + "] " + "Selesai memproses " + docName + " (" + jumlahKata + " kata).");
                                       
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await(); 
        executor.shutdown();

        tampilkanHasil(hasilMap, startTime);
    }

    private static void tampilkanHasil(ConcurrentHashMap<String, Integer> map, long start) {
        System.out.println("\n--- TABEL RINGKASAN ---");
        int totalSemuaKata = 0;
        
        for (String doc : map.keySet()) {
            int kata = map.get(doc);
            System.out.println(doc + "\t | " + kata + " kata");
            totalSemuaKata += kata;
        }
        
        long totalWaktu = System.currentTimeMillis() - start;
        System.out.println("-----------------------");
        System.out.println("Total Kata Keseluruhan : " + totalSemuaKata);
        System.out.println("Rata-rata Waktu Proses : " + (totalWaktu / 10) + " ms");
    }
}