package net.gbfactory.concessionaria.controller;

import net.gbfactory.concessionaria.model.Auto;
import net.gbfactory.concessionaria.model.Bagagliaio;
import net.gbfactory.concessionaria.model.Cambio;
import net.gbfactory.concessionaria.model.Database;

public class Controller {

    Database database = new Database();
    
    public void addAuto(String marca, String modello, boolean vendita,
    String targa, String cambioString, int bagagliaioInt, String alimentazione,
    int numeroPosti, int cilindrata, int colore){

        //Conversione Cambio
        Cambio cambio = null;

        if(cambioString.equals("manuale")){
            cambio = Cambio.MANUALE;
        }else if(cambioString.equals("automatico")){
            cambio = Cambio.AUTOMATICO;
        }

        //Conversione Bagagliaio
        Bagagliaio bagagliaio = null;

        switch (bagagliaioInt) {
            case 0:
                bagagliaio = Bagagliaio.PICCOLO;
                break;
        
            case 1:
                bagagliaio = Bagagliaio.MEDIO;
                break;

            case 2:
                bagagliaio = Bagagliaio.GRANDE;
                break;
        }

        //Creazione Auto
        Auto auto = new Auto(marca, modello, vendita, targa, cambio, bagagliaio, alimentazione, numeroPosti, cilindrata, colore);
    
        //Aggiungiamo l'auto al db
        database.addAuto(auto);

    }

}
