public class Main {
    public static void main(String[] args) {
        Dompet syahdan = new Dompet("Syahdan", 123457, 8739276);
        syahdan.getInfo();
        syahdan.setPin(132456);
        syahdan.setPin(112233);
        syahdan.getSetor(5000000);
        syahdan.getSetor(-100000);
        syahdan.tarik(1000000);
        syahdan.tarik(150000);
        syahdan.getInfo();
    }
}