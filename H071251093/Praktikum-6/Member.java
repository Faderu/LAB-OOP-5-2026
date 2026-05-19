import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia");
        }

        borrowedItems.add(item);
        return item.borrowItem(days);
    }

    public String returnItem(LibraryItem item, int daysLate) {
        if (!item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia");
        }
        item.returnItem();
        borrowedItems.remove(item);

        double fine = item.calculateFine(daysLate);

        return "Item " + item.getTitle() +
                " berhasil dikembalikan dengan denda: Rp " + fine;
    }

    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
        } else {
            System.out.println("Daftar Item Dipinjam:");
            for (LibraryItem item : borrowedItems) {
                System.out.println(item.getDescription());
            }
        }
    }
}