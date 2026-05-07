import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Library library = new Library();
    public static void main(String[] args) {

         while (true) {
            try {
                dekorasi();
                System.out.print("Pilih menu (1-7), ketik 8 untuk berhenti: ");
                int pilih = sc.nextInt();
                sc.nextLine();
                switch (pilih) {

                    // =========================
                    // TAMBAH ITEM
                    // =========================
                    case 1:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║      TAMBAH ITEM       ║");
                        System.out.println("╚════════════════════════╝");
                        tambahItem();
                        break;

                    // =========================
                    // TAMBAH MEMBER
                    // =========================
                    case 2:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║     TAMBAH MEMBER      ║");
                        System.out.println("╚════════════════════════╝");
                        tambahMember();
                        break;

                    // =========================
                    // PINJAM
                    // =========================
                    case 3:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║         PINJAM         ║");
                        System.out.println("╚════════════════════════╝");
                        pinjamItem();
                        break;

                    // =========================
                    // RETURN
                    // =========================
                    case 4:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║       KEMBALIKAN       ║");
                        System.out.println("╚════════════════════════╝");
                        kembalikanItem();
                        break;

                    // =========================
                    // STATUS
                    // =========================
                    case 5:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║         STATUS         ║");
                        System.out.println("╚════════════════════════╝");
                        library.getLibraryStatus();
                        break;

                    // =========================
                    // LOG
                    // =========================
                    case 6:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║          LOG           ║");
                        System.out.println("╚════════════════════════╝");
                        library.getAllLogs();
                        break;

                    // =========================
                    // LIHAT PINJAMAN MEMBER
                    // =========================
                    case 7:
                        System.out.println("╔════════════════════════╗");
                        System.out.println("║ LIHAT PINJAMAN MEMBER  ║");
                        System.out.println("╚════════════════════════╝");
                        lihatPinjamanMember();
                        break;

                    case 8:
                        System.out.println("Keluar...");
                        return;

                    default:
                        System.out.println("Menu ke-" + pilih + "tidak tersedia.❌");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
    // =========================
    // METHOD TAMBAH ITEM
    // =========================
    static void tambahItem() {
        System.out.println("╔═══════════╗");
        System.out.println("║ 1.BUKU    ║");
        System.out.println("║ 2.DVD     ║");
        System.out.println("╚═══════════╝");
        System.out.print("Pilih         : ");
        int jenis = sc.nextInt();
        sc.nextLine();

        System.out.print("Judul         : ");
        String title = sc.nextLine();

        System.out.print("ID            : ");
        int id = sc.nextInt();
        sc.nextLine();

        if (jenis == 1) {
            System.out.print("Author        : ");
            String author = sc.nextLine();
            System.out.println(library.addItem(new Book(title, id, author)));

        } else if (jenis == 2) {
            System.out.print("Durasi (menit): ");
            int durasi = sc.nextInt();
            System.out.println(library.addItem(new DVD(title, id, durasi)));

        } else {
            System.out.println("Jenis tidak valid.❌");
        }
    }

    // =========================
    // METHOD TAMBAH MEMBER
    // =========================
    static void tambahMember() {
        System.out.print("Nama Member: ");
        String nama = sc.nextLine();

        System.out.print("ID Member  : ");
        int id = sc.nextInt();
        sc.nextLine();

        library.addMember(new Member(nama, id));
    }

    // =========================
    // METHOD PINJAM
    // =========================
    static void pinjamItem() {
        System.out.print("Nama Member : ");
        String nama = sc.nextLine();

        System.out.print("ID Item     : ");
        int id = sc.nextInt();

        System.out.print("Jumlah hari : ");
        int hari = sc.nextInt();
        sc.nextLine();

        library.borrowItem(nama, id, hari);
    }

    // =========================
    // METHOD RETURN
    // =========================
    static void kembalikanItem() {
        System.out.print("Nama Member      : ");
        String nama = sc.nextLine();

        System.out.print("ID Item          : ");
        int id = sc.nextInt();

        System.out.print("Terlambat (hari) : ");
        int telat = sc.nextInt();
        sc.nextLine();

        library.returnItem(nama, id, telat);
    }

    // =========================
    // LIHAT PINJAMAN MEMBER
    // =========================
    static void lihatPinjamanMember() {
        System.out.print("Nama Member : ");
        String nama = sc.nextLine();

        Member m = library.findMemberByName(nama);
        m.tabelDataPinjamanMember();
    }

    static void dekorasi(){
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║         SISTEM PERPUSTAKAAN        ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. TAMBAH ITEM                     ║");
        System.out.println("║ 2. TAMBAH MEMBER                   ║");
        System.out.println("║ 3. PINJAM BUKU                     ║");
        System.out.println("║ 4. KEMBALIKAN BUKU                 ║");
        System.out.println("║ 5. STATUS PERPUSTAKAAN             ║");
        System.out.println("║ 6. LOG AKTIVITAS                   ║");
        System.out.println("║ 7. LIHAT ITEM PINJAMAN MEMBER      ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 8. KELUAR                          ║");
        System.out.println("╚════════════════════════════════════╝");
    }
}
