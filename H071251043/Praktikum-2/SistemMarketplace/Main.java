package SistemMarketplace;

public class Main {
  public static void main(String[] args) {

    Produk snack_jumbo = new Produk("Snack Jumbo", 20, 1, "Snack Jumbo, praktis dan lezat");
    Produk choki = new Produk("Choki-choki", 5, 3, "Camilan cokelat pasta");

    Pembeli pembeli1 = new Pembeli("Chindy", 20, null);
    Pembeli pembeli2 = new Pembeli("Richie", 10, null);
    Pembeli pembeli3 = new Pembeli("Advent", 15, null);

    // kondisi awal
    pembatas();
    System.out.println("KONDISI AWAL");
    pembatas();
    pembeli1.checkStatus();
    pembatas();

    pembeli2.checkStatus();
    pembatas();

    pembeli3.checkStatus();
    pembatas();

    // aksi 1
    pembeli2.beliProduk(snack_jumbo);
    snack_jumbo.tampilProduk();
    pembeli2.checkStatus();
    pembatas();

    // aksi 2
    pembeli1.beliProduk(snack_jumbo);
    snack_jumbo.tampilProduk();
    pembeli1.checkStatus();
    pembatas();

    // aksi 3
    pembeli3.rebutProduk(pembeli1);
    pembeli3.checkStatus();
    pembatas();

    // aksi 4
    pembeli1.rebutProduk(pembeli3);
    pembeli1.checkStatus();
    pembatas();

    // aksi 5
    pembeli2.beliProduk(choki);
    choki.tampilProduk();
    pembeli2.checkStatus();
    pembatas();

    pembeli1.checkStatus();
    pembeli2.checkStatus();
    pembeli3.checkStatus();
  }



  public static void pembatas() {
    System.out.println("=====================================\n");
  }
}
