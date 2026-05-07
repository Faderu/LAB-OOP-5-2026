import java.util.ArrayList;

public class Member {
    String name;
    int memberId;
    ArrayList <LibraryItem> borrowedItems;


    public Member(String name, int memberId, ArrayList<LibraryItem> borrowedItems) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = borrowedItems;
    }

    public String borrow(LibraryItem item, int days){
        if (item.isBorrowed){
           throw new IllegalStateException("Item sedang dipinjam");
        }

        String pesan = item.borrowItem(days);
        borrowedItems.add(item);
        return pesan;
    }

    public String returnItem(LibraryItem item, int daysLate){
        item.returnItem();
        borrowedItems.remove(item);

        double denda = item.calculateFine(daysLate);

        return  "Item " + item.title + " berhasil dikembalikan dengan denda Rp" + denda;
    }


    void getBorrowedItems(){
        if (borrowedItems.isEmpty()){
            System.out.println("Tidak Item yang sedang dipinjam.");
            return;
        }

        System.out.println("+==============================+");
        System.out.printf("| %-3s | %-20s |\n", "ID", "Judul");
        System.out.println("+==============================+");

        for (LibraryItem item : borrowedItems){
            System.out.printf("| %-3d | %-20s |\n", item.itemID, item.title);
        }
        System.out.println("+==============================+");

    }

} // alhir
