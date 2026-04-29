import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Produk[] stokProduk = new Produk[100];
        int jumlahStok = 0;

        int pilihan;

        do {
            System.out.println("\n=== MENU TOKO ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:
                   
                    System.out.print("Brand: ");
                    String brand = input.nextLine();
                    System.out.print("Nomor Seri: ");
                    int noSeri = input.nextInt();
                    System.out.print("Price: ");
                    double price = input.nextDouble();

                    System.out.println("1. Handphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Kamera");
                    System.out.print("Pilih jenis: ");
                    int jenis = input.nextInt();
                    input.nextLine();

                    if (jenis == 1) {
                        System.out.print("screenSize: ");
                        double screenSize = input.nextDouble();
                        System.out.print("Kapasitas: ");
                        int kapasitas = input.nextInt();

                        stokProduk[jumlahStok] = new Handphone(brand, noSeri, price, screenSize, kapasitas);
                        jumlahStok++;

                    } else if (jenis == 2) {
                        input.nextLine();
                        System.out.print("Processor: ");
                        String processor = input.nextLine();
                        System.out.print("RAM Size: ");
                        int ramSize = input.nextInt();

                        stokProduk[jumlahStok] = new Laptop(brand, noSeri, price, processor, ramSize);
                        jumlahStok++;

                    } else if (jenis == 3) {
                        System.out.print("Resolusi: ");
                        int resolusi = input.nextInt();
                         System.out.print("Lens Type: ");
                        String lensType = input.nextLine();


                        stokProduk[jumlahStok] = new Kamera(brand, noSeri, price, resolusi, lensType);
                        jumlahStok++;
                    }

                    System.out.println("Produk berhasil ditambahkan!");
                    break;

                case 2:
                    if (jumlahStok == 0) {
                        System.out.println("Belum ada produk.");
                    } else {
                        for (int i = 0; i < jumlahStok; i++) {
                            System.out.println("\n--- Produk ---");
                            stokProduk[i].info();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan Nomor Seri: ");
                    int cari = input.nextInt();

                    boolean ditemukan = false;

                    for (int i = 0; i < jumlahStok; i++) {
                        if (stokProduk[i].noSeri == cari){
                            System.out.println("\nProduk ditemukan:");  
                            stokProduk[i].info();

                            
                            for (int j = i; j < jumlahStok - 1; j++) {
                                stokProduk[j] = stokProduk[j + 1];
                            }
                            jumlahStok--;

                            System.out.println("Produk berhasil dibeli!");
                            ditemukan = true;
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Produk tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami, sampai jumpa!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 4);

        input.close();
    }
}
