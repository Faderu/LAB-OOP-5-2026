abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;
    
    public Karyawan(String nama, String idKaryawan){
        this.nama = nama;
        this.idKaryawan =  idKaryawan;
    }

    public void absen(){
        jumlahKehadiran++;
    }

    public  int getjumlahKehadiran(){
        return jumlahKehadiran; 
    }

    public String getnama(){
        return nama;
    }

    public abstract double hitungGaji();
}

class KaryawanTetap extends Karyawan{
    double gajiPokok;
    double tunjanganMakanan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakanan){
    super(nama, idKaryawan);
    this.gajiPokok = gajiPokok;
    this.tunjanganMakanan = tunjanganMakanan;
    }

    @Override
    public double hitungGaji(){
        double  totalGaji = gajiPokok + (tunjanganMakanan * getjumlahKehadiran());
        return totalGaji;
    }

    public double hitungGaji(double bonusKinerja){
        double totalGaji = hitungGaji() + bonusKinerja;
        return totalGaji;
    }
}

class KaryawanKontrak extends Karyawan{
    double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari){
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji(){
        double totalGaji = upahPerHari * getjumlahKehadiran();
        if(getjumlahKehadiran() > 20){
            totalGaji += 500000;
        }
        return totalGaji;
    }
}

public class MainGaji{
    public static void main(String[]args){

        KaryawanTetap Ayu = new KaryawanTetap("Ayu", "KT-005", 15000000, 100000);

        for (int i = 0; i < 5; i++) {
            Ayu.absen();
        }

        double gajiAyu = Ayu.hitungGaji(8000000);
        System.out.println("Karyawan: " + Ayu.getnama());
        System.out.println("Kehadiran: " + Ayu.getjumlahKehadiran() + " hari");
        System.out.printf("Total Gaji (+Bonus): Rp %.0f\n ", gajiAyu);
    

        KaryawanKontrak siti = new KaryawanKontrak("Siti", "KK-001", 200000);
        
        for (int i = 0; i < 29; i++) {
            siti.absen();
        }
        
        double gajiSiti = siti.hitungGaji(); 
        System.out.println("Karyawan: " + siti.getnama());
        System.out.println("Kehadiran: " + siti.getjumlahKehadiran() + " hari");
        System.out.printf("Total Gaji (Termasuk bonus kehadiran): Rp %.0f\n", gajiSiti);
}
}


