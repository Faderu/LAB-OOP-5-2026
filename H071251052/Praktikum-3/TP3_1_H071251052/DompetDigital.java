package TP3_1_H071251052;

public class DompetDigital {

    // Private
    private double saldo;
    private String pin;

    // Protected
    protected String idNasabah;

    // Default
    double limitTransaksi;

    // Constructor (Public)
    public DompetDigital(String idNasabah, String pin) {
        this.idNasabah = idNasabah;
        this.pin = pin;
        this.saldo = 0;
        this.limitTransaksi = 10000000;
        catatLog("Akun baru dibuat untuk ID: " + idNasabah);
    }

    // Getter
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setter
    public void ubahPin(String pinLama, String pinBaru) {
        if (!pinLama.equals(this.pin)) {
            System.out.println("[❌] PIN lama ga cocok 🤨");
            catatLog("Percobaan ubah PIN gagal. PIN lama salah.");
        } else if (pinBaru.length() != 6) {
            System.out.println("[❌] PIN baru harus tepat 6 karakter.");
            catatLog("Percobaan ubah PIN gagal. Panjang PIN baru tidak valid.");
        } else {
            this.pin = pinBaru;
            System.out.println("[✅] PIN berhasil diubah.");
            catatLog("PIN berhasil diubah.");
        }
    }

    // Setor Tunai
    public void setorTunai(double nominal) {
        if (nominal <= 0) {
            System.out.println("[❌] Nominal setor tidak boleh nol atau negatif.");
            catatLog("Setor tunai ditolak. Nominal ilegal.");
        } else {
            saldo += nominal;
            System.out.println("[✅] Setor Rp " + nominal + ". Saldo sekarang: Rp " + saldo);
            catatLog("Setor tunai Rp " + nominal + " berhasil.");
        }
    }

    // Tarik Tunai
    private void tarikTunai(double nominal, String pinInput) {
        if (!pinInput.equals(this.pin)) {
            System.out.println("[❌] PIN salah 🤨");
            catatLog("Penarikan ditolak. PIN salah.");
        } else if (nominal <= 0) {
            System.out.println("[❌] Nominal tarik tidak boleh nol atau negatif.");
            catatLog("Penarikan ditolak. Nominal ilegal");
        }else if (nominal > limitTransaksi){
            System.out.println("[❌] Nominal melebihi batas transaksi harian.");
            catatLog("Penarikan ditolak. Melebihi batas transaksi harian.");
        } else if (nominal > saldo) {
            System.out.println("[❌] Saldo tidak cukup 😹");
            catatLog("Penarikan Rp " + nominal + " ditolak. Saldo kurang.");
        } else {
            saldo -= nominal;
            System.out.println("[✅] Penarikan saldo Rp " + nominal + "berhasil");
            catatLog("Tarik tunai Rp " + nominal + " berhasil.");
        }
    }

    public void gettarikTunai(double nominal, String pinInput){
        tarikTunai(nominal, pinInput);
    }


    private void catatLog(String pesan) {
        System.out.println("[📜] " + pesan);
    }
}

