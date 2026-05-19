import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private List<String> logs;

    public LibraryLogger() {
        logs = new ArrayList<>();
    }

    public String logActivity(String activity) {
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String log = LocalDateTime.now().format(format)
                + " - " + activity;

        logs.add(log);
        return log;
    }

    public String getLogs() {
        StringBuilder hasil = new StringBuilder();

        for (String log : logs) {
            hasil.append(log).append("\n");
        }

        return hasil.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}