package TP5_2_H071251019;
abstract class PerangkatElektronik {
    String merk;
    double watt;
    
    public PerangkatElektronik(String merk, double watt) {
        this.merk = merk;
        this.watt = watt;}

    public void infoPower(){
    System.out.println("Perangkat " + merk + " sedang menyedot daya listrik sebanyak " + watt + " watt");}

    abstract void cekFungsi();
    
} //akhir
