abstract class LibraryItem {
    // =========================
    // ATRIBUT LibraryItem
    // =========================
    protected String judul;
    protected int ID;
    protected boolean pinjaman;


    // =========================
    // CONSTRUCTOR LibraryItem
    // =========================
    public LibraryItem(String judul, int ID) {
        this.judul = judul;
        this.ID = ID;
        this.pinjaman = false;
    }

    // =========================
    // ABSTRAK METHOD 
    // =========================
    abstract String getDescription();
    abstract String pinjamBarang(int Days);
    abstract double tenggatWaktu(int DaysLate);

    // =========================
    // METHOD returnItem
    // =========================
    public String BarangKembali(){
        this.pinjaman = false;
        return judul + " dikembalikan.✅";
    }

    // =========================
    // METHOD TAMBAHAN
    // =========================
    public String BarangDipinjam(){
        this.pinjaman = true;
        return judul + "dipinjam.✅";
    }
}