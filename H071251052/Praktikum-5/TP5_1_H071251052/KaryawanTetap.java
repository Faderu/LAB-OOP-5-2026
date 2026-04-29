class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = gajiPokok + (tunjanganMakan * getJumlahKehadiran());
        return totalGaji;
    }

    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}