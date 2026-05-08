import java.util.ArrayList;
import java.util.List;

class Member {
  String name;
  String memberId;
  List<LibraryItem> borrowedItems = new ArrayList<>();
  public Member(String name, String memberId) {
    this.name = name;
    this.memberId = memberId;
  }

  String borrow(LibraryItem item, int days) {
    if (item.isBorrowed) {
      throw new IllegalStateException("Item sedang dipinjam");
    }

    borrowedItems.add(item);

    return item.borrowItem(days);
  }

  String returnItem(LibraryItem item, int daysLate) {
    borrowedItems.remove(item);

    double denda = item.calculateFine(daysLate);
    return item.returnItem() + 
    "\nDenda: Rp " + denda;
  }

  void getBorrowedItems() {
    if (borrowedItems.isEmpty()) {
      System.out.println("Tidak ada item yang dipinjam");
    }
    else {
      System.out.println("===== DAFTAR ITEM DIPINJAM =====");

      for (LibraryItem item : borrowedItems) {
        System.out.println(item.itemId + " | " + item.title);
      }

    }
  }
}