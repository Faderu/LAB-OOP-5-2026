package TP5_2_H071251019;

public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara{
    public SmartSpeaker(String merk, double watt) {
        super(merk, watt);
    }
    
    @Override
    public void cekFungsi(){
        System.out.println(merk + " bisa digunakan!");
    }
    
    @Override
    public void hubungkanWifi(){
        System.out.println("Speaker terhubung ke WIFI");
    }

    @Override
    public void prosesPerintah(String perintah){
        if(perintah.equalsIgnoreCase("NYALA")){
            System.out.println("Speaker aktif, silahkan putar sesuatu.");
        } else {
            System.out.println("Speaker tidak ada");}
    } 
}
