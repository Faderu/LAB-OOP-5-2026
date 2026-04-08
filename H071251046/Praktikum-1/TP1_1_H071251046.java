package Tugas_1;

import java.util.Scanner;

public class T1_No1 {
    public static void main(String[] args) {
        System.out.println("Masukkan Judul Film : ");
        Scanner j = new Scanner(System.in);
        String Judul = j.nextLine();
        j.close();

        System.out.println("Hasil : " + kapitalAwal(Judul));
    }
        static String kapitalAwal(String kalimat) {
            kalimat = kalimat.toLowerCase();
            String[] kata = kalimat.split(" ");
            String hasil = "";
            for (int i = 0; i < kata.length; i++) {
                if (kata[i].length() > 0) {
                    String hurufPertama = kata[i].substring(0, 1).toUpperCase();
                    String sisanya = kata[i].substring(1);
                    hasil = hasil + hurufPertama + sisanya + " ";
                }
            }
        return hasil.trim();
        }
    }

