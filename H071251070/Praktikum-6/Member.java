import java.util.ArrayList;
import java.util.List;

class Member{
    String name;
    String memberId;
    List<LibraryItem> borrowedItems;

    public Member(String name, String memberId){
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return memberId;
    }

    public String borrow(LibraryItem item, int days){
        if (item.isBorrowed()){
            throw new IllegalStateException(item.getTitle() + " sudah dipinjam dan belum dikembalikan");
        }
        item.borrowItem(days);
        borrowedItems.add(item);
        return "item" + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
        
    }

    public String returnItem(LibraryItem item, int daysLate){
        if (!borrowedItems.contains(item)){
            throw new IllegalArgumentException("Item " + item.getTitle() + " tidak ditemukan dalam daftar pinjaman anggota");
        }

        item.returnItem();

        double denda = item.calculateFine(daysLate);
        borrowedItems.remove(item);
        
        return "item" + item.getTitle() + " berhasil dikembalikan dengan Denda : Rp" + denda;
    }

    public String getBorrowedItems(){
        if(borrowedItems.isEmpty()){
          throw new IllegalStateException("Tidak ada item yang dipinjam");
        }

        StringBuilder sb = new StringBuilder();

        String garis = "+--------+--------------------------------+\n";
        String format = "| %-6s | %-30s |\n";

        sb.append(garis);
        sb.append(String.format(format, "ID", "Judul"));
        sb.append(garis);

        for (LibraryItem item : borrowedItems){
            sb.append(String.format(format, item.getItemId(), item.getTitle()));

        }

        sb.append(garis);

        return sb.toString();
    }
}
