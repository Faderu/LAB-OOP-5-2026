class ProcessResult {
  private String documentName;
  private String threadName;
  private int wordCount;
  private long duration;

  public ProcessResult (String documentName, String threadName, int wordCount, long duration) {
    this.documentName = documentName;
    this.threadName = threadName;
    this.wordCount = wordCount;
    this.duration = duration;
  }

  public String getDocumentName() {
    return documentName;
  }

  public String getThreadName() {
    return threadName;
  }

  public int getWordCount() {
    return wordCount;
  }

  public long getDuration() {
    return duration;
  }
}
