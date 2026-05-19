import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import java.util.List;
import java.util.ArrayList;

public class MainDoc{
    public static void main(String[]args){
        ExecutorService executor = Executors.newFixedThreadPool(4);

        String[] fileNames = {"doc1.txt", "doc2.txt", "doc3.txt", "doc4.txt", "doc5.txt", "doc6.txt", "doc7.txt", "doc8.txt", "doc9.txt", "doc10.txt"};

        DataProcessor dataProcessor = new DataProcessor();

        ConcurrentHashMap<String, Integer> results = new ConcurrentHashMap<>();

        List<Result> summary = new ArrayList<>();

        CountDownLatch latch = new CountDownLatch(fileNames.length);

        for(String fileName : fileNames){
            executor.execute(new DocumentTask(fileName, dataProcessor, results, summary, latch));
        }

        try{
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        executor.shutdown();

        System.out.println("\n===== HASIL AKHIR =====");

        System.out.printf("%-20s %-20s %-15s %-10s\n", "Dokumen" , "Thread", "Durasi(ms)", "Jumlah Kata");

        int totalKata = 0;
        long totalDurasi = 0;

        for(Result result : summary){
            System.out.printf("%-20s %-20s %-15d %-10d\n", result.fileName, result.threadName, result.durasi, result.wordCount);
            totalKata += result.wordCount;
            totalDurasi += result.durasi;
        }

        double  rataRataDurasi = (double) totalDurasi / summary.size();

        System.out.println("\nTotal Kata Keseluruhan: " + totalKata);
        System.out.println("Rata-rata Waktu Proses: " + rataRataDurasi);
    }
} 