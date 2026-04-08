public class Main {
    public static void main(String[] args) {
        System.out.println("Kucing Liar");
        Kucing ujikucing = new Kucing();
        ujikucing.infokan();
        System.out.println("===============================");
        
        System.out.println("\n===============================");
        Owner manusia1 = new Owner("Pak budi", 10);
        Owner manusia2 = new Owner("Budi", 1);
        // manusia1.cekInfoOwner();

        Kucing kucing1 = new Kucing("Heli", "Anggora", 3, manusia1);
        Kucing kucing2 = new Kucing("Halo", "Persia", 4, manusia2);
        kucing1.infokan();
        kucing2.infokan();

        System.out.println("===============================");
        System.out.println("Jenis jenis aksi: Merebut makanan babu, Jatuhkan Barang, Mencakar sofa, Buang air sembarangan.");
        System.out.println("===============================");
        kucing1.aksibarbar(" ");
        kucing2.aksibarbar("Jatuhkan Barang");
        kucing1.infokan();
        kucing2.infokan();
        System.out.println("===============================");

        kucing1.rebutmakanan(kucing2);
        System.out.println("===============================");

        System.out.println("Kondisi akhir");
        kucing1.infokan();
        kucing2.infokan();

    //    System.out.println(manusia1.getnamaOwner());

    }
    

} //akhir
