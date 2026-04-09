package TP2_1_H071251052;

public class Main {
    public static void main(String[] args) {
        SkillCommander skillMiya = new SkillCommander("Lunar Longbow", 15);
        SkillCommander skillYuZhong = new SkillCommander("Soul Grip", 20);

        Commander player1 = new Commander("Miya", 100, skillMiya);
        Commander player2 = new Commander("Yu Zhong", 100, skillYuZhong);

        System.out.println("=== MATCH DIMULAI ===");

        int ronde = 1;
        while (player1.hp > 0 && player2.hp > 0) {
            System.out.println("\n--- RONDE " + ronde + " ---");
            
            // P1 menyerang
            player1.gunakanSkill();
            player1.serang(player2);
            
            // Cek P2 mati atau nda
            if (player2.hp == 0) {
                System.out.println(player2.nama + " telah gugur!");
                break;
            }

            // P2 menyerang
            System.out.println("---------------------");
            player2.gunakanSkill();
            player2.serang(player1);

            // Cek P1 mati atau nda
            if (player1.hp == 0) {
                System.out.println(player1.nama + " telah gugur!");
                break;
            }
            
            ronde++;
        }
        
        System.out.println("\nPERTANDINGAN SELESAI!");
        
        // Winner
        if (player1.hp > 0) {
            System.out.println("Pemenangnya adalah: " + player1.nama + " dengan sisa HP " + player1.hp);
        } else {
            System.out.println("Pemenangnya adalah: " + player2.nama + " dengan sisa HP " + player2.hp);
        }
    }
}