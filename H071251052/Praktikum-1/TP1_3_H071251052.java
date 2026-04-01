import java.util.Scanner;

public class TP1_3_H071251052 {
    public static void main(String[] args) {
        Scanner alf = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = alf.nextLine();
        
        if (isValid(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        alf.close();

    }
    
    public static boolean isValid(String sandi) {
        if (sandi.length() < 8) return false;
        
        boolean hurufBesar = false, hurufKecil = false, Angka = false;
        
        for (char c : sandi.toCharArray()) {
            if (Character.isUpperCase(c)) hurufBesar = true;
            else if (Character.isLowerCase(c)) hurufKecil = true;
            else if (Character.isDigit(c)) Angka = true;
        }

        return hurufBesar && hurufKecil && Angka;
    }
}