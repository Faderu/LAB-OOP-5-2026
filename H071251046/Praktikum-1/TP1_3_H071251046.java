package Tugas_1;

import java.util.Scanner;

public class T1_No3 {
    public static void main(String[] args) {
        Scanner p = new Scanner(System.in);
        System.out.println("Masukkan Password: ");
        String pass = p.nextLine();
        if (pass.length() < 8) {
            System.out.println("Password harus terdiri dari minimal 8 karakter");
        } else if (!pass.matches(".*[A-Z].*")) {
            System.out.println("Password harus mengandung setidaknya satu huruf kapital");
        } else if (!pass.matches(".*[a-z].*")) {
            System.out.println("Password harus mengandung setidaknya satu huruf kecil");
        } else if (!pass.matches(".*\\d.*")) {
            System.out.println("Password harus mengandung setidaknya satu angka");
        } else {
            System.out.println("Password valid");
        }
    }
}
