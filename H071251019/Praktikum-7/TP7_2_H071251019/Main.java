package TP7_2_H071251019;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("====================================");
        System.out.println("    SEARCH ENGINE - DATA INDEXER    ");
        System.out.println("====================================");
        System.out.println("Thread Pool : 3 thread");
        System.out.println("Dokumen     : 10 dokumen simulasi");
        System.out.println("------------------------------------\n");

        List<String> dokumen = new ArrayList<>();
        dokumen.add("Dokumen_A.txt");
        dokumen.add("Dokumen_B.txt");
        dokumen.add("Dokumen_C.txt");
        dokumen.add("Laporan_1.pdf");
        dokumen.add("Laporan_2.pdf");
        dokumen.add("Database_Guide.txt");
        dokumen.add("API_Reference.txt");
        dokumen.add("UserManual.pdf");
        dokumen.add("Changelog.txt");
        dokumen.add("TestReport.txt");

        int total = dokumen.size();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        DataProcessor processor = new DataProcessor();

        ConcurrentHashMap<String, HasilDokumen> hasilMap = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(total);

        Map<String, Future<Void>> futures = new LinkedHashMap<>();

        System.out.println(">> Memulai indexing paralel...\n");

        for (String namaFile : dokumen) {
            IndexerTask task = new IndexerTask(namaFile, processor, hasilMap, latch);

            futures.put(namaFile, executor.submit(task));
        }

        System.out.println(">> Menunggu semua dokumen selesai...\n");

        latch.await();

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\n==============================================");
        System.out.println("          HASIL AKHIR INDEXING (KLASEMEN)     ");
        System.out.println("==============================================");

        System.out.printf("%-25s | %-10s | %6s | %12s%n",
                "Nama Dokumen", "Thread", "Kata", "Durasi (ms)");
        System.out.println("------------------------------------------------------------------");

        int  totalKata   = 0;
        long totalDurasi = 0;

        for (String namaFile : dokumen) {
            HasilDokumen h = hasilMap.get(namaFile);
            if (h == null) continue; 

            System.out.printf("%-25s | %-10s | %6d | %9d ms%n",
                    namaFile,
                    h.namaThread,
                    h.jumlahKata,
                    h.durasiMs);

            totalKata   += h.jumlahKata;
            totalDurasi += h.durasiMs;
        }

        System.out.println("------------------------------------------------------------------");

        double rataRata = (double) totalDurasi / total;

        System.out.println();
        System.out.println("STATISTIK KESELURUHAN");
        System.out.println("----------------------");
        System.out.printf ("Total dokumen diproses  : %d dokumen%n", total);
        System.out.printf ("Total kata keseluruhan  : %d kata%n", totalKata);
        System.out.printf ("Rata-rata durasi proses : %.2f ms%n", rataRata);
        System.out.println("\n>> Indexing selesai!");
    }
} //akhir