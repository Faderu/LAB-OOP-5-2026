package Tugas_1;

import java.util.Scanner;

public class T1_No4 {
    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        System.out.println();
        int angka = f.nextInt();
        int hasil = hitungFaktorial(angka);
        System.out.println(hasil);
    }
    static int hitungFaktorial(int angka) {
        if (angka == 0 || angka == 1) {
            return 1;
        } else {
            return angka * hitungFaktorial(angka - 1);

        }
    }
}
