import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        try {
            int[][] matriks = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            System.out.print("Angka yang dicari : ");
            int cari = x.nextInt();
            boolean nilai = false;

            for (int i = 0; i < matriks.length; i++) {
                for (int t = 0; t < matriks[i].length; t++) {
                    if (matriks[i][t] == cari) {
                        System.out.printf("Found %d at [%d] [%d]", cari, i, t);
                        nilai = true;
                        break;
                    }
                }
            }
            if (nilai == false) {
                System.out.println("Not Found");
            }
        }catch (Exception e) {
            System.out.println("Input tidak valid");
        }
    }
}