package no1;
public class Bangun {
    double phi = 3.14;
}

class BangunRuang extends Bangun {}
class BangunDatar extends Bangun {}

class Kubus extends BangunRuang {
    double sisi;
    public double hitungVolume() { return Math.pow(sisi, 3); }
    public double luasPermukaan() { return 6 * sisi * sisi; }
}

class Balok extends BangunRuang {
    double p, l, t;
    
    public double hitungVolume() {
        return p * l * t; 
    }
    public double luasPermukaan() { return 2 * (p * l + p * t + l * t); }
}

class Bola extends BangunRuang {
    double r;
    public double hitungVolume() { return (4.0 / 3.0) * super.phi * Math.pow(r, 3); }
    public double luasPermukaan() { return 4 * super.phi * r * r; }
}

class Tabung extends BangunRuang {
    double r, t;
    public double hitungVolume() { return super.phi * r * r * t; }
    public double luasPermukaan() { return 2 * super.phi * r * (r + t); }
}


class Persegi extends BangunDatar {
    double s;
    public double hitungLuas() { return s * s; }
    public double hitungKeliling() { return 4 * s; }
}

class PersegiPanjang extends BangunDatar {
    double p, l;
    public double hitungLuas() { return p * l; }
    public double hitungKeliling() { return 2 * (p + l); }
}

class Lingkaran extends BangunDatar {
    double r;
    public double hitungLuas() { return super.phi * r * r; }
    public double hitungKeliling() { return 2 * super.phi * r; }
}

class Trapesium extends BangunDatar {
    double s1, s2, s3, s4, t;
    public double hitungLuas() { return (1.0 / 2.0) * (s1 + s2) * t; }
    public double hitungKeliling() { return s1 + s2 + s3 + s4; }
}