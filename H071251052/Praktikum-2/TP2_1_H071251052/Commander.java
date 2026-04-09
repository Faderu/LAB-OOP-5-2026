package TP2_1_H071251052;

public class Commander {
    String nama;
    int hp;
    SkillCommander skillAktif; 

    public Commander() {
        this.nama = "Harper";
        this.hp = 100;
        this.skillAktif = new SkillCommander("Shield", 5);
    }

    public Commander(String nama, int hp, SkillCommander skillAktif) {
        this.nama = nama;
        this.hp = hp;
        this.skillAktif = skillAktif;
    }

    public void gunakanSkill() {
        this.skillAktif.aktifkanSkill(); 
    }

    public void serang(Commander musuh) {
        System.out.println(this.nama + " menyerang " + musuh.nama + "!");
        
        int totalDamage = this.skillAktif.damageSkill; 
        musuh.hp -= totalDamage; 
        
        // Memastikan HP tidak minus
        if (musuh.hp < 0) {
            musuh.hp = 0;
        }
        
        System.out.println(musuh.nama + " terkena " + totalDamage + " damage. Sisa HP: " + musuh.hp);
    }
}