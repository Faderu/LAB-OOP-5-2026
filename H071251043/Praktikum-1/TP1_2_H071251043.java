import java.util.Scanner;

public class TP1_2_H071251043{
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.println("KONVERSI FORMAT TANGGAL");
    System.out.print("Input Format Tanggal (dd-mm-yy) = ");
    String inputan[] = a.nextLine().split("-");
    String tanggal = inputan[0];
    int bulan = Integer.parseInt(inputan[1]);
    String nama_bulan = "";
    int tahun = Integer.parseInt(inputan[2]);
    String tahun_4digit = "";

    if (bulan == 1){nama_bulan = "Januari";}
    else if (bulan == 2){nama_bulan = "Februari";}
    else if (bulan == 3){nama_bulan = "Maret";}
    else if (bulan == 4){nama_bulan = "April";}
    else if (bulan == 5){nama_bulan = "Mei";}
    else if (bulan == 6){nama_bulan = "Juni";}
    else if (bulan == 7){nama_bulan = "Juli";}
    else if (bulan == 8){nama_bulan = "Agustus";}
    else if (bulan == 9){nama_bulan = "September";}
    else if (bulan == 10){nama_bulan = "Oktober";}
    else if (bulan == 11){nama_bulan = "November";}
    else if (bulan == 12){nama_bulan = "Desember";}
    else {
      System.out.println("Error, Bulan tidak valid");
      a.close();
      return;
    }

    if (tahun >= 00 && tahun <= 26) {
      tahun_4digit = "20" + String.format("%02d", tahun);
    } else {
      tahun_4digit = "19" + tahun;
    }
    
    System.out.println(tanggal + " " + nama_bulan + " " + tahun_4digit);

    a.close();
  }
}
