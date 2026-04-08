class Kucing {
    String namaKucing;
    String jenisKucing;
    int levelBarbar;
    Owner manusia;
   
    public Kucing(){ //default
        this.namaKucing = "Meng";
        this.jenisKucing = "Domestik";
        this.levelBarbar = 3;
        this.manusia = new Owner();
    }

    public Kucing(String namaKucing, String jenisKucing, int levelBarbar, Owner manusia){ //ini yg parameterny diset
        this.namaKucing = namaKucing;
        this.jenisKucing = jenisKucing;
        this.levelBarbar = levelBarbar;
        this.manusia = manusia;
    }

    public void aksibarbar(String jenisAksi){ //behavior
        if (jenisAksi.equals("Merebut makanan babu")){
            levelBarbar ++;
            System.out.println(namaKucing + " merebut makanan!" + " +1 level kebar-baran" + " || level terbaru: " + levelBarbar);
        }else if (jenisAksi.equals("Jatuhkan Barang")){
            levelBarbar += 2;
            System.out.println(namaKucing + " menjatuhkan barang!" + " +2 level kebar-baran" + " || level terbaru: " + levelBarbar);
        }else if (jenisAksi.equals("Mencakar sofa")){
            levelBarbar += 3;
            System.out.println(namaKucing + " mencakar sofa!" + " +3 level kebar-baran" + " || level terbaru: " + levelBarbar);
        }else if(jenisAksi.equals("Buang air sembarangan")){
            levelBarbar += 4;
            System.out.println(namaKucing + " BUANG AIR SEMBARANGAN!" + " +4 level kebar-baran" + " || level terbaru: " + levelBarbar);
        }else {
            levelBarbar += 0;
            System.out.println(namaKucing + " terverifikasi belum melakukan apapun " + "|| level kebar-baran: " + levelBarbar);

        }
    }

    public void rebutmakanan(Kucing lawan){ //behavior
            System.out.println("===============================");
            System.out.println("Perebutan makanan");
            System.out.println(namaKucing + " dengan level " + levelBarbar + " vs " + 
            lawan.namaKucing + " dengan level " + lawan.levelBarbar);

            if (this.levelBarbar > lawan.levelBarbar){
                int rampasan = lawan.manusia.getjumlahstokWhiskas();
                lawan.manusia.setstokWhiskas(0);
                System.out.println(namaKucing + " memenangkan perebutan makanan dan mengambil sebanyak " + rampasan + " dari " + lawan.manusia.namaOwner);
                this.manusia.setstokWhiskas(this.manusia.getjumlahstokWhiskas() + rampasan);
            } else {
                int rampasan = this.manusia.getjumlahstokWhiskas();
                this.manusia.setstokWhiskas(0);
                System.out.println(lawan.namaKucing + " memenangkan perebutan makanan dan mengambil sebanyak " + rampasan + " dari " + this.manusia.namaOwner);
                lawan.manusia.setstokWhiskas(lawan.manusia.getjumlahstokWhiskas() + rampasan);
            }
            
    }

    public void infokan(){ // behavior
        System.out.println("Kucing: " + namaKucing + " || Jenis: " + jenisKucing + " || Level bar-bar: " + levelBarbar + " || Pemilik: " + manusia.namaOwner + " (Stok makanan: " + manusia.getjumlahstokWhiskas() + ")");
    }
    
} //akhir
