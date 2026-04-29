package TP4_2_H071251019;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        Product [] daftarproduk = new Product[1000];
        int jumlah = 0; 
        int pilihan;

        daftarproduk[jumlah++] = (new Smartphone("Samsung", 123456, 899.99, 6.5, 256));
        daftarproduk[jumlah++] = (new Laptop("Dell", 987654, 1299.99, 16, "Intel Core i7"));
        daftarproduk[jumlah++] = (new Camera("Canon", 456789, 699.99, 24, "Telephoto"));

        do {
            System.out.println("\n=== MENU TOKO ELEKTRONIK ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih (1-4): ");
            pilihan = a.nextInt();
            a.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlah >= daftarproduk.length){
                        System.out.println("Stok Penuh!");
                        continue;} 
                       
                        System.out.print("Masukan nama produk: ");
                        String merek = a.nextLine();

                        System.out.print("Masukkan nomor seri: ");
                        int seri = a.nextInt();

                        System.out.print("Masukkan harga: ");
                        double harga = a.nextDouble();
                        
                        System.out.print("Pilih tipe produk: ");
                        System.out.println("\n1. Smartphone\n2. Laptop\n3. Kamera");
                        System.out.print("Pilih tipe: ");
                        int tipe = a.nextInt();
                        a.nextLine();

                        if (tipe == 1){
                            System.out.print("Masukkan ukuran layar (inci): ");
                            double layar = a.nextDouble();
                            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                            int gb = a.nextInt();
                            daftarproduk[jumlah++] = (new Smartphone(merek, seri, harga, layar, gb));
                        } else if (tipe == 2){
                            System.out.print("Masukkan RAM (GB): ");
                            int ram = a.nextInt();
                            System.out.print("Masukkan tipe processor: ");
                            String processor = a.nextLine();
                            daftarproduk[jumlah++] = (new Laptop(merek, seri, harga, ram, processor));
                        } else if (tipe == 3){
                            System.out.print("Masukkan resolusi: ");
                            int res = a.nextInt();
                            System.out.print("Masukkan tipe lens: ");
                            String lens = a.nextLine();
                            daftarproduk[jumlah++] = (new Camera(merek, seri, harga, res, lens));
                        } else {
                            System.out.println("Inputan tidak valid!");}
                    break;
                case 2:
                    if (jumlah == 0){
                        System.out.println("Belum ada produk.");
                        break;
                    } else {
                        System.out.println("\n=== DAFTAR PRODUK ===");
                        for (int i = 0; i < jumlah; i++) {
                            System.out.println("\n----------------------");
                            daftarproduk[i].displayinfo();}
                    } break;
                case 3:
                    System.out.print("Masukkan nomor seri produk yang ini dibeli: ");
                    int cari = a.nextInt();
                    boolean ada = false;

                    for(int i = 0; i <= jumlah; i++){
                        if (daftarproduk[i].seriesNumber == cari){
                            System.out.println("Anda telah membeli produk: ");
                            daftarproduk[i].displayinfo();

                            for (int j = i; j < jumlah - 1; j++) {
                                daftarproduk[j] = daftarproduk[j + 1];
                            }
                            jumlah--;
                            ada = true;
                            break;
                        } 
                    } if (!ada){
                        ada = false;
                    }

                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Inputan tidak valid!");
                    break;
            }
        } while (pilihan != 4);

        a.close();
    }
}


