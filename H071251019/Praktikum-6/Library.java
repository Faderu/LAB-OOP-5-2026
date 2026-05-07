import java.util.ArrayList;
import java.util.NoSuchElementException;
 
public class Library {
    ArrayList<LibraryItem> items;
    ArrayList<Member> members;
    LibraryLogger logger;
 
    public Library(ArrayList<LibraryItem> items, ArrayList<Member> members, LibraryLogger logger) {
        this.items = items;
        this.members = members;
        this.logger = logger;
    }
 
    public String addItem(LibraryItem item) {
        for (LibraryItem i : items) {
            if (i.itemID == item.itemID) {
                return "Gagal: ID " + item.itemID + " sudah digunakan.";
            }
            if (i.title.equalsIgnoreCase(item.title)) {
                return "Gagal: Item \"" + item.title + "\" sudah ada.";
            }
        }
        items.add(item);
        logger.logActivity("Item ditambahkan: " + item.getDescription());
        return "\"" + item.title + "\" berhasil ditambahkan ke perpustakaan.";
    }

    // method tambahan untuk no 2
    public String addMember(Member member) {
        for (Member m : members) {
            if (m.memberId == member.memberId) {
                return "Gagal: ID anggota " + member.memberId + " sudah terdaftar.";
            }
            if (m.name.equalsIgnoreCase(member.name)) {
                return "Gagal: Anggota \"" + member.name + "\" sudah terdaftar.";
            }
        }
        members.add(member);
        logger.logActivity("Anggota baru terdaftar: " + member.name + " (ID: " + member.memberId + ")");
        return "Anggota \"" + member.name + "\" berhasil didaftarkan.";
    }

     public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemID == itemId) 
                return item;
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }
 
    public Member findMemberById(int memberId) {
        for (Member org : members) {
            if (org.memberId == memberId) 
                return org;
        }
        throw new NoSuchElementException("Anggota dengan ID " + memberId + " tidak ditemukan.");
    }


    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "(Belum ada item di perpustakaan)\n";}

        StringBuilder sb = new StringBuilder(); //membuat dan mengubah string secara efisien tanpa membuat object baru terus-menerus.
        sb.append("+------+----------------------+--------------------+\n");
        sb.append(String.format("| %-4s | %-20s | %-10s |\n", "ID", "Judul", "Status"));
        sb.append("+------+----------------------+--------------------+\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            String judul  = item.title.length() > 20 ? item.title.substring(0, 17) + "..." : item.title;
            sb.append(String.format("| %-4d | %-20s | %-10s |\n",
                item.itemID, judul, status));
        }
        sb.append("+------+----------------------+--------------------+\n");
        return sb.toString(); //Mengubah jadi String biasa
    }

    public String getMembersStatus() {
        if (members.isEmpty()) {
            return "(Belum ada anggota terdaftar)\n";}
            
        StringBuilder sb = new StringBuilder();
        sb.append("+------+----------------------+\n");
        sb.append(String.format("| %-4s | %-20s |\n", "ID", "Nama"));
        sb.append("+------+----------------------+\n");
        for (Member m : members) {
            sb.append(String.format("| %-4d | %-20s |\n", m.memberId, m.name));
        }
        sb.append("+------+----------------------+\n");
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
} // akhir