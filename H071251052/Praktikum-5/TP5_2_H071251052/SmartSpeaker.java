class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] Fungsi: Speaker pintar dengan WiFi dan kontrol suara.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: '" + perintah + "'");
    }
}