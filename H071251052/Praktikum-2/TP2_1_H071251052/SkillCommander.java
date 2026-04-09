package TP2_1_H071251052;

public class SkillCommander {
    String namaSkill;
    int damageSkill;

    public void aktifkanSkill() {
        System.out.println("Skill [" + namaSkill + "] aktif! (+Damage: " + damageSkill + ")");
    }

    public SkillCommander(String namaSkill, int damageSkill) {
        this.namaSkill = namaSkill;
        this.damageSkill = damageSkill;
    }
}