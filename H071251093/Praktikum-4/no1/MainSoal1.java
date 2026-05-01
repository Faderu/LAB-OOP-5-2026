package no1;
import java.util.Scanner;

public class MainSoal1 {
    public void showMenu() {
        System.out.println("--------------------------------");
        System.out.println("   ===== BANGUN RUANG =====");
        System.out.println("1. KUBUS \n2. BALOK \n3. BOLA \n4. TABUNG \n");
        
        System.out.println("   ===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI \n6. PERSEGI PANJANG \n7. LINGKARAN \n8. TRAPESIUM");
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Scanner np = new Scanner(System.in);
        MainSoal1 main = new MainSoal1();

        main.showMenu();
        System.out.print("Pilihan : "); int pilihan = np.nextInt();
        
        System.out.println("--------------------------------");
        switch (pilihan) {
            case 1:
                Kubus cube = new Kubus();
                System.out.print("Sisi Kubus : "); cube.sisi = np.nextDouble();
                System.out.printf("Volume Kubus : %.2f", cube.hitungVolume());
                System.out.printf("\nLuas Permukaan Kubus : %.2f", cube.luasPermukaan());
                break;
            case 2:
                Balok blk = new Balok();
                System.out.print("Panjang Balok : "); blk.p = np.nextDouble();
                System.out.print("Lebar Balok : "); blk.l = np.nextDouble();
                System.out.print("Tinggi Balok : "); blk.t = np.nextDouble();
                System.out.printf("Volume Balok : %.2f", blk.hitungVolume());
                System.out.printf("\nLuas Permukaan Balok : %.2f", blk.luasPermukaan());
                break;
            case 3:
                Bola ball = new Bola();
                System.out.print("Jari jari Bola : "); ball.r = np.nextDouble();
                System.out.printf("Volume Bola : %.2f", ball.hitungVolume());
                System.out.printf("\nLuas Permukaan Bola : %.2f", ball.luasPermukaan());
                break;
            case 4:
                Tabung tube = new Tabung();
                System.out.print("Jari jari Tabung : "); tube.r = np.nextDouble();
                System.out.print("Tinggi Tabung : "); tube.t = np.nextDouble();
                System.out.printf("Volume Tabung : %.2f", tube.hitungVolume());
                System.out.printf("\nLuas Permukaan Tabung : %.2f", tube.luasPermukaan());
                break;
            case 5:
                Persegi sqr = new Persegi();
                System.out.print("Sisi Persegi : "); sqr.s = np.nextDouble();
                System.out.printf("Luas Persegi : %.2f", sqr.hitungLuas());
                System.out.printf("\nKeliling Persegi : %.2f", sqr.hitungKeliling());
                break;
            case 6:
                PersegiPanjang pg = new PersegiPanjang();
                System.out.print("Panjang Persegi Panjang : "); pg.p = np.nextDouble();
                System.out.print("Lebar Persegi Panjang : "); pg.l = np.nextDouble();
                System.out.printf("Luas Persegi Panjang : %.2f", pg.hitungLuas());
                System.out.printf("\nKeliling Persegi Panjang : %.2f", pg.hitungKeliling());
                break;
            case 7:
                Lingkaran crcl = new Lingkaran();
                System.out.print("Jari jari Lingkaran : "); crcl.r = np.nextDouble();
                System.out.printf("Luas Persegi Panjang : %.2f", crcl.hitungLuas());
                System.out.printf("\nKeliling Persegi Panjang : %.2f", crcl.hitungKeliling());
                break;
            case 8:
                Trapesium tra = new Trapesium();
                System.out.print("Sisi 1 Trapesium : "); tra.s1 = np.nextDouble();
                System.out.print("Sisi 2 Trapesium : "); tra.s2= np.nextDouble();
                System.out.print("Sisi 3 Trapesium : "); tra.s3 = np.nextDouble();
                System.out.print("Sisi 4 Trapesium : "); tra.s4 = np.nextDouble();
                System.out.print("TInggi Trapesium : "); tra.t = np.nextDouble();
                System.out.printf("Luas Trapesium : %.2f", tra.hitungLuas());
                System.out.printf("\nKeliling Trapesium : %.2f", tra.hitungKeliling());
                break;
            default:
                System.out.println("Inputan tak tersedia.");
        }
        System.out.println("\n--------------------------------");

        np.close();
    }
}