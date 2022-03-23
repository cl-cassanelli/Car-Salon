import java.util.EventObject;

public class FormEvent extends EventObject {

    private String marca;
    private String modello;
    private boolean vendita;
    private String targa;
    private String cambio;
    private int bagagliaio;
    private String alimentazione;
    private int numeroPosti;
    private int cilindrata;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object surce, String marca, String modello, boolean vendita, String targa, String cambio, int bagagliaio, String alimentazione, int numeroPosti, int cilindrata){
        super(surce);
        this.marca = marca;
        this.modello = modello;
        this.vendita = vendita;
        this.targa = targa;
        this.cambio = cambio;
        this.bagagliaio = bagagliaio;
        this.alimentazione = alimentazione;
        this.numeroPosti = numeroPosti;
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() { return cilindrata; }

    public void setCilindrata(int cilindrata) { this.cilindrata = cilindrata; }

    public int getNumeroPosti() { return numeroPosti; }

    public void setNumeroPosti(int numeroPosti) { this.numeroPosti = numeroPosti; }

    public String getAlimentazione(){ return alimentazione; }

    public void setAlimentazione(String alimentazione){ this.alimentazione = alimentazione; }

    public String getCambio(){ return cambio; }

    public int getBagagliaio() { return bagagliaio; }

    public void setBagagliaio(int bagagliaio) { this.bagagliaio = bagagliaio; }
        
    public void setCambio(String cambio){ this.cambio = cambio; }

    public boolean isVendita(){ return vendita; }

    public void setVendita(boolean vendita){ this.vendita = vendita; }

    public String getTarga(){ return targa; }

    public void setTarga(String targa){ this.targa = targa; }

    public String getMarca(){ return marca; }

    public void setMarca(String marca){ this.marca = marca; }

    public String getModello(){ return modello; }

    public void setModello(String modello){ this.modello = modello; }
    
}