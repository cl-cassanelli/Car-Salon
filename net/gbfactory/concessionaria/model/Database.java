package net.gbfactory.concessionaria.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Auto> automobili;

    public Database(){
        automobili = new ArrayList<Auto>();
    }

    public void addAuto(Auto auto){
        automobili.add(auto);
    }

    public List<Auto> getAutomobili(){
        return automobili;
    }

}
