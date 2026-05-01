package no2;
import java.util.*;

// Superclass
class Produk {
    String merek;
    String nomorSeri;
    double harga;

    Produk(String merek, String nomorSeri, double harga) {
        this.merek = merek;
        this.nomorSeri = nomorSeri;
        this.harga = harga;
    }

    void tampilkan() {
        System.out.println("Merek: " + merek);
        System.out.println("No Seri: " + nomorSeri);
        System.out.println("Harga: " + harga);
    }
}

// Subclass Smartphone
class Smartphone extends Produk {
    String layar;
    int storage;

    Smartphone(String merek, String nomorSeri, double harga, String layar, int storage) {
        super(merek, nomorSeri, harga);
        this.layar = layar;
        this.storage = storage;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("Layar: " + layar);
        System.out.println("Storage: " + storage + "GB");
    }
}

// Subclass Laptop
class Laptop extends Produk {
    int ram;
    String processortype;


    Laptop(String merek, String nomorSeri, double harga, int ram, String processortype) {
        super(merek, nomorSeri, harga);
        this.ram = ram;
        this.processortype = processortype;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("RAM: " + ram);
        System.out.println("Processor Type: " + processortype);
    }
}

// Subclass Kamera
class Kamera extends Produk {
    int megapixel;
    String lenstype;

    Kamera(String merek, String nomorSeri, double harga, int megapixel, String lenstype) {
        super(merek, nomorSeri, harga);
        this.megapixel = megapixel;
        this.lenstype = lenstype;
    }

    void tampilkan() {
        super.tampilkan();
        System.out.println("MP: " + megapixel);
        System.out.println("Lenstype: "+ lenstype);
    }
}

// // Main Program
// public class TokoElektronik {
//     static ArrayList<Produk> stok = new ArrayList<>();
//     static Scanner input = new Scanner(System.in);

//     public static void main(String[] args) {
//         int pilihan;

//         do {
//             System.out.println("\n=== MENU ===");
//             System.out.println("1. Tambah Produk");
//             System.out.println("2. Tampilkan Produk");
//             System.out.println("3. Beli Produk");
//             System.out.println("4. Keluar");
//             System.out.print("Pilih: ");
//             pilihan = input.nextInt();

//             switch (pilihan) {
//                 case 1: tambahProduk(); break;
//                 case 2: tampilkanProduk(); break;
//                 case 3: beliProduk(); break;
//                 case 4: System.out.println("Terima kasih!"); break;
//                 default: System.out.println("Pilihan tidak valid");
//             }
//         } while (pilihan != 4);
//     }

//     static void tambahProduk() {
//         System.out.println("1. Smartphone  2. Laptop  3. Kamera");
//         int jenis = input.nextInt();

//         input.nextLine();
//         System.out.print("Merek: ");
//         String merek = input.nextLine();

//         System.out.print("No Seri: ");
//         String no = input.nextLine();

//         System.out.print("Harga: ");
//         double harga = input.nextDouble();

//         if (jenis == 1) {
//             input.nextLine();
//             System.out.print("Ukuran Layar: ");
//             String layar = input.nextLine();
//             System.out.print("Storage: ");
//             int storage = input.nextInt();
//             stok.add(new Smartphone(merek, no, harga, layar, storage));

//         } else if (jenis == 2) {
//             input.nextLine();
//             System.out.print("RAM: ");
//             int ram = input.nextInt();
//             String processortype = input.nextLine();
//             stok.add(new Laptop(merek, no, harga, ram, processortype));

//         } else if (jenis == 3) {
//             System.out.print("Megapixel: ");
//             int mp = input.nextInt();
//             in
//             stok.add(new Kamera(merek, no, harga, mp));
//         }

//         System.out.println("Produk berhasil ditambahkan!");
//     }

//     static void tampilkanProduk() {
//         if (stok.isEmpty()) {
//             System.out.println("Stok kosong!");
//             return;
//         }

//         for (Produk p : stok) {
//             System.out.println("\n------------------");
//             p.tampilkan();
//         }
//     }

//     static void beliProduk() {
//         input.nextLine();
//         System.out.print("Masukkan No Seri: ");
//         String cari = input.nextLine();

//         for (Produk p : stok) {
//             if (p.nomorSeri.equals(cari)) {
//                 System.out.println("Produk ditemukan:");
//                 p.tampilkan();
//                 System.out.println("Pembelian berhasil!");
//                 return;
//             }
//         }

//         System.out.println("Produk tidak ditemukan!");
//     }
// }