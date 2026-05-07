import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LibraryLogger{
    List<String> logs;

    public LibraryLogger(){
        logs = new ArrayList<>();
    }

    public void logActivity(String judul, String member, String waktuKembali) {
    LocalDateTime now = LocalDateTime.now();

    DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String waktuPinjam = now.format(formatter);

    String log = waktuPinjam + "|" + judul + "|" + member + "|" + waktuKembali;

    logs.add(log);
}

    public String getLogs() {
    if (logs.isEmpty()) {
        return "Belum ada aktivitas";
    }

    StringBuilder sb = new StringBuilder();

    String line = "+---------------------+----------------------+-----------+---------------------+\n";
    String format = "| %-19s | %-20s | %-9s | %-19s |\n";

    sb.append(line);
    sb.append(String.format(format, "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
    sb.append(line);

    for (String log : logs) {
        String[] parts = log.split("\\|");

        String dipinjam = parts[0];
        String judul = parts[1];
        String member = parts[2];
        String dikembalikan = parts[3];

        sb.append(String.format(format, dipinjam, judul, member, dikembalikan));
    }

    sb.append(line);

    return sb.toString();
}

    public void clearLogs(){
        logs.clear();
    }
}