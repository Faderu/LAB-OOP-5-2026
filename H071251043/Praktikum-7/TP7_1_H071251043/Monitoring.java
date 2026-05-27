class Monitoring implements Runnable {
  private Gudang gudang;

  public Monitoring(Gudang gudang) {
    this.gudang = gudang;
  }

  public void run() {
    try {
      while (!Thread.currentThread().isInterrupted()) {
        int stok = gudang.getStok();
        int kapasitas = gudang.getKapasitasMaksimal();

        int persen = (stok * 100) / kapasitas;
        int jumlahBar = persen / 10;

        String bar = "[";

        for (int i = 0; i < 10; i++) {
          if (i < jumlahBar) {
            bar += "#";
          } else {
            bar += " ";
          }
        }
        bar += "]";

        System.out.println("Status Gudang : " + bar + " " + persen + "%");
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Monitoring berhenti");
    }
  }
  
}