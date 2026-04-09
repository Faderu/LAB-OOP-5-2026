import java.util.Scanner;
public class Task4 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan angka: ");
        int angka = x.nextInt();
        int faktorial = 1;
        for (int i = 1 ; i<= angka; i++) {
            faktorial *= i;
        }
        System.out.println(faktorial);
    }
}