import java.util.*;
public class Library {
    // =========================
    // STRIBUT Library
    // =========================
    List<LibraryItem> barang = new ArrayList<>();
    List<Member> Member = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    // =========================
    // METHOD addItem
    // =========================
    String addItem(LibraryItem item){
        if (item.judul.length() > 30){
            throw new IllegalArgumentException("Judul yang dipilih terlalu panjang.❌");
        } if (String.valueOf(item.ID).length() > 4){
            throw new IllegalArgumentException("Digit ID melebihi batas.❌");
        }
        barang.add(item);
        return "Item: [" + item.judul + "]\nberhasil di tambahkan.✅";
    }

    // ===========================================
    // METHOD TAMBAHAN Fungsi: Tambah Member 
    // ===========================================
    void addMember(Member member){
        if (member.nama.length() > 30){
            throw new IllegalArgumentException("Input nama terlalu panjang.❌");
        } if (String.valueOf(member.memberID).length() > 4){
            throw new IllegalArgumentException("Digit ID melebihi batas.❌");
        }
        Member.add(member);
        System.out.println("member: [" + member.nama + "]\nberhasil ditambahkan.✅");
    }

    // ============================================
    // METHOD TAMBAHAN Fungsi: Cari Nama Member 
    // ============================================
    public Member findMemberByName(String name) {
        for (Member m : Member) {
            if (m.nama.equalsIgnoreCase(name)) {
                return m;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan.❌");
    }

    // =========================
    // METHOD findItemById
    // =========================
    public LibraryItem findItemById(int id) {
        for (LibraryItem item : barang) {
            if (item.ID == id) {
                return item;
            }
        }
        throw new NoSuchElementException("Item tidak ditemukan.❌");
    }

    // ============================================
    // METHOD TAMBAHAN Fungsi: Peminjaman Barang 
    // ============================================
    public void borrowItem(String memberName, int itemId, int days) {
        Member member = findMemberByName(memberName);
        LibraryItem item = findItemById(itemId);

        String result = member.meminjam(item, days);
        System.out.println(result);
        // catat ke log
        logger.logPinjamItem(item.judul, member.nama);
    }

    // ============================================
    // METHOD TAMBAHAN Fungsi: Pengembalian Barang 
    // ============================================
    public void returnItem(String memberName, int itemId, int daysLate) {
        Member member = findMemberByName(memberName);
        LibraryItem item = findItemById(itemId);

        if (item.pinjaman == false){
            throw new IllegalArgumentException("item tidak ada atau sudah di kembalikan.❌");
        }
        String result = member.mengembalikan(item, daysLate);
        System.out.println(result);
        // catat ke log
        logger.logKembalikanItem(item.judul, member.nama);
    }

    // =========================
    // METHOD getLibraryStatus
    // =========================
    void getLibraryStatus(){
        System.out.println("╔══════╗════════════════════════════════╗══════════╗");
        System.out.println("║ ID   ║             JUDUL              ║ STATUS   ║");
        System.out.println("╠══════╣════════════════════════════════╣══════════╣");
        for (LibraryItem item : barang){
            String status = "-";
            if (item.pinjaman){status = "dipinjam";} else {status = "tersedia";}
            System.out.printf("║ %-4d ║ %-30s ║ %-8s ║\n", item.ID, item.judul, status);
        }
        System.out.println("╚══════╝════════════════════════════════╝══════════╝");
    }

    // =========================
    // METHOD getAllLogs
    // =========================
    public void getAllLogs(){logger.getLogs();}
}
