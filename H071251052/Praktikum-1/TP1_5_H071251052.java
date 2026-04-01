import java.util.Scanner;

public class TP1_5_H071251052 {
    public static void main(String[] args) {
        int[][] num = {{1, 2, 3},
                        {4, 5, 6},
                        {7, 5, 9}};

        Scanner alf = new Scanner(System.in);
        System.out.print("Masukkan angka yang dicari: ");

        try {
            int target = alf.nextInt();
            boolean found = false;

            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num[i].length; j++) {
                    if (num[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                System.out.println("Angka " + target + " tidak ditemukan dalam array.");
            }

        } catch (Exception e) {
            System.out.println("Input tidak valid: " + e.getMessage());
        } finally {
            alf.close();
        }
    }
}