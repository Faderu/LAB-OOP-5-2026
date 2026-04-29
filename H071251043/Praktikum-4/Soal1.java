import java.util.Scanner;

public class Soal1 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("===== BANGUN RUANG =====");
    System.out.println("1. Kubus");
    System.out.println("2. Balok");
    System.out.println("3. Bola");
    System.out.println("4. Tabung");
    System.out.println("===== BANGUN DATAR =====");
    System.out.println("5. Persegi");
    System.out.println("6. Persegi Panjang");
    System.out.println("7. Lingkaran");
    System.out.println("8. Trapesium");
    System.out.print("\nPILIHAN = ");

    int pilihan = input.nextInt();

    if (pilihan == 1){
      Kubus kubus = new Kubus();
      kubus.input();
      kubus.luas();
      kubus.volume();
    }
    else if (pilihan == 2){
      Balok balok = new Balok();
      balok.input();
      balok.luas();
      balok.volume();
    }
    else if (pilihan == 3){
      Bola bola = new Bola();
      bola.input();
      bola.luas();
      bola.volume();
    }    
    else if (pilihan == 4){
      Tabung tabung = new Tabung();
      tabung.input();
      tabung.luas();
      tabung.volume();
    }    
    else if (pilihan == 5){
      Persegi persegi = new Persegi();
      persegi.input();
      persegi.keliling();
      persegi.luas();
    }    
    else if (pilihan == 6){
      PersegiPanjang p = new PersegiPanjang();
      p.input();
      p.keliling();
      p.luas();
    }    
    else if (pilihan == 7){
      Lingkaran lingkaran = new Lingkaran();
      lingkaran.input();
      lingkaran.keliling();
      lingkaran.luas();
    }    
    else if (pilihan == 8){
      Trapesium trapesium = new Trapesium();
      trapesium.input();
      trapesium.keliling();
      trapesium.luas();
    }
  }
}

class Geometri {
  double keliling;
  double luas;
  double volume;
  double pi = 3.14;
  double sisi;
  double panjang;
  double lebar;
  double tinggi;
  double jari_jari;
  double diameter;

  Scanner input = new Scanner(System.in);
}

// =====================

class Kubus extends Geometri{
  void input(){
    System.out.print("Sisi: ");
    sisi = input.nextDouble();
  }

  double luas(){
    double hasil = 6 * Math.pow(sisi, 2);
    System.out.println("Luas : " + hasil);
    return hasil;
  }
  double volume(){
    double hasil = Math.pow(sisi, 3);
    System.out.println("Volume : " + hasil);
    return hasil;
  }
}

// =====================

class Balok extends Geometri{
  void input(){
    System.out.print("Panjang: ");
    panjang = input.nextDouble();
    System.out.print("Lebar: ");
    lebar = input.nextDouble();
    System.out.print("Tinggi: ");
    tinggi = input.nextDouble();
  }

  double luas(){
    double hasil = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    System.out.println("Luas : " + hasil);
    return hasil;
  }
  double volume(){
    double hasil = panjang * lebar * tinggi;
    System.out.println("Volume : " + hasil);
    return hasil;
  }
}

// =====================

class Bola extends Geometri{
  void input(){
    System.out.print("Jari-jari: ");
    jari_jari = input.nextDouble();
  }

  double luas(){
    double hasil = 4 * pi * Math.pow(jari_jari, 2);
    System.out.println("Luas : " + hasil);
    return hasil;
  }
  double volume(){
    double hasil = 4.0/3 * pi * Math.pow(jari_jari, 3);
    System.out.println("Volume : " + hasil);
    return hasil;
  }
}

// =====================

class Tabung extends Geometri{
  void input(){
    System.out.print("Jari-jari: ");
    jari_jari = input.nextDouble();
    System.out.print("Tinggi: ");
    tinggi = input.nextDouble();
  }

  double luas(){
    double hasil = 2 * pi * jari_jari * (jari_jari + tinggi);
    System.out.println("Luas : " + hasil);
    return hasil;
  }
  double volume(){
    double hasil = pi * Math.pow(jari_jari, 2) * tinggi;
    System.out.println("Volume : " + hasil);
    return hasil;
  }
}

// =====================

class Persegi extends Geometri{
  void input(){
    System.out.print("Sisi: ");
    sisi = input.nextDouble();
  }

  double keliling(){
    double hasil = 4 * sisi;
    System.out.println("Keliling : " + hasil);
    return hasil;
  }
  double luas(){
    double hasil = Math.pow(sisi, 2);
    System.out.println("Luas : " + hasil);
    return hasil;
  }
}

// =====================

class PersegiPanjang extends Geometri{
  void input(){
    System.out.print("Panjang: ");
    panjang = input.nextDouble();
    System.out.print("Lebar: ");
    lebar = input.nextDouble();
  }

  double keliling(){
    double hasil = 2 * (panjang + lebar);
    System.out.println("Keliling : " + hasil);
    return hasil;
  }
  double luas(){
    double hasil = panjang * lebar;
    System.out.println("Luas : " + hasil);
    return hasil;
  }
}

// =====================

class Lingkaran extends Geometri{
  void input(){
    System.out.print("Jari-jari: ");
    jari_jari = input.nextDouble();
  }

  double keliling(){
    double hasil = 2 * pi * jari_jari;
    System.out.println("Keliling : " + hasil);
    return hasil;
  }
  double luas(){
    double hasil = pi * Math.pow(jari_jari, 2);
    System.out.println("Luas : " + hasil);
    return hasil;
  }
}

// =====================

class Trapesium extends Geometri{
  double sisi1, sisi2, sisi3, sisi4;
  double a, b;

  void input(){
    System.out.print("Sisi 1: ");
    sisi1 = input.nextDouble();
    System.out.print("Sisi 2: ");
    sisi2 = input.nextDouble();
    System.out.print("Sisi 3: ");
    sisi3 = input.nextDouble();
    System.out.print("Sisi 4: ");
    sisi4 = input.nextDouble();

    System.out.print("Sisi sejajar a: ");
    a = input.nextDouble();
    System.out.print("Sisi sejajar b: ");
    b = input.nextDouble();
    System.out.print("Tinggi: ");
    tinggi = input.nextDouble();
  }

  double keliling(){
    double hasil = sisi1 + sisi2 + sisi3 + sisi4;
    System.out.println("Keliling : " + hasil);
    return hasil;
  }
  double luas(){
    double hasil = 0.5 * (a + b) * tinggi;
    System.out.println("Luas : " + hasil);
    return hasil;
  }
}