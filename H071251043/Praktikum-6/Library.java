import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {
  List<LibraryItem> items = new ArrayList<>();
  List<Member> members = new ArrayList<>();
  LibraryLogger logger = new LibraryLogger();

  String addItem(LibraryItem item) {
    items.add(item);
    logger.logActivity(item.title + " ditambahkan ke library");
    return item.title + " berhasil ditambahkan";
  }

  LibraryItem findItemById(int itemId) {
    for (LibraryItem item : items) {
      if (item.itemId == itemId) {
        return item;
      }
    }
    throw new NoSuchElementException("Item tidak ditemukan");
  }

  String getLibraryStatus() {
    StringBuilder result = new StringBuilder();

    for (LibraryItem item : items) {
      String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
      result.append(item.itemId)
            .append(" | ")
            .append(item.title)
            .append(" | ")
            .append(status)
            .append("\n");
    }
    return result.toString();
  }

  String getAllLogs() {
    return logger.getLogs();
  }
}