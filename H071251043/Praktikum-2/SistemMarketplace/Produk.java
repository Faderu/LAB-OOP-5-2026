package SistemMarketplace;

public class Produk {
  String nama_produk;
  int harga;
  int stok;
  String deskripsi;

  public Produk() {
    nama_produk = "Produk tanpa nama";
    harga = 0;
    stok = 0;
    deskripsi = "-";
  }

  public Produk(String nama_produk){
    this.nama_produk = nama_produk;
  }

  public Produk(String nama_produk, int harga){
    this.nama_produk = nama_produk;
    this.harga = harga;
  }

  public Produk(String nama_produk, int harga, int stok){
    this.nama_produk = nama_produk;
    this.harga = harga;
    this.stok = stok;
  }

  public Produk(String nama_produk, int harga, int stok, String deskripsi){
    this.nama_produk = nama_produk;
    this.harga = harga;
    this.stok = stok;
    this.deskripsi = deskripsi;
  }

  public void tampilProduk(){
    System.out.println("Nama  : " + nama_produk);
    System.out.println("Harga  : " + harga);
    System.out.println("Stok  : " + stok);
    System.out.println("Deskripsi  : " + deskripsi);
  }
}
  