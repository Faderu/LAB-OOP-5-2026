public class Main {
    public static void main(String[] args) {

        DompetDigital dompet = new DompetDigital("USR001", "123456");

        System.out.println("ID: " + dompet.getIdNasabah());

        dompet.ubahPin("000000", "654321");

        dompet.ubahPin("123456", "654321");

        dompet.setor(100000);

        dompet.setor(-5000);

        dompet.gettarik(50000, "123456");

        dompet.gettarik(50000, "654321");

        System.out.println("Saldo akhir: " + dompet.getSaldo());
    }
}