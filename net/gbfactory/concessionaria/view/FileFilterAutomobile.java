package net.gbfactory.concessionaria.view;
import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileFilterAutomobile extends FileFilter{

    @Override
    public boolean accept(File f) {

        if(f.isDirectory()){
            return true;
        }
        
        String estensione = Utils.getExtension(f);

        if(estensione == null){
            return false;
        }

        if(estensione.equals("true")){
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "File Automobile (*.car)";
    }
    
}