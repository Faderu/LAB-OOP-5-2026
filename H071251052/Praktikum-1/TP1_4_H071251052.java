import java.util.Scanner;

public class TP1_4_H071251052 {
    public static void main(String[] args) {
        Scanner alf = new Scanner(System.in);
        System.out.println("Input: ");
        int n = alf.nextInt();

        alf.close();
        System.out.println("Output: " + hitungFaktorial(n));
    }

    public static long hitungFaktorial(int n) {
        if (n <= 1) return 1;
        return n * hitungFaktorial(n - 1);
    }
}