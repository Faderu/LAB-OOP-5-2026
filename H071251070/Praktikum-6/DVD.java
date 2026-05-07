public class DVD extends LibraryItem{
    int duration;

    public DVD(String title, int itemId, int duration){
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + " durasi " + duration + " menit, ID:" + itemId;
    }

    @Override
    public void borrowItem(int days) {
        if (isBorrowed == true){
            throw new IllegalStateException(title + " sudah dipinjam dan belum dikembalikan");
        }

        if(days > 7){
            throw new IllegalArgumentException("Masa pinjam maksimal 7 hari untuk DVD");
        }

        isBorrowed = true;
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000; 
    }
}