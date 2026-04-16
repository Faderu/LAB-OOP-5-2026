package TP3_1_H071251052;

import java.util.Scanner;

public class Main {
    private static boolean tampilkanSubMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n1. Kembali ke Menu Utama");
            System.out.println("0. Keluar dari Program");
            System.out.print("Pilih [1/0] : ");
            String subPilihan = scanner.nextLine();

        switch (subPilihan) {
            case "1":
                return true;
            case "0":
                System.out.println("Keluar dari sistem. Terima kasih!");
                return false;
            default:
                System.out.println("[!!!] Input tidak valid. Masukkan 1 atau 0.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("           SELAMAT DATANG DI");
        System.out.println("             DOMPET DIGITAL");
        System.out.println("========================================");

        // Input data akun
        System.out.print("Masukkan ID Nasabah : ");
        String idNasabah = input.nextLine();

        System.out.print("Masukkan PIN (6 digit) : ");
        String pin = input.nextLine();

        DompetDigital dompet = new DompetDigital(idNasabah, pin);
        System.out.println();

        boolean berjalan = true;
        while (berjalan) {
            System.out.println("\n========================================");
            System.out.println("             DOMPET DIGITAL");
            System.out.println("========================================");
            System.out.println("1. Info Akun");
            System.out.println("2. Ubah PIN");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("0. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih menu (1-4): ");
            
            String pilihan = input.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.println("\n[1] INFO AKUN");
                    System.out.println("ID Nasabah : " + dompet.getIdNasabah());
                    System.out.println("Saldo : Rp " + dompet.getSaldo());
                    System.out.println("========================================");
                    berjalan = tampilkanSubMenu(input);
                    break;
                case "2":
                    System.out.println("\n[2] UBAH PIN");
                    System.out.println("Masukkan PIN lama : ");
                    String pinLama = input.nextLine();
                    System.out.println("Masukkan PIN baru : ");
                    String pinBaru = input.nextLine();
                    dompet.ubahPin(pinLama, pinBaru);
                    System.out.println("========================================");
                    berjalan = tampilkanSubMenu(input);
                    break;
                case "3":
                    System.out.println("\n[3] SETOR TUNAI");
                    System.out.println("Masukkan nominal setor : Rp ");
                    try {
                        double nominal = Double.parseDouble(input.nextLine());
                        dompet.setorTunai(nominal);
                    }catch (NumberFormatException e){
                        System.out.println("Input tidak valid. Masukin angka yang bener tod");
                    }
                    System.out.println("========================================");
                    berjalan = tampilkanSubMenu(input);
                    break;
                case "4":
                    System.out.println("\n[4] TARIK TUNAI");
                    System.out.println("Masukkan nominal tarik : Rp ");
                    try {
                        double nominal = Double.parseDouble(input.nextLine());
                        System.out.println("Masukkan PIN : ");
                        String pinInput = input.nextLine();
                        dompet.gettarikTunai(nominal, pinInput);
                    }catch(NumberFormatException e){
                        System.out.println("Input tidak valid. Masukin angka yang bener tod");
                    }
                    System.out.println("========================================");
                    berjalan = tampilkanSubMenu(input);
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Baca petunjuknya kocak");
            }
        }
        input.close();
    }
}


