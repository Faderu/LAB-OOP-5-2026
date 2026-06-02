import java.util.Random;

class Kurir implements Runnable {
  private Gudang gudang;
  private Random random = new Random();

  public Kurir (Gudang gudang) {
    this.gudang = gudang;
  }

  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        int jumlah = random.nextInt(4) + 1;

        gudang.ambilStok(jumlah);

        int waktu = random.nextInt(1001) + 2000;
        Thread.sleep(waktu);
      }
    } catch (InterruptedException e) {
      System.out.println("Kurir berhenti bekerja");
    }
  }
}