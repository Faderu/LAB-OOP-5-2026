package TP5_2_H071251019;

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet{
    public SmartCCTV(String merk, double watt) {
        super(merk, watt);
    }
    
    @Override
    public void cekFungsi(){
        System.out.println(merk + " bisa digunakan!");
    }

    @Override
    public void hubungkanWifi(){
        System.out.println("Mengirim data ke server. . .");
    }
} //akhir

