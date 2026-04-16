public class Main{
    public static void main(String[] args) {
        
        DompetDigital dompet = new DompetDigital("OOP05", "090107");

        System.out.println("ID Nasabah: " + dompet.getIDnasabah());

        dompet.setPin("11111", "102030");

        dompet.setPin("090107", "102030");

        dompet.setor(30000000);

        dompet.setor(-200000);

        dompet.getTarik("090107", 2000000);

        dompet.getTarik("102030", 2000000);

        System.out.println("Saldo akhir: " + dompet.getsaldo());
    }
}