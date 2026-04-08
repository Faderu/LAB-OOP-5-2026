public class User {
    
    String nama;
    int umur;
    Playlist playlist;

    public User(){}
    
    public User(String nama){
        this.nama = nama;
    }

    public User(String nama, int umur){
        this.nama = nama;
        this.umur = umur;
    }

    public User(String nama, int umur, Playlist playlist){
        this.nama = nama;
        this.umur = umur;
        this.playlist = playlist;
    }

    public void tampilkan(){
        System.out.println("\nNama: " + nama );    
            playlist.infoPlaylist();
    }

    public void aduPlaylist(User userLain){
        System.out.println("\n" + this.nama + " adu playlist dengan " + userLain.nama);

        if (this.playlist.getjumlahLagu() >  userLain.playlist.getjumlahLagu()){
            System.out.println(this.nama + " punya playlist lebih gacor!");
        }else if (this.playlist.getjumlahLagu() < userLain.playlist.getjumlahLagu()){
            System.out.println(userLain.nama + " punya playlist lebih gacor!");
        }else{
            System.out.println("Playlist keduanya gacor!");
        }
    }

    public void cekKategoriUmur(){
        if (umur < 18){
            System.out.println(nama + " masih remaja, masih tahap pencarian jati diri");
        } else {
            System.out.println("\n"+ nama + " sudah dewasa, jalani hidup dengan playlist sebagai psikolog ");
        }
    }
}