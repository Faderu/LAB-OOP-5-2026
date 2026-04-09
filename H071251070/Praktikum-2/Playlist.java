public class Playlist {
    
    String namaPlaylist;
    String[] lagu;

    public Playlist(){}

    public Playlist(String namaPlaylist){
        this.namaPlaylist = namaPlaylist;
    }

    public Playlist(String namaPlaylist, String[] lagu){
        this.namaPlaylist = namaPlaylist;
        this.lagu = lagu;
    }

    public void infoPlaylist(){
        System.out.println("Playlist: " + namaPlaylist);
        System.out.println("Daftar Lagu: ");

        for(int i = 0; i < lagu.length; i++){
            System.out.println((i+1) + ". " + lagu[i]);

        }
    }

    public int getjumlahLagu(){
        return lagu.length;
    }
    
}
