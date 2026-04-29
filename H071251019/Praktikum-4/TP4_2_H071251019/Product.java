package TP4_2_H071251019;

class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price){
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;}

    public void displayinfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + seriesNumber);
        System.out.println("Price: $" + price);
    }
} // akhir product

class Smartphone extends Product{
    double screenSize;
    int storageCapacity;
    
    public Smartphone(String brand, int seriesNumber, double price, double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;}

    
    // @Override
    public void displayinfo(){
        super.displayinfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}

class Camera extends Product{
    int resolution;
    String lensType;
    public Camera(String brand, int seriesNumber, double price, int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;}

    @Override
    public void displayinfo(){
        super.displayinfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}

class Laptop extends Product{
    int ramSize;
    String processorType;
    public Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    @Override
    public void displayinfo(){
        super.displayinfo();
        System.out.println("Processor: " + processorType);
        System.out.println("RAM Size: " + ramSize + "GB");
    }

}



