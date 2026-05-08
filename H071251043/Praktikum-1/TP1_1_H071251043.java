import java.util.Scanner;

public class TP1_1_H071251043{
  public static void main(String[] args) {
    Scanner a = new Scanner(System.in);

    System.out.print("Masukkan Judul Film = ");
    String judul_film[] = a.nextLine().split(" ");
    String result = "";

    for(String word : judul_film){
      result += word.substring(0,1).toUpperCase() + word.substring(1, word.length()).toLowerCase() + " ";}

    System.out.println(result);

    a.close();

  }
}
