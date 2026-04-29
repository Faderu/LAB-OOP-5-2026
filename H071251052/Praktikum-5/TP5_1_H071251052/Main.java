public class Main {
    public static void main(String[] args) {
        System.out.println("===== KARYAWAN TETAP =====");
        KaryawanTetap kt = new KaryawanTetap("Jaka Widada", "RI-01", 5_000_000, 25_000);

        for (int i = 0; i < 12; i++) kt.absen();

        double bonusKinerja = 1_500_000;
        System.out.println("\nGaji tanpa bonus: Rp" + (int) kt.hitungGaji());
        System.out.println("Gaji dengan bonus: Rp" + (int) kt.hitungGaji(bonusKinerja));

        System.out.println("\n===== KARYAWAN KONTRAK =====");
        KaryawanKontrak kk = new KaryawanKontrak("Prakasa Kitabuming", "RI-02", 200_000);

        for (int i = 0; i < 21; i++) kk.absen();

        System.out.println("Total gaji: Rp" + (int) kk.hitungGaji());
    }
}