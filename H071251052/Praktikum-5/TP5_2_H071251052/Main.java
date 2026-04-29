public class Main {
    public static void main(String[] args) {
        System.out.println("========== SMART HOME ECOSYSTEM ==========\n");

        SmartLamp lamp = new SmartLamp("Panasonic", 12);
        System.out.println("-- SmartLamp --");
        lamp.cekFungsi();
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");
        lamp.prosesPerintah("TERBANG");
        lamp.prosesPerintah("MATI");

        System.out.println();

        SmartCCTV cctv = new SmartCCTV("Adudu", 15);
        System.out.println("-- SmartCCTV --");
        cctv.cekFungsi();
        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println();

        SmartSpeaker speaker = new SmartSpeaker("Anker", 25);
        System.out.println("-- SmartSpeaker --");
        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar musik K-Pop");
    }
}