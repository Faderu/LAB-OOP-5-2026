import java.util.Scanner;
public class Task1{
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan Judul : ");

        String[] kalimat = x.nextLine().split(" ");
        String hasil = "";

        for (String kata : kalimat) {
            if (kata.length() > 0) {
                hasil += Character.toUpperCase(kata.charAt(0)) + kata.substring(1).toLowerCase()+ " ";
            }
        }
        System.out.println(hasil);
    }
}