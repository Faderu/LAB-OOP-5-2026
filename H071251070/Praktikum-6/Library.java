import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library{
    private List<LibraryItem> items;
    private List<Member> members;
    private LibraryLogger logger;

    public Library(){
        items = new ArrayList<>();
        members = new ArrayList<>();
        logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item){
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public LibraryItem findItemById( int itemId){
        for (LibraryItem item : items){
            if (item.getItemId() == itemId){
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    public String addMember(Member member){
        members.add(member);
        return member.getName() + " berhasil ditambahkan sebagai anggota";
    }

    public Member findMemberById(String memberId){
        for (Member m : members){
            if (m.getId().equalsIgnoreCase(memberId)){
                return m;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan");
    }

    public String borrowItem(String memberId, int itemId, int days){
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);

        String result = member.borrow(item, days);
        logger.logActivity(item.getTitle(), member.getName(), "-");
        return result;
    }

    public String returnItem(String memberId, int itemId, int daysLate){
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);

        String result = member.returnItem(item, daysLate);
        logger.logActivity(item.getTitle(), member.getName(), "Sudah Dikembalikan");
        return result;
    }

    public String getLibraryStatus() {
    if (items.isEmpty()) {
        return "Tidak ada item di perpustakaan";
    }

    StringBuilder sb = new StringBuilder();

    String line = "+--------+--------------------------------+------------+\n";
    String format = "| %-6s | %-30s | %-10s |\n";

    sb.append(line);
    sb.append(String.format(format, "ID", "Judul", "Status"));
    sb.append(line);

    for (LibraryItem item : items) {
        String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";

        sb.append(String.format(format, item.getItemId(), item.getTitle(), status
        ));
    }

    sb.append(line);

    return sb.toString();
}

    public String getAllLogs(){
        return logger.getLogs();
    }

    public void clearLogs(){
        logger.clearLogs();
    }

    public LibraryLogger getLogger(){
        return logger;
    }
}