package Tugas_1;

import java.util.Scanner;

public class T1_No5 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, 
                        {4, 5, 6}, 
                        {7, 8, 9}};
        Scanner o = new Scanner(System.in);

        try {
            System.out.println("Input angka: ");
            int cari = o.nextInt();
            boolean ketemu = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("\nOutput:");
                        System.out.println("Ditemukan " + cari + " pada [" + i + "][" + j + "]");
                        ketemu = true;
                        break;
                    }
                }
                if (ketemu == true) {
                    break;
                }
            }
            if (ketemu == false) {
                System.out.println("\nOutput:\nAngka tidak ada di array");
            }
        } catch (Exception e) {
            System.out.println("\nOutput:\nInputan tidak valid");
        }
    }
}
