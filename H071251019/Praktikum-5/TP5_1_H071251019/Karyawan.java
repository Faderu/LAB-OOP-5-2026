package TP5_1_H071251019;

abstract class Karyawan {
    private String nama;
    private String IdKaryawan;
    private int jumlahKehadiran = 0;
    
    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.IdKaryawan = idKaryawan;
    }

    public void absen(){
        this.jumlahKehadiran++;
    }

    public abstract double hitungGaji();

    public String getNama(){
        return nama;
    }

    public String getIdKaryawan(){
        return IdKaryawan;
    }

    public int getjumlahKehadiran(){
        return jumlahKehadiran;
    }

} //akhir
