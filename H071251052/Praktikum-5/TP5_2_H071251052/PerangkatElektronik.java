abstract class PerangkatElektronik {
    protected String merk;
    protected double dayaListrik;

    public PerangkatElektronik(String merk, double dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower() {
        System.out.println("[" + merk + "] Perangkat sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }
}