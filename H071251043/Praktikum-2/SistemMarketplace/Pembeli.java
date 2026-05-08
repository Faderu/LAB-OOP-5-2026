package SistemMarketplace;

public class Pembeli {
  String nama;
  int saldo;
  Produk produk;

  public Pembeli(){
    nama = "Tanpa nama";
    saldo = 0;
    produk = null;
  }

  public Pembeli(String nama){
    this.nama = nama;
  }

  public Pembeli(String nama, int saldo){
    this.nama = nama;
    this.saldo = saldo;
  }

  public Pembeli(String nama, int saldo, Produk produk){
    this.nama = nama;
    this.saldo = saldo;
    this.produk = produk;
  }

  public void beliProduk(Produk p){
    System.out.println(nama + " mau membeli " + p.nama_produk);
    System.out.println("Processing...");
    
    // cek stok dan saldo
    if (p.stok > 0 && saldo >= p.harga){
      saldo -= p.harga;
      p.stok--;
      produk = p;

      System.out.println("Berhasil membeli " + p.nama_produk);
      System.out.println("Sisa saldo : " + saldo);
    }
    else if (p.stok == 0) {
      System.out.println("Gagal! Stok habis");
    }
    else {
      System.out.println("Gagal! Saldo tidak cukup");
    }
  }

  // interaksi antar objek
  public void rebutProduk(Pembeli lawan) {
    System.out.println(nama + " mencoba merebut produk dari " + lawan.nama);

    if (lawan.produk != null) {
      System.out.println(this.nama + " merebut produk dari " + lawan.nama);
      this.produk = lawan.produk;
      lawan.produk = null;
    }
    else {
      System.out.println("Gagal! " + lawan.nama + " tidak punya produk");
    }
  }

  public void checkStatus(){
    System.out.println("Status " + nama);
    System.out.println(nama);
    System.out.println("Saldo : " + saldo); 

    if (produk != null) {
      System.out.println("Produk : " + produk.nama_produk);
    }
    else {
      System.out.println("Produk : -");
    }
  } 
}
