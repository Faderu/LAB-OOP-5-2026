import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class LibraryLogger {
    // =========================
    // CLASS Format logs List
    // =========================
    static class logData{
        String judul;
        String NamaMember;
        String waktuPinjamItem;
        String waktuKembalikanItem;

        logData(String judul, String NamaMember, String pinjamItem){
            this.judul = judul;
            this.NamaMember = NamaMember;
            this.waktuPinjamItem = pinjamItem;
            this.waktuKembalikanItem = "-";
        }
    }

    // =========================
    // ATRIBUT LibraryLogger
    // =========================
        // =============
        // ATRIBUT logs
        // =============
    List<logData> catatanAktivitas;
    DateTimeFormatter formatWaktu;

    // =========================
    // METHOD logActivity
    // =========================
    public LibraryLogger() {
        catatanAktivitas = new ArrayList<>();
        formatWaktu = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    // =====================================
    // METHOD TAMBAHAN Fungsi: Peminjaman 
    // =====================================
    void logPinjamItem(String judul, String NamaMember){
        String waktuPinjam = LocalDateTime.now().format(formatWaktu);
        catatanAktivitas.add(new logData(judul, NamaMember, waktuPinjam));
    }

    // =====================================
    // METHOD TAMBAHAN Fungsi: Pengembalian 
    // =====================================   
    void logKembalikanItem(String judul, String NamaMember){
        String waktuKembali = LocalDateTime.now().format(formatWaktu);
        for (logData log : catatanAktivitas){
            if (log.judul.equals(judul) && log.NamaMember.equals(NamaMember)&& log.waktuKembalikanItem.equals("-")){
                log.waktuKembalikanItem = waktuKembali;
                break;
            }
        }
    }

    // =========================
    // METHOD getLogs
    // =========================
    public void getLogs(){
        if (catatanAktivitas.isEmpty()){
            System.out.println("belum ada aktivitas.❌");
            return;
        }
        System.out.println("\n╔═════════════════════╔════════════════════════════════╔════════════════════════════════╔═════════════════════╗");
          System.out.println("║ Dipinjam pada       ║ Judul                          ║ Member                         ║ Dikembalikan pada   ║");
          System.out.println("╠═════════════════════╠════════════════════════════════╠════════════════════════════════╠═════════════════════╣");

        for (logData log : catatanAktivitas) {
            System.out.printf("║ %-19s ║ %-30s ║ %-30s ║ %-19s ║\n",log.waktuPinjamItem,log.judul,log.NamaMember,log.waktuKembalikanItem);
        }
          System.out.println("╚═════════════════════╚════════════════════════════════╚════════════════════════════════╚═════════════════════╝");
    }

    // =========================
    // METHOD clearLogs
    // =========================
    public void clearLogs() {
        catatanAktivitas.clear();
        System.out.println("Log berhasil dikosongkan.✅");
    }

    
}
