import java.util.Scanner;

public class TP1_5_H071251043 {
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.println("PROGRAM MENCARI n DALAM ARRAY 2D");
    System.out.print("Input n = ");
    int n = 0;

    try {
      n = a.nextInt();
    } catch (Exception e) {
      System.out.println("INPUT HARUS BERUPA ANGKA!");
      return;
    }

    int[][] nums = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}};
    boolean ditemukan = false;

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        if (nums[i][j] == n){
          ditemukan = true;
          System.out.printf("%d ditemukan pada posisi array [%d][%d]", n, i, j);
          break;
        }
      }
      if (ditemukan){
        break;
      }
    }

    if (!ditemukan){
      System.out.printf("%d tidak ada dalam array\n", n);
    }


  }
}
