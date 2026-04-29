
public class KaryawanKontrak extends Karyawan {
    private double upahPerHari;
    private static final double bonus = 500_000;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();
        if (getJumlahKehadiran() > 20) {
            totalGaji += bonus;
            System.out.println("\n[Bonus tambahan Rp500.000 diberikan karena kehadiran > 20 hari]");
        }
        return totalGaji;
    }
}