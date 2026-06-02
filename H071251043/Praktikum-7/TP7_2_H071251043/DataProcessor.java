import java.util.Random;

class DataProcessor {
    private Random random = new Random();

    public int process(String fileName) {
        try {
            int sleepTime = random.nextInt(1501) + 500;
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Proses terganggu untuk file: " + fileName);
        }

        return random.nextInt(900) + 100;
    }
}