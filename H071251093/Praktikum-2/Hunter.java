public class Hunter {
    String name;
    int hp;
    NenAbility nen;

    public Hunter() {
        name = "Unknown";
        hp = 100;
        nen = new NenAbility("Basic", 10);
    }

    public Hunter(String name, int hp, NenAbility nen) {
        this.name = name;
        this.hp = hp;
        this.nen = nen;
    }

    public void duel(Hunter enemy) {
        System.out.println(this.name + " menyerang " + enemy.name);
        enemy.hp -= this.nen.power;

        if (enemy.hp < 0) {
            enemy.hp = 0;
        }

        System.out.println(enemy.name + " kehilangan " + this.nen.power + " HP!");
    }

    public void showStatus() {
        System.out.println("Nama: " + name + " | HP: " + hp);
        nen.showNen();
    }
}