class DompetDigital {

    private String pin;
    private double saldo;

    protected String idNasabah;

    String jenisAkun;

    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0;
        this.jenisAkun = "Basic";
    }

    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ubahPin(String pinLama, String pinBaru) {
        if (!this.pin.equals(pinLama)) {
            System.out.println("PIN lama salah!");
        } else if (pinBaru.length() != 6) {
            System.out.println("PIN baru harus 6 digit!");
        } else {
            this.pin = pinBaru;
            System.out.println("PIN berhasil diubah");
        }
    }

    public void setor(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Nominal tidak valid!");
            logTransaksi("Setor gagal");
        } else {
            saldo += jumlah;
            System.out.println("Setor berhasil");
            logTransaksi("Setor berhasil");
        }
    }

    private void tarik(double jumlah, String pin) {
        if (!this.pin.equals(pin)) {
            System.out.println("PIN salah!");
            logTransaksi("Tarik gagal (PIN salah)");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup!");
            logTransaksi("Tarik gagal (saldo kurang)");
        } else {
            saldo -= jumlah;
            System.out.println("Tarik berhasil");
            logTransaksi("Tarik berhasil");
        }
    }

    public void gettarik(double jumlah, String pin){
        tarik(jumlah, pin);
    }

    private void logTransaksi(String pesan) {
        System.out.println("[LOG]: " + pesan);
    }
}