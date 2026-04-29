class Bangun {
    public double luas(){
        return 0;
    }

    public double keliling(){
        return 0;
    }

    public double volume(){
        return 0;
    }
}

class Persegi extends Bangun {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    public double luas() {
        return sisi * sisi;
    }

    public double keliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang extends Bangun {
    double panjang;
    double lebar;

    PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double luas() {
        return panjang * lebar;
    }

    public double keliling() {
        return 2 * (panjang + lebar);
    }
}

class Lingkaran extends Bangun {
    double jariJari;

    Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public double luas() {
        return Math.PI * jariJari * jariJari;
    }

    public double keliling() {
        return 2 * Math.PI * jariJari;
    }
}

class Trapesium extends Bangun {
    double sisiAtas;
    double sisiBawah;
    double tinggi;
    double sisiMiringKiri;
    double sisiMiringKanan;

    Trapesium(double sisiAtas, double sisiBawah, double tinggi,
              double sisiMiringKiri, double sisiMiringKanan) {
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.tinggi = tinggi;
        this.sisiMiringKiri = sisiMiringKiri;
        this.sisiMiringKanan = sisiMiringKanan;
    }

    public double luas() {
        return 0.5 * (sisiAtas + sisiBawah) * tinggi;
    }

    public double keliling() {
        return sisiAtas + sisiBawah + sisiMiringKiri + sisiMiringKanan;
    }
}

class Kubus extends Persegi {

    Kubus(double sisi) {
        super(sisi);
    }

    public double luas() {
        return 6 * (sisi * sisi);
    }

    public double volume() {
        return sisi * sisi * sisi;
    }

    
}

class Balok extends PersegiPanjang {
    double tinggi;

    Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public double luas(){
        return 2 * ((panjang * lebar) + (panjang * tinggi) (luas * tinggi));
    }

    public double volume() {
        return panjang * lebar * tinggi;
    }
}

class Bola extends Lingkaran {

    Bola(double jariJari) {
        super(jariJari);
    }

    public double luas(){
        return 4 * Math.PI * jariJari * jariJari;
    }

    public double volume() {
        return (4/3) * Math.PI * jariJari * jariJari * jariJari;
    }
}
    
class Tabung extends Lingkaran {
    double tinggi;

    Tabung(double jariJari, double tinggi) {
        super(jariJari);
        this.tinggi = tinggi;
    }

    public double luas(){
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    public double volume() {
        return luas() * tinggi; 
    }
}