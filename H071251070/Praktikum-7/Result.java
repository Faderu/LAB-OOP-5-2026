public class Result{
    String fileName;
    String threadName;
    long durasi;
    int wordCount;

    public Result(String fileName, String threadName, long durasi, int wordCount){
        this.fileName = fileName;
        this.threadName = threadName;
        this.durasi = durasi;
        this.wordCount = wordCount;
    }
}