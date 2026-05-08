public class Main {
  public static void main(String[] args) {
    DompetDigital dompet = new DompetDigital("Budi", "ID001", "123456");

    System.out.println("NAMA : " + dompet.getNama());
    System.out.println("ID : " + dompet.getId());
    System.out.println("STATUS : " + dompet.getStatus());
    System.out.println("SALDO : " + dompet.getSaldo() + "\n");

    System.out.println("UJI 1 : Ubah PIN dengan PIN lama salah");
    dompet.setPin();

    System.out.println("UJI 2 : Ubah PIN dengan PIN lama benar");
    dompet.setPin();

    System.out.println("UJI 3 : Setor tunai valid");
    dompet.get_setor_tunai();

    System.out.println("UJI 4 : Setor tunai negatif");
    dompet.get_setor_tunai();

    System.out.println("UJI 5 : Tarik tunai dengan PIN salah");
    dompet.tarikTunai();

    System.out.println("UJI 6 : Tarik tunai dengan PIN benar");
    dompet.tarikTunai();

    System.out.println("SALDO AKHIR : " + dompet.getSaldo());
  }
}