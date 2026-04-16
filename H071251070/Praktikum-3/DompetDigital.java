public class DompetDigital{
    
    private int saldo;
    private String  pin;

    protected String IDnasabah;

    String statusakun;


public DompetDigital(String IDnasabah, String pin){
    this.pin = pin;
    this.IDnasabah = IDnasabah;
    this.saldo = 0;
    this.statusakun = "Aktif";
}

public String getIDnasabah(){
    return IDnasabah;
}

public int getsaldo(){
    return saldo;
}

public void getTarik(String inputPin, int tarik){
    tarik(inputPin, tarik);
}

public void setPin(String pinLama, String pinBaru){
    if(statusakun.equals("NonAktif")){
        System.out.println("Akun Tidak Aktif");
    }
        if(this.pin.equals(pinLama)){
            if(pinBaru.length()== 6){
                this.pin = pinBaru;
                riwayatAktivitas("Pin berhasil diubah");
            }else{
                riwayatAktivitas("Pin harus 6 digit");
            }

        }else {
            riwayatAktivitas("Pin lama salah");
        }
}

private void riwayatAktivitas(String pesan){
    System.out.println("[RIWAYAT] " + pesan);
}

public void setor(int setoran){
    if(statusakun.equals("NonAktif")){
        System.out.println("Akun Tidak Aktif");
    }
        if(setoran <= 0){
            riwayatAktivitas("Nominal tidak valid");
        }else{
            saldo += setoran;
            riwayatAktivitas("Setor: " + setoran);
        }
}   

private void tarik(String inputPin, int tarik){
    if(statusakun.equals("NonAktif")){
        System.out.println("Akun Tidak Aktif");
    }
        if (!this.pin.equals(inputPin)){
            riwayatAktivitas("Pin salah");
        }else if (tarik >  saldo){
            riwayatAktivitas("Saldo tidak cukup");
        }else{
            saldo -= tarik ;
            riwayatAktivitas("Penarikan: " + tarik);
        }
    }


}