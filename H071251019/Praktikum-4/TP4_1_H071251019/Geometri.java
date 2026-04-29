package TP4_1_H071251019;

class Geometri {
    double hitungluas(){
        return 0;}
    double hitungkeliling(){
        return 0;}
    double hitungvolume(){
        return 0;}
}

// BANGUN RUANG; KUBUS, BALOK, BOLA, TABUNG
class Kubus extends Geometri{
    double sisi;
    Kubus(double sisi){
        this.sisi = sisi;}

    double hitungluas(){
        return 6 * sisi * sisi;}

    double hitungvolume(){
        return sisi * sisi * sisi;}
}

class Balok extends Geometri{
    double panjang, lebar, tinggi;
    Balok(double panjang, double lebar, double tinggi){
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;}

    double hitungluas(){
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));}

    double hitungvolume(){
        return panjang * lebar * tinggi;}
}

class Bola extends Geometri{
    double r;
    Bola(double r){
        this.r = r;}

    double hitungluas(){
        return 4 * 3.14 * r * r;}

    double hitungvolume(){
        return 4.0/3.0 * 3.14 * r * r;}
}

class Tabung extends Geometri{
    double r, tinggi;
    Tabung(double r, double tinggi){
        this.r = r;
        this.tinggi = tinggi;}

    double hitungluas(){
        return 2 * 3.14 * r * (r + tinggi);}

    double hitungvolume(){
        return 3.14 * r * tinggi;}
}

// BANGUN DATAR; PERSEGI, P.PANJANG, LINGKARAN, TRAPESIUM
class Persegi extends Geometri{
    double sisi;
    Persegi(double sisi){
        this.sisi = sisi;}

    double hitungluas(){
        return sisi * sisi;}

    double hitungkeliling(){
        return 4 * sisi;}
}

class PersegiPanjang extends Geometri{
    double panjang, lebar;
    PersegiPanjang(double panjang, double lebar){
        this.panjang = panjang;
        this.lebar = lebar;}
    
    double hitungluas(){
        return panjang * lebar;}

    double hitungkeliling(){
        return 2 * (panjang + lebar);}
}

class Lingkaran extends Geometri{
    double r;
    Lingkaran(double r){
        this.r = r;}

    double hitungluas(){
        return 3.14 * r * r;}

    double hitungkeliling(){
        return 2 * 3.14 * r;}
}

class Trapesium extends Geometri{
    double s1, s2, s3, s4, tinggi;
    Trapesium(double s1, double s2, double s3, double s4, double tinggi){
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.tinggi = tinggi;}

    double hitungluas(){
        return ((s1 + s2)*tinggi) / 2;}   // a+b it u 2 sisi sejajar

    double hitungkeliling(){
        return s1 + s2 + s3 + s4;}
}
