public class Produk{
    String brand;
    int noSeri;
    double price;

    public Produk(String brand, int noSeri, double price){
        this.brand = brand;
        this.noSeri = noSeri;
        this.price = price;
    }

    public void info(){
        System.out.println("Brand: " + brand);
        System.out.println("Nomor Seri: " + noSeri);
        System.out.println("Price: " + price);

    }
}
class Handphone extends Produk{
    double screenSize;
    int kapasitas;

    public Handphone(String brand, int noSeri, double price, double screenSize, int kapasitas) {
        super(brand, noSeri, price);
        this.screenSize = screenSize;
        this.kapasitas = kapasitas;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Screen Size: " + screenSize + "inches");
        System.out.println("Kapasitas: " + kapasitas + "GB");
    }
}

class Laptop extends Produk {
    String processor;
    int ramSize;

    public Laptop(String brand, int noSeri, double price, String processor, int ramSize) {
        super(brand, noSeri, price);
        this.processor = processor;
        this.ramSize = ramSize;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Processor type: " + processor);
        System.out.println("RAM Size: " + ramSize + "GB");
    }
}

class Kamera extends Produk {
    int resolusi;
    String lensType;

    public Kamera(String brand, int noSeri, double price, int resolusi, String lensType) {
        super(brand, noSeri, price);
        this.resolusi = resolusi;
        this.lensType = lensType;
    }

    @Override
    public void info() {
        super.info();
        System.out.println("Resolusi: " + resolusi + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}

