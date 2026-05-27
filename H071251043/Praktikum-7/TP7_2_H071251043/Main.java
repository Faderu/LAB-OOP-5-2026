import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        List<String> documents = Arrays.asList(
                "Document_A.txt",
                "Document_B.txt",
                "Document_C.txt",
                "Document_D.txt",
                "Document_E.txt",
                "Document_F.txt",
                "Document_G.txt",
                "Document_H.txt",
                "Document_I.txt",
                "Document_J.txt"
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);
        ConcurrentHashMap<String, ProcessResult> results =
                new ConcurrentHashMap<>();
        CountDownLatch latch = new CountDownLatch(documents.size());
        DataProcessor processor = new DataProcessor();

        System.out.println("===== MEMULAI PROSES INDEXING =====");
        for (String doc : documents) {
            executor.execute(() -> {
                long startTime = System.currentTimeMillis();
                String threadName = Thread.currentThread().getName();
                int wordCount = processor.process(doc);
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                ProcessResult result = new ProcessResult(
                        doc,
                        threadName,
                        wordCount,
                        duration
                );
                results.put(doc, result);

                System.out.println(
                        "[" + threadName + "] " +
                        "Selesai memproses " +
                        doc +
                        " (" + wordCount +
                        " kata | Durasi : " +
                        duration + " ms)"
                );

                latch.countDown();
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();

        // =======================================================

        System.out.println("\n===== HASIL AKHIR =====\n");

        System.out.printf(
                "%-20s %-20s %-15s %-15s%n",
                "Nama Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi (ms)"
        );

        System.out.println(
                "-----------------------------------------------------------------------"
        );

        int totalWords = 0;
        long totalDuration = 0;

        for (ProcessResult result : results.values()) {
            System.out.printf(
                    "%-20s %-20s %-15d %-15d%n",
                    result.getDocumentName(),
                    result.getThreadName(),
                    result.getWordCount(),
                    result.getDuration()
            );

            totalWords += result.getWordCount();
            totalDuration += result.getDuration();
        }

        double average =
                (double) totalDuration / results.size();

        System.out.println(
                "======================================================================="
        );
        System.out.println(
                "Total Kata Keseluruhan : " + totalWords
        );
        System.out.println(
                "Rata-rata Waktu Proses : " +
                String.format("%.2f", average) + " ms"
        );
        System.out.println(
                "======================================================================="
        );
    }
}