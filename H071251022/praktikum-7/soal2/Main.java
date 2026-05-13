package soal2;
import java.util.concurrent.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // daftar dokumen
        String[] documents = {
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

        // object processor
        DataProcessor processor = new DataProcessor();

        // thread pool 4 thread
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // thread-safe map
        ConcurrentHashMap<String, Integer> results =
                new ConcurrentHashMap<>();

        // menyimpan detail hasil
        List<DocumentResult> summary =
                Collections.synchronizedList(new ArrayList<>());

        // sinkronisasi
        CountDownLatch latch =
                new CountDownLatch(documents.length);

        System.out.println("=== MULAI PROCESSING ===\n");

        // looping semua dokumen
        for (String doc : documents) {

            executor.execute(() -> {

                long start = System.currentTimeMillis();

                // proses dokumen
                int wordCount = processor.process(doc);

                long end = System.currentTimeMillis();

                long duration = end - start;

                // simpan hasil
                results.put(doc, wordCount);

                // simpan summary
                summary.add(new DocumentResult(
                        doc,
                        Thread.currentThread().getName(),
                        wordCount,
                        duration
                ));

                // monitoring realtime
                System.out.println(
                        "[" + Thread.currentThread().getName() + "] "
                                + "Selesai memproses "
                                + doc
                                + " (" + wordCount + " kata)"
                );

                // kurangi latch
                latch.countDown();
            });
        }

        // tunggu semua selesai
        latch.await();

        // shutdown executor
        executor.shutdown();

        System.out.println("\n=== HASIL AKHIR ===\n");

        // tabel ringkasan
        System.out.printf(
                "%-15s %-20s %-15s %-10s\n",
                "Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi"
        );

        System.out.println(
                "--------------------------------------------------------------"
        );

        int totalWords = 0;
        long totalDuration = 0;

        for (DocumentResult r : summary) {

            System.out.printf(
                    "%-15s %-20s %-15d %-10d\n",
                    r.documentName,
                    r.threadName,
                    r.wordCount,
                    r.duration
            );

            totalWords += r.wordCount;
            totalDuration += r.duration;
        }

        double average =
                (double) totalDuration / summary.size();

        System.out.println("\nTotal Kata : " + totalWords);

        System.out.println(
                "Rata-rata Durasi : "
                        + average
                        + " ms"
        );
    }
}