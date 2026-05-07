class DVD extends LibraryItem{
    int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + " durasi " + duration + " menit, ID: " + itemID;
    }

    @Override
    public String borrowItem(int days) {
        if (days > 7){
            throw new IllegalArgumentException("Maksimal peminjaman 7 hari");}
            
        if (isBorrowed){
            throw new IllegalArgumentException("Item sedang dipinjam dan belum dikembalikan");}

        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
       return daysLate * 25000;
    }
    
   
}
