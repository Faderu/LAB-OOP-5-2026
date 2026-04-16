import java.util.Scanner;

public class Dompet {
    Scanner x = new Scanner(System.in);
    protected String namaNasabah;
    protected int norek;
    private int pin;
    private int saldo = 0;

    public Dompet(String namaNasabah, int pin, int norek) {
        this.namaNasabah = namaNasabah;
        this.pin = pin;
        this.norek = norek;
    }

    public void getInfo(){
        System.out.println("Nama Nasabah    :" + this.namaNasabah);
        System.out.println("Norek   :" + this.norek);
    }

    public void setPin(int Pinbaru){
        System.out.println("===== Ganti Pin =====");
        System.out.print("Masukkan Pin Lama: ");
        int pinlama = x.nextInt();
        Boolean valid = true;
        if (pinlama != this.pin){
            valid = false;
            System.out.println("PIN yang anda masukkan salah.");
        }
        String pinbaru = String.valueOf(Pinbaru);
        if(pinbaru.length() != 6) {
            valid = false;
            System.out.println("PIN harus 6 digit angka");
        }

        if(valid){
            this.pin = Pinbaru;
            System.out.println("Pin berhasil di ubah");

        }
    }

    private void setor (int uang){
        System.out.println("===== Setor Tunai =====");

        if (uang <= 0){
            System.out.println("input tidak valid");
        }
        else{
            this.saldo  += uang;
            System.out.println("saldo anda:" + this.saldo);
        }
    }
    public void getSetor (int uang){
        setor(uang);
        
        

    }
    public void tarik(int uang){
        System.out.println("===== Tarik Tunai =====");
        System.out.print("Masukkan Pin: ");
        Scanner x = new Scanner(System.in);
        int pinlama = x.nextInt();
        Boolean valid = true;
        if (pinlama != this.pin){
            valid = false;
            System.out.println("PIN yang anda masukkan salah.");
        }
        if (uang <= 0 || uang > this.saldo){
            System.out.println("saldo anda tidak cukup");
        }
        if (valid){
            this.saldo -= uang;
            System.out.println("berhasil saldo saat ini:" + this.saldo);
        }
    }
}