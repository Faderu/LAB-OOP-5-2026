import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library() {
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }

        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public String getLibraryStatus() {
        StringBuilder hasil = new StringBuilder();

        for (LibraryItem item : items) {
            hasil.append(item.getDescription())
                    .append(" - ")
                    .append(item.isBorrowed() ? "Dipinjam" : "Tersedia")
                    .append("\n");
        }

        return hasil.toString();
    }

        public String getAllLogs() {
        return logger.getLogs();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}