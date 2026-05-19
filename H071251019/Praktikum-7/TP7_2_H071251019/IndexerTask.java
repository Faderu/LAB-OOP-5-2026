package TP7_2_H071251019;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class IndexerTask implements Callable<Void> {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private static final ThreadLocal<String> namaThread =
            ThreadLocal.withInitial(() -> "Thread-" + counter.incrementAndGet());

    private final String namaFile;
    private final DataProcessor processor;
    private final ConcurrentHashMap<String, HasilDokumen> hasil;
    private final CountDownLatch latch;

    public IndexerTask(String namaFile, DataProcessor processor,
        ConcurrentHashMap<String, HasilDokumen> hasil,
        CountDownLatch latch) {
        this.namaFile  = namaFile;
        this.processor = processor;
        this.hasil     = hasil;
        this.latch     = latch;
    }

    @Override
    public Void call() throws Exception {

        String thread = namaThread.get();
        long mulai    = System.currentTimeMillis();

        int kata = processor.process(namaFile);

        long durasi = System.currentTimeMillis() - mulai;

        hasil.put(namaFile, new HasilDokumen(kata, durasi, thread));

        System.out.printf("[%s] Selesai memproses %-22s (%3d kata).%n", thread, namaFile, kata);

        latch.countDown();

        return null;
    }
} //akhir