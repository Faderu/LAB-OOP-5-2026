package TP5_1_H071251019;

public class KaryawanTetap extends Karyawan{
    double gajiPokok;
    double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji(){
       return gajiPokok + (tunjanganMakan * getjumlahKehadiran());
    }

    public double hitungGaji(double bonusKinerja){
        return hitungGaji() + bonusKinerja;

    }
}
