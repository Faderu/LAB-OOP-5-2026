public class Book extends LibraryItem{
    // =========================
    // ATRIBUT TAMBAHAN Book
    // =========================
    String author;

    // =========================
    // CONSTRUCTOR Childclass
    // =========================
    public Book(String judul, int ID, String author) {
        super(judul, ID);
        this.author = author;
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
        return "Buku : " + judul + " oleh author : " + author + ", ID : " + ID;
    }
    @Override
    // =========================
    // Aturan Peminjaman
    // =========================
    String pinjamBarang(int Days){
        if (Days > 14){
            throw new IllegalArgumentException("Maksimal peminjaman 14 hari.❌");
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
        double denda = DaysLate*10000;
        return denda;
    }

}
