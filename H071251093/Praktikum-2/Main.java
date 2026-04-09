public class Main {
    public static void main(String[] args) {

        NenAbility nen1 = new NenAbility("Enhancer", 25);
        NenAbility nen2 = new NenAbility("Transmuter", 20);

        Hunter hunter1 = new Hunter("Gon", 100, nen1);
        Hunter hunter2 = new Hunter("Killua", 100, nen2);

        hunter1.showStatus();
        hunter2.showStatus();

        System.out.println("=== DUEL DIMULAI ===");

        hunter1.duel(hunter2);
        hunter2.duel(hunter1);

        System.out.println("=== HASIL AKHIR ===");

        hunter1.showStatus();
        hunter2.showStatus();
    }
}