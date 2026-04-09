public class Karakter {
    public String nama;
    public int health;
    public YangdiLempar lempar;

    public Karakter() {
        this.nama = "syhdan";
        this.health = 100;
        this.lempar = new YangdiLempar();
    }

    public Karakter(String nama, int health, YangdiLempar lempar) {
        this.nama = nama;
        this.health = health;
        this.lempar = lempar;
    }

    public void gantiyangdiLempar(YangdiLempar lemparBaru) {
        this.lempar = lemparBaru;
    }

    public void serang(Karakter target) {
        System.out.println(this.nama + " menyerang " + target.nama + " dengan " + this.lempar.nama);
        target.health -= this.lempar.damage;
        System.out.println(target.nama + " sekarang memiliki health: " + target.health);
    }
}