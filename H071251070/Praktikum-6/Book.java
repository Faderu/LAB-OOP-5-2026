public class Book extends LibraryItem{
    String author;

    public Book(String title, int itemId, String author){
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID:" + itemId;
    }

    @Override
    public void borrowItem(int days) {
        if (isBorrowed()){
            throw new IllegalStateException(title + " sudah dipinjam dan belum dikembalikan");
        }

        if(days > 14){
            throw new IllegalArgumentException("Masa pinjam maksimal 14 hari");
        }

        isBorrowed = true;
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000; 
    }
}