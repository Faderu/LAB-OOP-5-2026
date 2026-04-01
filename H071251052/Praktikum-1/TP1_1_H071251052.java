import java.util.Scanner;

public class TP1_1_H071251052 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan kalimat: ");
        String kalimatAwal = x.nextLine();
        
        String kalimatAkhir = ubahKata(kalimatAwal);
        System.out.println("Output: " + kalimatAkhir);

        x.close();

    }
    
    public static String ubahKata(String teks) {
        String[] kalimat = teks.split(" ");
        StringBuilder hasil = new StringBuilder();

        for (String kata : kalimat) {
            if (!kata.isEmpty()){
                hasil.append(kata.substring(0,1).toUpperCase());
                if (kata.length() > 1) {
                    hasil.append(kata.substring(1).toLowerCase());
                }
                hasil.append(" ");
            }
        }
        return hasil.toString().trim();
    }
}