public class Pilot {
    private String kodPilota;
    private String planeta;
    private int rokNarozeni;
    private String typLodi;
    private int pocetVyher;

    public Pilot(String kodPilota, String planeta, int rokNarozeni, String typLodi, int pocetVyher) {
        this.kodPilota = kodPilota;
        this.planeta = planeta;
        this.rokNarozeni = rokNarozeni;
        this.typLodi = typLodi;
        this.pocetVyher = pocetVyher;
    }

    public String getKodPilota() {
        return kodPilota;
    }

    public void setKodPilota(String kodPilota) {
        this.kodPilota = kodPilota;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    public int getRokNarozeni() {
        return rokNarozeni;
    }

    public void setRokNarozeni(int rokNarozeni) {
        this.rokNarozeni = rokNarozeni;
    }

    public String getTypLodi() {
        return typLodi;
    }

    public void setTypLodi(String typLodi) {
        this.typLodi = typLodi;
    }

    public int getPocetVyher() {
        return pocetVyher;
    }

    public void setPocetVyher(int pocetVyher) {
        this.pocetVyher = pocetVyher;
    }

    @Override
    public String toString() {
        return "Kod pilota: " + kodPilota + " Planeta: " + planeta + " Rok narozeni: " + rokNarozeni + " Typ lodi: " + typLodi + " Pocet vyher: " + pocetVyher;
    }
}
