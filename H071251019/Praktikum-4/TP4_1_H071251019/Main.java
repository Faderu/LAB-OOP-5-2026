package TP4_1_H071251019;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.println("======= BANGUN RUANG =======");
        System.out.println("1. KUBUS\n2. BALOK\n3. BOLA\n4. TABUNG");
        System.out.println("\n======= BANGUN DATAR =======");
        System.out.println("5. PERSEGI\n6. PERSEGI PANJANG\n7. LINGKARAN\n8. TRAPESIUM");
        System.out.print("Pilihan: ");
        int pilihan = a.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double sisi = a.nextDouble();
                if (sisi <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Kubus kubus = new Kubus(sisi);
                System.out.println("Luas Kubus: " + kubus.hitungluas());
                System.out.println("Volume Kubus: " + kubus.hitungvolume());
                break;}

            case 2:
                System.out.print("Masukkan panjang balok: ");
                double panjang = a.nextDouble();
                System.out.print("Masukkan lebar balok: ");
                double lebar = a.nextDouble();
                System.out.print("Masukkan tinggi balok: ");
                double tinggi = a.nextDouble();
                if (panjang <= 0 || lebar <= 0 || tinggi <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Balok balok = new Balok(panjang, lebar, tinggi);
                System.out.println("Luas balok: " + balok.hitungluas());
                System.out.println("Volume balok: " + balok.hitungvolume());
                break;}

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double r = a.nextDouble();
                if (r <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Bola bola = new Bola(r);
                System.out.println("Luas bola: " + bola.hitungluas());
                System.out.println("Volume bola: " + bola.hitungvolume());
                break;}

            case 4:
                System.out.print("Masukkan panjang tabung: ");
                double rtabung = a.nextDouble();
                System.out.print("Masukkan tinggi tabung: ");
                double tinggitabung = a.nextDouble();
                if (rtabung <= 0 || tinggitabung <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Tabung tabung  = new Tabung (rtabung, tinggitabung);
                System.out.println("Luas Tabung : " + tabung.hitungluas());
                System.out.println("Volume Tabung : " + tabung.hitungvolume());
                break;}

            case 5: 
                System.out.print("Masukkan sisi persegi: ");
                double s = a.nextDouble();
                if (s <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Persegi persegi = new Persegi(s);
                System.out.println("Luas persegi: " + persegi.hitungluas());
                System.out.println("Keliling persegi: " + persegi.hitungkeliling());
                break;}

            case 6:
                System.out.print("Masukkan panjang persegi panjang: ");
                double ppp = a.nextDouble();
                System.out.print("Masukkan lebar persegi panjang: ");
                double lpp = a.nextDouble();
                if (ppp <= 0 || lpp <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                PersegiPanjang persegipanjang = new PersegiPanjang(ppp, lpp);
                System.out.println("Luas persegi panjang: " + persegipanjang.hitungluas());
                System.out.println("Keliling persegi panjang: " + persegipanjang.hitungkeliling());
                break;}

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double rl = a.nextDouble();
                if (rl <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Lingkaran lingkaran = new Lingkaran(rl);
                System.out.println("Luas lingkaran: " + lingkaran.hitungluas());
                System.out.println("Keliling lingkaran: " + lingkaran.hitungkeliling());
                break;}
            
            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double s1 = a.nextDouble();
                System.out.print("Masukkan sisi 2 trapesium: ");
                double s2 = a.nextDouble();
                System.out.print("Masukkan sisi 3 trapesium: ");
                double s3 = a.nextDouble();
                System.out.print("Masukkan sisi 4 trapesium: ");
                double s4 = a.nextDouble();
                System.out.print("Masukkan tinngi trapesium: ");
                double tinggitrap = a.nextDouble();
                if (s1 <= 0 || s2 <= 0 || s3 <= 0 || s4 <= 0 || tinggitrap <= 0) {
                    System.out.println("Error: Nilai tidak boleh negatif!");
                    break;
                } else {
                Trapesium persegipanjang = new Trapesium(s1, s2, s3, s4, tinggitrap);
                System.out.println("Luas persegi panjang: " + persegipanjang.hitungluas());
                System.out.println("Keliling persegi panjang: " + persegipanjang.hitungkeliling());
                break;}
            default:
                System.out.println("Pilih 1-8 ya.");
                break;
        }

    a.close();
    } //psvm 
} //akhir
