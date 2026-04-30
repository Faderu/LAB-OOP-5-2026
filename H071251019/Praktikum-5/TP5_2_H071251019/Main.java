package TP5_2_H071251019;

public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips", 15);
        SmartCCTV cctv = new SmartCCTV("Hikvision", 45);
        SmartSpeaker speaker = new SmartSpeaker("JBL", 80);

        System.out.println("\n==== TOKO ELEKTRONIK ====");
        System.out.println("SMART LAMP");
        lampu.cekFungsi();
        lampu.prosesPerintah("NYALA");
        lampu.infoPower();

        System.out.println("\n=========");
        System.out.println("SMART CCTV");
        cctv.cekFungsi();
        cctv.hubungkanWifi();
        cctv.infoPower();

        System.out.println("\n=========");
        System.out.println("SMART SPEAKER");
        speaker.cekFungsi();
        speaker.hubungkanWifi();
        speaker.prosesPerintah("NYALA");
        speaker.infoPower();
    }
}
