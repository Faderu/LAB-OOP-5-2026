package TP7_2_H071251019;

import java.util.Random;

public class DataProcessor {
    private final Random random = new Random();

    public int process(String fileName) throws InterruptedException {
        int waktuMs = random.nextInt(1501) + 500;
        Thread.sleep(waktuMs);

        return random.nextInt(451) + 50;
    }
} //akhir