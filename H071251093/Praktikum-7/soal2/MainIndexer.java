package soal2;
import java.util.concurrent.*;
import java.util.*;

public class MainIndexer {

    public static void main(String[] args) throws InterruptedException {

        String[] dokumen = {
                "Dokumen_A.txt",
                "Dokumen_B.txt",
                "Dokumen_C.txt",
                "Dokumen_D.txt",
                "Dokumen_E.txt",
                "Dokumen_F.txt",
                "Dokumen_G.txt",
                "Dokumen_H.txt",
                "Dokumen_I.txt",
                "Dokumen_J.txt"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        ConcurrentHashMap<String, Integer> hasil =
                new ConcurrentHashMap<>();

        ConcurrentHashMap<String, String> threadMap =
                new ConcurrentHashMap<>();

        ConcurrentHashMap<String, Long> durasiMap =
                new ConcurrentHashMap<>();

        CountDownLatch latch =
                new CountDownLatch(dokumen.length);

        DataProcessor processor = new DataProcessor();

        for (String file : dokumen) {
            executor.execute(() -> {
                long start = System.currentTimeMillis();

                try {
                    int jumlahKata = processor.process(file);

                    long end = System.currentTimeMillis();
                    long durasi = end - start;

                    hasil.put(file, jumlahKata);
                    threadMap.put(file,
                            Thread.currentThread().getName());
                    durasiMap.put(file, durasi);

                    System.out.println("[" +
                            Thread.currentThread().getName()
                            + "] Selesai memproses "
                            + file + " (" +
                            jumlahKata + " kata)");

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        executor.shutdown();

        System.out.println("\n=== HASIL AKHIR ===");
        System.out.printf("%-20s %-20s %-15s\n",
                "Nama Dokumen", "Thread",
                "Durasi(ms)");

        int totalKata = 0;
        long totalDurasi = 0;

        for (String file : dokumen) {
            System.out.printf("%-20s %-20s %-15d\n",
                    file,
                    threadMap.get(file),
                    durasiMap.get(file));

            totalKata += hasil.get(file);
            totalDurasi += durasiMap.get(file);
        }

        double rataDurasi =
                (double) totalDurasi / dokumen.length;

        System.out.println("\nTotal Kata: "
                + totalKata);

        System.out.println("Rata-rata Durasi: "
                + rataDurasi + " ms");
    }
}