public class Main {
    public static void main(String[] args) {
        String[] laguA = {"Membasuh", "Everything u are", "Arteri", "Satu hari lagi"};
        String[] laguB = {"XXL", "About you", "Backburner"};

        Playlist p1 = new Playlist("BasHolic", laguA);
        Playlist p2 = new Playlist("Sekencois", laguB);

        User userA = new User ("Ayu", 20, p1);
        User userB = new User ("Kay", 17, p2);

        userA.tampilkan();
        userB.tampilkan();

        userA.aduPlaylist(userB);
        userA.cekKategoriUmur();
        userB.cekKategoriUmur();
    }
}
