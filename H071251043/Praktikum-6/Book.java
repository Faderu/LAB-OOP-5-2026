class Book extends LibraryItem {
  String author;
  public Book(String title, int itemId, String author) {
    super(title, itemId);
    this.author = author;
  }

  String getDescription() {
    return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
  }

  String borrowItem(int days) {
    if (days > 14) {
      throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal 14 hari");
    }
    if (isBorrowed) {
      throw new IllegalArgumentException("Buku sedang dipinjam");
    }

    isBorrowed = true;

    return "Item " + title + " berhasil dipinjam selama " + days + " hari";
  }

  double calculateFine(int daysLate) {
    return daysLate * 10000;
  }

  void printBooks() {
    System.out.println(getDescription());
  }
}