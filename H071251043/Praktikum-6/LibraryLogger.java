import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {
  List<String> logs = new ArrayList<>();

  String logActivity(String message) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String timestamp = now.format(format);
    String log = timestamp + " " + message;

    logs.add(log);
    return log;
  }

  String getLogs() {
    if (logs.isEmpty()) {
      return "Tidak ada log aktivitas";
    }
    StringBuilder result = new StringBuilder();

    for (String log : logs) {
      result.append(log).append("\n");
    }
    return result.toString();
  }

  void clearLogs() {
    logs.clear();
  }
}