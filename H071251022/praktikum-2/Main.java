public class Main {
    public static void main(String[] args) {
       
        Karakter karakter1 = new Karakter();
        YangdiLempar lemparKuat = new YangdiLempar("pedang", 20);
        Karakter karakter2 = new Karakter("dog", 150, lemparKuat);

        System.out.println(karakter1.nama + " memiliki health: " + karakter1.health + " dan lempar: " + karakter1.lempar.nama);
        System.out.println(karakter2.nama + " memiliki health: " + karakter2.health + " dan lempar: " + karakter2.lempar.nama);

        karakter1.serang(karakter2);
        karakter2.serang(karakter1);


        YangdiLempar lemparBaru = new YangdiLempar("panah", 15);
        karakter1.gantiyangdiLempar(lemparBaru);

        System.out.println(karakter1.nama + " sekarang menggunakan " + karakter1.lempar.nama);

        System.out.println(karakter1.nama + " memiliki health: " + karakter1.health );
        System.out.println(karakter2.nama + " memiliki health: " + karakter2.health );
    }
}
