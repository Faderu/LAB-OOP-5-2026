import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan Tanggal Lahir (dd-mm-yy): ");

        String[] date = x.nextLine().split("-");
        int tanggal = Integer.parseInt(date[0]);

        if (tanggal < 1 || tanggal > 31) {
            System.out.println("Tanggal tidak valid");
        }

        int bulan = Integer.parseInt(date[1]);
        if (bulan < 1 || bulan > 12) {
            System.out.println("Bulan tidak valid");
        }
        String month = "";
        switch (bulan) {
            case 1:
                month = "Januari";
                break;
            case 2:
                month = "Februari";
                break;
            case 3:
                month = "Maret";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "Mei";
                break;
            case 6:
               month = "Juni";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "Agustus";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "Oktober";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "Desember";
                break;

        }

        int tahun = Integer.parseInt(date[2]);
        if (tahun > 26) {
            tahun += 1900;
        } else if (tahun <= 0) {
            System.out.println("Tahun tidak valid");
        } else {
            tahun += 2000;
        }
        System.out.println(tanggal + " " + month + " " + tahun);
    }
}