package TP5_1_H071251019;

public class KaryawanKontrak extends Karyawan{
    double upahperHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahperHari) {
        super(nama, idKaryawan);
        this.upahperHari = upahperHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahperHari * getjumlahKehadiran();
        if (getjumlahKehadiran() > 20){
            totalGaji += 500000;
        } return totalGaji; 
    }

} //akhir
