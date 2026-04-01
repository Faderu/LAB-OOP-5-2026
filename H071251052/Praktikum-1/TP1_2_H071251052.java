import java.util.Scanner;

public class TP1_2_H071251052 {
    public static void main(String[] args) {
        Scanner alf = new Scanner(System.in);
        System.out.println("Input:");
        String input = alf.nextLine();
        
        String[] bagian = input.split("-");
        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int year = Integer.parseInt(bagian[2]);

        String[] namaBulan = {
            "","Januari", "Februari", "Maret", "April", "Mei", "Juni", 
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        int tahun = (year <= 30) ? 2000 + year : 1900 + year; 

        System.out.println("Output:");
        System.out.println(hari + " " + namaBulan[bulan] + " " + tahun);


        alf.close();
    }
}