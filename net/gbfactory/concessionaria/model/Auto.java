package net.gbfactory.concessionaria.model;

public class Auto {

    private static int contatore = 0;
    private int id;
    private String marca;
    private String modello;
    private boolean vendita;
    private String targa;
    private Cambio cambio;
    private Bagagliaio bagagliaio;
    private String alimentazione;
    private int numeroPosti;
    private int cilindrata;
    private int colore;

    public Auto(int id, String marca, String modello,
    Boolean vendita, String targa, Cambio cambio,
    Bagagliaio bagagliaio, String alimentazione,
    int numeroPosti, int cilindrata, int colore){
        
        this.id = contatore;
        this.marca = marca;
        this.modello = modello;
        this.vendita = vendita;
        this.targa = targa;
        this.cambio = cambio;
        this.bagagliaio = bagagliaio;
        this.alimentazione = alimentazione;
        this.numeroPosti = numeroPosti;
        this.cilindrata = cilindrata;
        this.colore = colore;

        contatore++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public boolean isVendita() {
        return vendita;
    }

    public boolean getVendita() {
        return vendita;
    }

    public void setVendita(boolean vendita) {
        this.vendita = vendita;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Cambio getCambio() {
        return cambio;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    public Bagagliaio getBagagliaio() {
        return bagagliaio;
    }

    public void setBagagliaio(Bagagliaio bagagliaio) {
        this.bagagliaio = bagagliaio;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getColore() {
        return colore;
    }

    public void setColore(int colore) {
        this.colore = colore;
    }


    
}
