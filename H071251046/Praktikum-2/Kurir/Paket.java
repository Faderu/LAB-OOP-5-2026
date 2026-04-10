package Kurir;

class Paket {
    // atribut class
    String namaBarang;
    String asal;
    String tujuan;

    // constructor Default
    Paket () {
        this.namaBarang = "Tidak diketahui";
        this.asal = "Tidak ditentukan";
        this.tujuan = "Tidak ditentukan";
    }

    // constructor Berparameter
    Paket (String namaBarang, String asal, String tujuan) {
        this.namaBarang = namaBarang;
        this.asal = asal;
        this.tujuan = tujuan;
    }
}
