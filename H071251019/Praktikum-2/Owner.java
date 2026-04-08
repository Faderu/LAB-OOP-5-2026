public class Owner {
    String namaOwner;
    int stokWhiskas;

    public Owner(){ //default
        this.namaOwner = "-";
        this.stokWhiskas = 0;
    }
    
    public Owner(String namaOwner, int stokWhiskas){ //parameter
        this.namaOwner = namaOwner;
        this.stokWhiskas = stokWhiskas;
    }

    public String getnamaOwner(){
        return namaOwner;
    }

    public int getjumlahstokWhiskas(){
        return stokWhiskas; 
    }

    public void setstokWhiskas(int jumlah){
        this.stokWhiskas = jumlah;
    }

    public void cekInfoOwner(){ 
        System.out.print("Pemilik: " + namaOwner);
        System.out.println(" | Stok Whiskas: " + stokWhiskas);
    }
}
