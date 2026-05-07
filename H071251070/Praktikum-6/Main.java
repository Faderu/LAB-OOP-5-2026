import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih: ");

            int pilih = sc.nextInt();
            sc.nextLine();

            try {
                switch (pilih) {

                    case 1:
                        System.out.println("1. Buku");
                        System.out.println("2. DVD");
                        System.out.print("Pilih: ");
                        int jenis = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Judul: ");
                        String title = sc.nextLine();
                        System.out.print("ID: ");
                        int id = sc.nextInt();

                        if (jenis == 1) {
                            sc.nextLine();
                            System.out.print("Author: ");
                            String author = sc.nextLine();
                            System.out.println(lib.addItem(new Book(title, id, author)));
                        } else {
                            System.out.print("Durasi: ");
                            int durasi = sc.nextInt();
                            System.out.println(lib.addItem(new DVD(title, id, durasi)));
                        }
                        break;

                    case 2:
                        System.out.print("Nama: ");
                        String nama = sc.nextLine();
                        System.out.print("ID Member: ");
                        String memberId = sc.nextLine();

                        lib.addMember(new Member(nama, memberId));
                        System.out.println("Anggota berhasil ditambahkan");
                        break;

                    case 3:
                        System.out.print("ID Member: ");
                        String memberID = sc.nextLine();
                        Member member = lib.findMemberById(memberID);

                        System.out.print("ID Item: ");
                        int itemId = sc.nextInt();
                        System.out.print("Hari: ");
                        int days = sc.nextInt();

                        LibraryItem item = lib.findItemById(itemId);
                        String res = member.borrow(item, days);

                        lib.getLogger().logActivity(item.getTitle(), member.getName(), "-");
                        System.out.println(res);
                        break;

                    case 4:
                        System.out.print("ID Member: ");
                        String mId2 = sc.nextLine();
                        Member member2 = lib.findMemberById(mId2);

                        System.out.print("ID Item: ");
                        int itemId2 = sc.nextInt();
                        System.out.print("Terlambat: ");
                        int late = sc.nextInt();

                        LibraryItem item2 = lib.findItemById(itemId2);
                        String res2 = member2.returnItem(item2, late);

                        lib.getLogger().logActivity(item2.getTitle(), member2.getName(), "Sudah Dikembalikan");
                        System.out.println(res2);
                        break;

                    case 5:
                        System.out.println(lib.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(lib.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID Member: ");
                        String mId3 = sc.nextLine();
                        Member member3 = lib.findMemberById(mId3);
                        System.out.println(member3.getBorrowedItems());
                        break;

                    case 8:
                        System.out.println("Keluar...");
                        return;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}