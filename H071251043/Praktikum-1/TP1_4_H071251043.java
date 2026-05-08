import java.util.Scanner;

public class TP1_4_H071251043 {
  static int faktorial(int n) {
    if (n < 0){
      return 0;
    } else if (n == 0 || n == 1){
      return 1;
    } else {
      return (n * faktorial(n-1));
    }
  }

  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.println("PROGRAM PERHITUNGAN FAKTORIAL");
    System.out.print("Input n = ");
    int n = a.nextInt();
    int hasil = faktorial(n);

    if (hasil == 0){
      System.out.println("n TIDAK BOLEH NEGATIF");
    } else{System.out.printf("Hasil Faktorial dari n (%d) = %d", n, hasil);}


  }
}
