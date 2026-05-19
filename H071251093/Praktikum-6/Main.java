import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Library library = new Library();

        Book b1 = new Book("Laskar Pelangi", 101, "Andrea Hirata");
        DVD d1 = new DVD("Avengers", 201, 120);

        library.addItem(b1);
        library.addItem(d1);

        Member member = new Member("Imam", 1);
        library.addMember(member);

        int pilihan;

        do {
            System.out.println("\n===== MENU PERPUSTAKAAN =====");
            System.out.println("1. Lihat Status Library");
            System.out.println("2. Pinjam Buku/DVD");
            System.out.println("3. Kembalikan Item");
            System.out.println("4. Lihat Item Dipinjam");
            System.out.println("5. Lihat Log Aktivitas");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();

            try {
                switch (pilihan) {
                    case 1:
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 2:
                        System.out.print("Masukkan ID item: ");
                        int idPinjam = input.nextInt();

                        System.out.print("Jumlah hari pinjam: ");
                        int hari = input.nextInt();

                        LibraryItem itemPinjam = library.findItemById(idPinjam);

                        String hasilPinjam = member.borrow(itemPinjam, hari);
                        System.out.println(hasilPinjam);

                        library.getLogger().logActivity(
                                itemPinjam.getTitle() +
                                " dipinjam oleh " + member.getName());
                        break;
                    
                    case 3:
                        System.out.print("Masukkan ID item: ");
                        int idKembali = input.nextInt();

                        System.out.print("Jumlah hari keterlambatan: ");
                        int telat = input.nextInt();

                        LibraryItem itemKembali = library.findItemById(idKembali);

                        String hasilKembali =
                                member.returnItem(itemKembali, telat);

                        System.out.println(hasilKembali);

                        library.getLogger().logActivity(
                                itemKembali.getTitle() +
                                " dikembalikan oleh " + member.getName());
                        break;

                    case 4:
                        member.getBorrowedItems();
                        break;

                    case 5:
                        System.out.println(library.getAllLogs());
                        break;

                    case 0:
                        System.out.println("Program selesai");
                        break;

                    default:
                        System.out.println("Menu tidak tersedia");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (pilihan != 0);
    }
}