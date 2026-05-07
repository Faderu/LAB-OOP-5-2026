public abstract class LibraryItem {
    String title;
    int itemId;
    boolean isBorrowed;

    public LibraryItem(String title, int itemId){
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public String getTitle(){
        return title;
    }

    public int getItemId(){
        return itemId;
    }

    public boolean isBorrowed(){
        return isBorrowed;
    }

    public abstract String getDescription();

    public abstract void borrowItem(int days);

    public abstract double calculateFine(int daysLate);

    public String returnItem(){
       isBorrowed = false;
       return title + " dikembalikan";
    }
}


    