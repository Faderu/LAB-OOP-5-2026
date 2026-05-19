import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import javax.annotation.processing.Processor;
import java.util.List;

public class DocumentTask implements Runnable{
    private final String fileName;
    private final DataProcessor dataProcessor;
    private final ConcurrentHashMap<String, Integer> results;
    private final List<Result> summary;
    private final CountDownLatch latch;

    public DocumentTask(String fileName, DataProcessor dataProcessor,ConcurrentHashMap<String, Integer> results,List<Result> summary,CountDownLatch latch){
        this.fileName = fileName;
        this.dataProcessor = dataProcessor;
        this.results = results;
        this.summary = summary;
        this.latch = latch;
    }

    @Override
    public void run(){
        try{
           long start = System.currentTimeMillis();
           int jumlahKata = dataProcessor.process(fileName);
            long end = System.currentTimeMillis();
            results.put(fileName, jumlahKata);
            String threadName = Thread.currentThread().getName();
            long durasi = end - start;

            summary.add(new Result(fileName, threadName, durasi, jumlahKata));

            System.out.println( "[" + threadName + "] " + "Selesai memproses " + fileName + " (" + jumlahKata + " kata)");
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();

        }finally{
            latch.countDown();

        }
    }
}