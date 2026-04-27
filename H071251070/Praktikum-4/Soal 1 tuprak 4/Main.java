import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== BANGUN DATAR ===");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Lingkaran");
        System.out.println("4. Trapesium");
        System.out.println("=== BANGUN RUANG ===");
        System.out.println("5. Kubus");
        System.out.println("6. Balok");
        System.out.println("7. Bola");
        System.out.println("8. Tabung");
        System.out.print("Pilih: ");
        int pilihan = input.nextInt();

        switch (pilihan) {

            case 1:
                System.out.print("Sisi: ");
                double sisiPersegi = input.nextDouble();
                Persegi persegi = new Persegi(sisiPersegi);
                System.out.println("Luas: " + persegi.luas());
                System.out.println("Keliling: " + persegi.keliling());
                break;

            case 2:
                System.out.print("Panjang: ");
                double panjangPersegiPanjang = input.nextDouble();
                System.out.print("Lebar: ");
                double lebarPersegiPanjang = input.nextDouble();
                PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang, lebarPersegiPanjang);
                System.out.println("Luas: " + persegiPanjang.luas());
                System.out.println("Keliling: " + persegiPanjang.keliling());
                break;

            case 3:
                System.out.print("Jari-jari: ");
                double jariJariLingkaran = input.nextDouble();
                Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);
                System.out.println("Luas: " + lingkaran.luas());
                System.out.println("Keliling: " + lingkaran.keliling());
                break;

            case 4:
                System.out.print("Sisi atas: ");
                double sisiAtasTrapesium = input.nextDouble();
                System.out.print("Sisi bawah: ");
                double sisiBawahTrapesium = input.nextDouble();
                System.out.print("Tinggi: ");
                double tinggiTrapesium = input.nextDouble();
                System.out.print("Sisi miring kiri: ");
                double sisiMiringKiriTrapesium = input.nextDouble();
                System.out.print("Sisi miring kanan: ");
                double sisiMiringKananTrapesium = input.nextDouble();

                Trapesium trapesium = new Trapesium(sisiAtasTrapesium, sisiBawahTrapesium, tinggiTrapesium, sisiMiringKiriTrapesium, sisiMiringKananTrapesium);

                System.out.println("Luas: " + trapesium.luas());
                System.out.println("Keliling: " + trapesium.keliling());
                break;

            case 5:
                System.out.print("Sisi: ");
                double sisiKubus = input.nextDouble();
                Kubus kubus = new Kubus(sisiKubus);
                System.out.println("Volume: " + kubus.volume());
                System.out.println("Luas: " + kubus.luas());
                break;

            case 6:
                System.out.print("Panjang: ");
                double panjangBalok = input.nextDouble();
                System.out.print("Lebar: ");
                double lebarBalok = input.nextDouble();
                System.out.print("Tinggi: ");
                double tinggiBalok = input.nextDouble();
                Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
                System.out.println("Volume: " + balok.volume());
                System.out.println("Luas: " + balok.luas());
                break;

            case 7:
                System.out.print("Jari-jari: ");
                double jariJariBola = input.nextDouble();
                Bola bola = new Bola(jariJariBola);
                System.out.println("Volume: " + bola.volume());
                System.out.println("Luas: " + bola.luas());
                break;

            case 8:
                System.out.print("Jari-jari: ");
                double jariJariTabung = input.nextDouble();
                System.out.print("Tinggi: ");
                double tinggiTabung = input.nextDouble();
                Tabung tabung = new Tabung(jariJariTabung, tinggiTabung);
                System.out.println("Volume: " + tabung.volume());
                System.out.println("Luas: " + tabung.luas());
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        input.close();
    }
}