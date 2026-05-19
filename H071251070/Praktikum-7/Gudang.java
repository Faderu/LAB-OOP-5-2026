public class Gudang{
    private int stok;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal){
        this.stok = 0;
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

            
    public synchronized void tambahStok(int jumlah) throws InterruptedException{
                
        while(stok  + jumlah > kapasitasMaksimal){
            System.out.println("Stok penuh, pemasok harus menunggu...");
                wait();
        }
            stok += jumlah;
            System.out.println(Thread.currentThread().getName() + " menambahkan " + jumlah + " unit. Stok saat ini: " + stok);
            notifyAll();
        
    }

    public synchronized void ambilStok(int jumlah) throws InterruptedException {
        while(stok < jumlah){
            System.out.println("Stok kosong, konsumen harus menunggu...");
                wait();
        }
            stok -= jumlah;
            System.out.println(Thread.currentThread().getName() + " mengambil " + jumlah + " unit. Stok saat ini: " + stok);
            notifyAll();
        
    }

    public synchronized int getStok(){
        return stok;
    }

    public int getKapasitasMaksimal(){
        return kapasitasMaksimal;
    }
}