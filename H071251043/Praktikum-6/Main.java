import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Library library = new Library();

        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();
            input.nextLine();

            try {

                switch (pilihan) {

                    case 1:
                        System.out.print("Judul item: ");
                        String title = input.nextLine();

                        System.out.print("ID item: ");
                        int itemId = input.nextInt();
                        input.nextLine();

                        System.out.print("Jenis (1 = Book, 2 = DVD): ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Penulis: ");
                            String author = input.nextLine();

                            Book book = new Book(title, itemId, author);
                            System.out.println(library.addItem(book));

                        } else if (jenis == 2) {
                            System.out.print("Durasi (menit): ");
                            int duration = input.nextInt();

                            DVD dvd = new DVD(title, itemId, duration);
                            System.out.println(library.addItem(dvd));

                        } else {
                            System.out.println("Jenis tidak valid.");
                        }
                        break;

                    case 2:
                        System.out.print("Nama anggota: ");
                        String name = input.nextLine();

                        System.out.print("ID anggota: ");
                        String memberId = input.nextLine();

                        Member member = new Member(name, memberId);
                        library.members.add(member);

                        System.out.println("Anggota berhasil ditambahkan");
                        break;

                    case 3:
                        System.out.print("ID anggota: ");
                        String idPinjam = input.nextLine();

                        Member peminjam = null;
                        for (Member m : library.members) {
                            if (m.memberId.equals(idPinjam)) {
                                peminjam = m;
                                break;
                            }
                        }

                        if (peminjam == null) {
                            System.out.println("Anggota tidak ditemukan");
                            break;
                        }

                        System.out.print("ID item: ");
                        int idItemPinjam = input.nextInt();

                        System.out.print("Lama pinjam (hari): ");
                        int hari = input.nextInt();

                        LibraryItem itemPinjam = library.findItemById(idItemPinjam);

                        System.out.println(peminjam.borrow(itemPinjam, hari));
                        library.logger.logActivity(peminjam.name + " meminjam " + itemPinjam.title);

                        break;

                    case 4:
                        System.out.print("ID anggota: ");
                        String idKembali = input.nextLine();

                        Member pengembali = null;
                        for (Member m : library.members) {
                            if (m.memberId.equals(idKembali)) {
                                pengembali = m;
                                break;
                            }
                        }

                        if (pengembali == null) {
                            System.out.println("Anggota tidak ditemukan");
                            break;
                        }

                        System.out.print("ID item: ");
                        int idItemKembali = input.nextInt();

                        System.out.print("Terlambat (hari): ");
                        int terlambat = input.nextInt();

                        LibraryItem itemKembali = library.findItemById(idItemKembali);

                        System.out.println(pengembali.returnItem(itemKembali, terlambat));
                        library.logger.logActivity(pengembali.name + " mengembalikan " + itemKembali.title);

                        break;

                    case 5:
                        System.out.println("\n=== Status Perpustakaan ===");
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println("\n=== Log Aktivitas ===");
                        System.out.println(library.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID anggota: ");
                        String idCek = input.nextLine();

                        Member cek = null;
                        for (Member m : library.members) {
                            if (m.memberId.equals(idCek)) {
                                cek = m;
                                break;
                            }
                        }

                        if (cek == null) {
                            System.out.println("Anggota tidak ditemukan");
                        } else {
                            cek.getBorrowedItems();
                        }
                        break;

                    case 8:
                        System.out.println("Program selesai.");
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                input.nextLine();
            }

        } while (pilihan != 8);

        input.close();
    }
}