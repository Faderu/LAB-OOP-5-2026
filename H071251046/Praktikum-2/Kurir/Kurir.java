package Kurir;

class Kurir {
    // atribut class
    String namaKurir;
    String wilayah;
    Paket paket; // atribut objek dari class lain

    // constructor default
    Kurir() {
        this.namaKurir = "Tidak diketahui";
        this.wilayah = "Tidak ditentukan";
    }

    // constructor Berparameter
    Kurir(String namaKurir, String wilayah) {
        this.namaKurir = namaKurir;
        this.wilayah = wilayah;
    }

    void ambilPaket(Paket paket) {
        this.paket = paket;
        System.out.println(namaKurir + " mengambil paket dari " + paket.asal);
    }
    
    void kirimPaket(String tujuan) {
        System.out.println(namaKurir + " mengantar paket ke tujuan: " + tujuan);
    }

    // method interaksi antar objek
    void serahTerima(Kurir kurirLain) {
        System.out.println(namaKurir + " menyerahkan paket ke " + kurirLain.namaKurir);
        kurirLain.paket = this.paket;
        this.paket = null;
    }
}
