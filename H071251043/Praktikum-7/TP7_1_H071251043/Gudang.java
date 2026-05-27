class Gudang {
  private int stok;
  private int kapasitasMaksimal;

  public Gudang(int kapasitasMaksimal) {
      this.kapasitasMaksimal = kapasitasMaksimal;
      this.stok = 0; 
  }

  public synchronized void tambahStok(int jumlah) throws InterruptedException {
      while (stok + jumlah > kapasitasMaksimal) {
          System.out.println("Gudang penuh, pemasok menunggu");
          wait();
      }
      stok += jumlah;
      System.out.println("Pemasok menambah " + jumlah + " barang | Stok sekarang : " + stok);
      notifyAll();
  }

  public synchronized void ambilStok(int jumlah) throws InterruptedException {
      while (stok < jumlah) {
          System.out.println("Stok kurang, kurir menunggu..");
          wait();
      }
      stok -= jumlah;
      System.out.println("Kurir mengambil " + jumlah + " barang | Stok sekarang : " + stok);
      notifyAll();
  }

  public synchronized int getStok() {
      return stok;
  }

  public int getKapasitasMaksimal() {
      return kapasitasMaksimal;
  }
}