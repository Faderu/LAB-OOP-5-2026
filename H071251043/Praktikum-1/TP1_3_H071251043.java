import java.util.Scanner;

public class TP1_3_H071251043 {
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.println("PROGRAM VALIDASI PASSWORD");
    System.out.print("Masukkan Password : ");
    String password = a.nextLine();
    boolean huruf_kapital = false;
    boolean huruf_kecil = false;
    boolean angka = false;

    for (int i = 0; i < password.length(); i++) {
      char check = password.charAt(i);

      if (Character.isUpperCase(check)){
        huruf_kapital = true;}
      if (Character.isLowerCase(check)){
        huruf_kecil = true;}
      if (Character.isDigit(check)){
        angka = true;}
      }

      if (!huruf_kapital || !huruf_kecil || !angka || password.length() < 8){
        System.out.println("PASSWORD TIDAK VALID! \nPASSWORD HARUS 8 KARAKTER \nHARUS ADA HURUF BESAR, HURUF KECIL, ANGKA");}
      else{
        System.out.println("PASSWORD BENAR!");
      }

    }
  }