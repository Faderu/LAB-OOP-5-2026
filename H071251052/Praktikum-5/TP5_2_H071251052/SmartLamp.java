class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, double dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("[" + merk + "] Fungsi: Pencahayaan pintar dengan kontrol suara.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else if (perintah.equalsIgnoreCase("MATI")) {
            System.out.println("Lampu mati");
        } else {
            System.out.println("Perintah tidak dikenali: " + perintah);
        }
    }
}