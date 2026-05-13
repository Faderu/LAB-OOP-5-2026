import java.util.Random;

public class DataProcessor{
     private final Random random = new Random();

     public int process(String fileName) throws InterruptedException{
        int durasi = random.nextInt(1501) + 500;
        Thread.sleep(durasi);
        return random.nextInt(900)+ 100;
     }
}