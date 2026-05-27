import java.util.Random;

class Pemasok implements Runnable {
  private Gudang gudang;
  private Random random = new Random();

  public Pemasok(Gudang gudang) {
    this.gudang = gudang;
  }

  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        int jumlah = random.nextInt(5) + 1;

        gudang.tambahStok(jumlah);

        int waktu = random.nextInt(1001) + 2000;
        Thread.sleep(waktu);
      }
    } catch (InterruptedException e) {
      System.out.println("Pemasok berhenti bekerja");
    }
  }
}