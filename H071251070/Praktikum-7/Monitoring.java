public class  Monitoring implements Runnable{

    private final Gudang gudang;

    public Monitoring(Gudang gudang){
        this.gudang = gudang;
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted()){

            try{
                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();

                int persentase = (stok * 100) / kapasitas;

                int panjangBar = 20;

                int isi = (stok * panjangBar) / kapasitas;

                String bar = "";

                for (int i = 0; i < isi; i++) {
                    bar += "#";
                }

                for (int i = isi; i < panjangBar; i++) {
                    bar += "-";
                }

                System.out.println("Status Gudang: [" + bar + "] " + persentase + "%");
          
                Thread.sleep(1000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();
            }
        }
    }
}