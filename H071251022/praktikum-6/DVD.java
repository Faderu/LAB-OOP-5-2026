public class DVD extends LibraryItem{
    // =========================
    // ATRIBUT TAMBAHAN DVD
    // =========================
    int durasi;

    // =========================
    // CONSTRUCTOR Childclass
    // =========================
    public DVD(String judul, int ID, int durasi) {
        super(judul, ID);
        this.durasi = durasi;
    }

    // ============================
    // OVERRIDE METHOD LibraryItem
    // ============================
    @Override
    // =========================
    // METHOD getDescription
    // =========================
    String getDescription(){
        // ==========
        // Deskripsi
        // ==========
        return "DVD : " + judul + " durasi : " + durasi + " menit, ID : " + ID;
    }
    @Override
    // =========================
    // Aturan Peminjaman
    // =========================
    String pinjamBarang(int Days){
        if (Days > 7){
            throw new IllegalArgumentException("Maksimal peminjaman 7 hari.❌");
        } if (pinjaman) {
            throw new IllegalArgumentException("item telah dipinjam dan belum dikembalikan.❌");
        }
        super.BarangDipinjam();
        return getDescription() + " dipinjam.✅";
    }
    @Override
    // =========================
    // Denda Peminjaman
    // =========================
    double tenggatWaktu(int DaysLate){
        double denda = DaysLate*25000;
        return denda;
    }

}

