import java.util.*;
import java.util.concurrent.*;

public class SearchEngineCore {
    public static void main(String[] args) throws InterruptedException {
        int numDocs = 10;
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(numDocs);
        Map<String, Integer> results = new ConcurrentHashMap<>();
        Map<String, String> details = new ConcurrentHashMap<>();

        for (int i = 0; i < numDocs; i++) {
            executor.submit(new DataProcessor("Dokumen_" + (char)('A' + i) + ".txt", latch, results, details));
        }

        latch.await();
        
        System.out.println("\n--- Klasemen Hasil Indexing ---");
        // Cetak Tabel Ringkasan (Nama, Thread, Durasi)
        results.forEach((file, count) -> {
            String[] d = details.get(file).split(",");
            System.out.printf("File: %s | Thread: %s | Durasi: %s%n", file, d[0], d[1]);
        });
        
        executor.shutdown();
    }
}