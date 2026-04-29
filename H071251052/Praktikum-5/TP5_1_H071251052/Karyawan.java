abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        jumlahKehadiran++;
        System.out.println(nama + " hadir. Total kehadiran: " + jumlahKehadiran);
    }

    public abstract double hitungGaji();

    public String getNama() { return nama; }
    public String getIdKaryawan() { return idKaryawan; }
    public int getJumlahKehadiran() { return jumlahKehadiran; }
}