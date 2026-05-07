abstract class LibraryItem {
    String title;
    int itemID;
    boolean isBorrowed;
   
    public LibraryItem(String title, int itemID) {
        this.title = title;
        this.itemID = itemID;
        this.isBorrowed = false;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem(){
        this.isBorrowed = false;
        return title + " dikembalikan";
    }    
}
