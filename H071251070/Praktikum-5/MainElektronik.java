abstract class PerangkatElektronik{
    String merk;
    int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik){
        this.merk = merk;
        this.dayaListrik = dayaListrik;   
    }

    public void infoPower(){
        System.out.println(merk + " sedang menyedot daya sebesar " + dayaListrik + "watt");
    }
}

interface InteraksiInternet{
    void hubungkanWifi();
}

interface KontrolSuara{
    void prosesPerintah(String perintah);
}

class SmartLamp extends PerangkatElektronik implements KontrolSuara{
    public SmartLamp(String merk, int dayaListrik){
        super(merk, dayaListrik);
    }

    @Override
    public void prosesPerintah(String perintah){
        if(perintah.equalsIgnoreCase("NYALA")){
            System.out.println("Lampu berpijar!");
        }
    }

}

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet{
    public SmartCCTV(String merk, int dayaListrik){
        super(merk, dayaListrik);
    }

    @Override
    public void hubungkanWifi(){
        System.out.println("Mengirim data ke server...");
    }
}

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara{
    public SmartSpeaker(String merk,int dayaListrik){
        super(merk, dayaListrik);
    }

   @Override
    public void prosesPerintah(String perintah){
        if(perintah.equalsIgnoreCase("ON")){
            System.out.println("Speaker menyala dan siap memutar musik");
        }
    }

     @Override
    public void hubungkanWifi(){
        System.out.println("Wifi connected succesfully");
    }
}

public class MainElektronik{
    public static void main(String[]args){
        SmartLamp lampu = new SmartLamp("Philips Hue", 10);
        SmartCCTV cctv = new SmartCCTV("Xiaomi Mi Home", 5);
        SmartSpeaker speaker = new SmartSpeaker("Sony", 15);

        lampu.infoPower();
        lampu.prosesPerintah("nyala");
         

        cctv.infoPower();
        cctv.hubungkanWifi();

        speaker.infoPower();
        speaker.hubungkanWifi();
        speaker.prosesPerintah("ON");
     }


    }