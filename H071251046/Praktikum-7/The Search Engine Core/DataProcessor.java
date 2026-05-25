import java.util.*;
import java.util.concurrent.*;

public class DataProcessor implements Callable<Integer> {
    private final String fileName;
    private final CountDownLatch latch;
    private final Map<String, Integer> results;
    private final Map<String, String> details;

    public DataProcessor(String fileName, CountDownLatch latch, Map<String, Integer> results, Map<String, String> details) {
        this.fileName = fileName;
        this.latch = latch;
        this.results = results;
        this.details = details;
    }

    @Override
    public Integer call() throws Exception {
        long startTime = System.currentTimeMillis();
        Thread.sleep(500 + new Random().nextInt(1501));
        
        int wordCount = 100 + new Random().nextInt(401);
        results.put(fileName, wordCount);
        
        long duration = System.currentTimeMillis() - startTime;
        details.put(fileName, Thread.currentThread().getName() + "," + duration + "ms");

        System.out.println("[" + Thread.currentThread().getName() + "] Selesai memproses " + fileName + " (" + wordCount + " kata).");
        
        latch.countDown();
        return wordCount;
    }
}