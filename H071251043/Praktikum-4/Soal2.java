import java.util.ArrayList;
import java.util.Scanner;

public class Soal2 {

  static ArrayList<Product> daftar = new ArrayList<>();
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    int pilihan;

    do {
      System.out.println("\n=============== MENU ===============");
      System.out.println("1. Tambah Produk");
      System.out.println("2. Tampilkan Semua Produk");
      System.out.println("3. Beli Produk");
      System.out.println("4. Keluar");
      
      System.out.print("\nPILIHAN = ");
      pilihan = input.nextInt();
      input.nextLine();
      System.out.println("====================================");

      if (pilihan == 1) tambahProduk();
      else if (pilihan == 2) tampilkanSemua();
      else if (pilihan == 3) beliProduk();
      else if (pilihan == 4) System.out.println("Terima kasih telah mengunjungi toko kami");
      else System.out.println("Pilihan tidak valid! Silahkan coba lagi");


    } while (pilihan != 4);
  }

  static void tambahProduk(){
    System.out.print("Masukkan nama produk : ");
    String nama_produk = input.nextLine();
    System.out.print("Masukkan nomor seri : ");
    int nomor_seri = input.nextInt();
    System.out.print("Masukkan harga : ");
    double harga = input.nextDouble();

    System.out.println("Tipe produk =");
    System.out.println("1. Smartphone");
    System.out.println("2. Laptop");
    System.out.println("3. Camera");
    System.out.print("Pilihan : ");
    int tipe_produk = input.nextInt();
    input.nextLine();

    if (tipe_produk == 1) {
      System.out.print("Screen Size : ");
      double screenSize = input.nextDouble();
      input.nextLine();
      System.out.print("Storage : ");
      int storageCapacity = input.nextInt();
      input.nextLine();
      Smartphone smartphone = new Smartphone(nama_produk, nomor_seri, harga, screenSize, storageCapacity);
      daftar.add(smartphone);
      System.out.println(nama_produk + " BERHASIL DITAMBAHKAN");
    }

    else if (tipe_produk == 2) {
      System.out.print("Ram Size : ");
      int ramSize = input.nextInt();
      input.nextLine();
      System.out.print("Processor Type : ");
      String processorType = input.nextLine();
      Laptop laptop = new Laptop(nama_produk, nomor_seri, harga, ramSize, processorType);
      daftar.add(laptop);
      System.out.println(nama_produk + " BERHASIL DITAMBAHKAN");

    }

    else if (tipe_produk == 3) {
      System.out.print("Resolution : ");
      int resolution = input.nextInt();
      input.nextLine();
      System.out.print("Lens Type : ");
      String lensType = input.nextLine();
      Camera camera = new Camera(nama_produk, nomor_seri, harga, resolution, lensType);
      daftar.add(camera);
      System.out.println(nama_produk + " BERHASIL DITAMBAHKAN");
    }
    else {
      System.out.println("Pilihan tidak valid! Silahkan coba lagi");
      return;
    }
  }

  static void tampilkanSemua(){
    System.out.println("========== DAFTAR PRODUK ==========");
    if (daftar.isEmpty()){
      System.out.println("Belum ada produk");
      return;
    }
    else{
      for (Product p : daftar) {
        p.displayInfo();
      }
    }
  }

  static void beliProduk(){
    System.out.print("Masukkan Nomor Seri Produk yang ingin di beli : ");
    int beli_nomor_seri = input.nextInt();
    input.nextLine();
    int indeks_ketemu = -1;
    for (int i = 0; i < daftar.size(); i++) {
      if (daftar.get(i).seriesNumber == beli_nomor_seri) {
        indeks_ketemu = i;
        break;
      }
    }
    if (indeks_ketemu == -1) {
      System.out.println("Produk tidak di temukan");
      System.out.println("Silahkan coba lagi");
      return;
    }
    else {
      Product p = daftar.get(indeks_ketemu);
      System.out.println("Anda telah membeli produk : ");
      p.displayInfo();
      daftar.remove(indeks_ketemu);
      System.out.println("=== PEMBELIAN BERHASIL ===");
    }
  }

  // ==========================================

  static class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
      this.brand = brand;
      this.seriesNumber = seriesNumber;
      this.price = price;
    }

    void displayInfo(){
      System.out.println("\nBrand : " + brand);
      System.out.println("Series Number : " + seriesNumber);
      System.out.println("Price : " + price);
    }
  }

  // ==========================================

  static class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
      super(brand, seriesNumber, price);
      this.screenSize = screenSize;
      this.storageCapacity = storageCapacity;
    }

    @Override
    void displayInfo() {
      super.displayInfo();
      System.out.println("Screen Size : " + screenSize + " inches");
      System.out.println("Storage Capacity : " + storageCapacity + "GB");
    }
  }

    // ==========================================

  static class Laptop extends Product {
    int ramSize;
    String processorType;

    public Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType) {
      super(brand, seriesNumber, price);
      this.ramSize = ramSize;
      this.processorType = processorType;
    }

    @Override
    void displayInfo() {
      super.displayInfo();
      System.out.println("Ram Size : " + ramSize + "GB");
      System.out.println("Processor Type : " + processorType);
    }
  }

  // ==========================================

  static class Camera extends Product {
    public Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
      super(brand, seriesNumber, price);
      this.resolution = resolution;
      this.lensType = lensType;
    }

    int resolution;
    String lensType;

    @Override
    void displayInfo() {
      super.displayInfo();
      System.out.println("Resolution : " + resolution + "MP");
      System.out.println("Lens Type : " + lensType);
    }
  }


}