package TP5_2_H071251019;

public class SmartLamp extends PerangkatElektronik implements KontrolSuara{
    public SmartLamp(String merk, double watt) {
        super(merk, watt);}

    @Override
    public void cekFungsi(){
        System.out.println(merk + " bisa digunakan!");
    }

    @Override
    public void prosesPerintah(String perintah){
        if(perintah.equalsIgnoreCase("NYALA")){
            System.out.println("Lampu Berpijar!");
        } else {
            System.out.println("Lampu tidak ada!");}
    } 
} //akhir
