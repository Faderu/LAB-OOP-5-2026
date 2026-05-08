import java.util.Scanner;

class DompetDigital {
  Scanner a = new Scanner(System.in);

  protected String nama;
  protected String id;
  private String pin;
  private int saldo;
  String status;

  public DompetDigital(String nama, String id, String pin) {
    this.nama = nama;
    this.id = id;
    this.pin = pin;
    this.saldo = 0;
    this.status = "AKTIF";
  }

  public String getNama() {
    return nama;
  }

  public String getId() {
    return id;
  }

  public int getSaldo() {
    return saldo;
  }

  public String getStatus() {
    return status;
  }

  public void setPin() {
    System.out.print("Masukkan Pin Lama : ");
    String pin_lama = a.nextLine();

    if (this.pin.equals(pin_lama)) {
      System.out.print("Input Pin Baru : ");
      String pin_baru = a.nextLine();

      if (pin_baru.length() == 6) {
        this.pin = pin_baru;
        System.out.println("PIN BERHASIL DIUBAH \n");
        logTransaksi("UBAH PIN BERHASIL");
      }
      else {
        System.out.println("PIN HARUS TERDIRI DARI 6 KARAKTER \n");
        logTransaksi("UBAH PIN GAGAL");
      }
    }
    else {
      System.out.println("PIN SALAH \n");
      logTransaksi("UBAH PIN GAGAL");
    }
  }

  private void setorTunai() {
    System.out.print("Masukkan Jumlah Setoran Tunai : ");
    int setoran_tunai = a.nextInt();
    a.nextLine();

    if (setoran_tunai < 0) {
      System.out.println("Setoran Tunai Tidak Boleh Negatif \n");
      logTransaksi("SETOR TUNAI GAGAL");
    }
    else {
      saldo = saldo + setoran_tunai;
      System.out.println("Saldo Berhasil Ditambah");
      System.out.println("Saldo : " + saldo + "\n");
      logTransaksi("SETOR TUNAI BERHASIL");
    }
  }

  public void get_setor_tunai() {
    setorTunai();
  }

  public void tarikTunai() {
    System.out.print("Masukkan Pin : ");
    String inputan_pin = a.nextLine();

    if (validasiPin(inputan_pin)) {
      System.out.print("Masukkan Jumlah Tarik Tunai : ");
      int tarik_tunai = a.nextInt();
      a.nextLine();

      if (tarik_tunai < 0) {
        System.out.println("Tarik Tunai Tidak Boleh Negatif \n");
        logTransaksi("TARIK TUNAI GAGAL");
      }
      else if (tarik_tunai > saldo) {
        System.out.println("Saldo Tidak Cukup \n");
        logTransaksi("TARIK TUNAI GAGAL");
      }
      else {
        saldo = saldo - tarik_tunai;
        System.out.println("Ditarik Uang Sebesar " + tarik_tunai);
        System.out.println("Saldo : " + saldo + "\n");
        logTransaksi("TARIK TUNAI BERHASIL");
      }
    }
    else {
      System.out.println("PIN SALAH \n");
      logTransaksi("TARIK TUNAI GAGAL");
    }
  }

  private boolean validasiPin(String inputan_pin) {
    if (this.pin.equals(inputan_pin)) {
      return true;
    }
    else {
      return false;
    }
  }

  private void logTransaksi(String pesan) {
    System.out.println("LOG SISTEM : " + pesan);
  }
}
