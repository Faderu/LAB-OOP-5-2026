public class NenAbility {
    String type;
    int power;

    public NenAbility(){
        type = "enhancer";
        power = 100;
    }

    public NenAbility(String type, int power) {
        this.type = type;
        this.power = power;
    }

    public void showNen() {
        System.out.println("Nen Type: " + type + ", Power: " + power);
    }
}