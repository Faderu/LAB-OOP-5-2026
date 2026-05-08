class DVD extends LibraryItem {
  int duration;
  public DVD(String title, int itemId, int duration) {
    super(title, itemId);
    this.duration = duration;
  }

  String getDescription() {
    return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
  }

  String borrowItem(int days) {
    if (days > 7) {
      throw new IllegalArgumentException("DVD hanya bisa dipinjam maksimal 7 hari");
    }
    if (isBorrowed) {
      throw new IllegalArgumentException("DVD sedang dipinjam");
    }

    isBorrowed = true;

    return "Item " + title + " berhasil dipinjam selama " + days + " hari";
  }

  double calculateFine(int daysLate) {
    return daysLate * 25000;
  }
}