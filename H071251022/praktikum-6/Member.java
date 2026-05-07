import java.util.*;
public class Member {
    // =========================
    // ATRIBUT member
    // =========================
    String nama;
    int memberID;
    List <LibraryItem> dataItemPinjaman;

    // =========================
    // CONSTRACTOR member
    // =========================
    Member(String nama, int memberID){
        this.nama = nama;
        this.memberID = memberID;
        dataItemPinjaman = new ArrayList<>();
    }

    // =========================
    // METHOD borrow
    // =========================
    String meminjam(LibraryItem item, int Days){
        item.pinjamBarang(Days);
        dataItemPinjaman.add(item);
        return "item : [" + item.judul + "] \nberhasil di pinjam.✅";
    }

    // =========================
    // METHOD returnItem
    // =========================
    String mengembalikan(LibraryItem item, int DaysLate){
        item.BarangKembali();
        dataItemPinjaman.remove(item);
        if(DaysLate == 0){
            return "item : [" + item.judul + "] \nberhasil di kembalikan✅";
        }
        return "item : [" + item.judul + "] \nberhasil di kembalikan✅, namun dengan denda : " + item.tenggatWaktu(DaysLate);
    }

    // =========================
    // METHOD getBorrowedItems
    // =========================
    void tabelDataPinjamanMember(){
        if (dataItemPinjaman.isEmpty()){
            throw new IllegalArgumentException("Data pinjaman kosong.❌");
        }
        System.out.println("╔══════╗════════════════════════════════╗");
        System.out.println("║ ID   ║             JUDUL              ║");
        System.out.println("╠══════╣════════════════════════════════╣");
        for (LibraryItem item : dataItemPinjaman){
            System.out.printf("║ %-4d ║ %-30s ║\n", item.ID, item.judul);
        }
        System.out.println("╚══════╝════════════════════════════════╝");
    }


}
