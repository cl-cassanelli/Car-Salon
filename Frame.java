import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

    private TextAreaPanel textAreaPanel;
    private PannelloForm pannelloForm;
    private BarraStrumenti barraStrumenti;

    public Frame(){

        super("Titolo finestra");

        setLayout(new BorderLayout());

        barraStrumenti = new BarraStrumenti();
        textAreaPanel = new TextAreaPanel();
        pannelloForm = new PannelloForm();

        barraStrumenti.setTextListener(new TextListener(){
            @Override
            public void testoEmesso(String testo) {
                textAreaPanel.appendiTesto(testo);
            }
        });

        pannelloForm.setFormListener(new FormListener(){
            @Override
            public void formEventListener(FormEvent fe) {
                String marca = fe.getMarca();
                String modello = fe.getModello();
                Boolean vendita = fe.isVendita();
                String targa = fe.getTarga();
                String cambio = fe.getCambio();
                String bagagliaio = null;
                String alimentazione = fe.getAlimentazione();
                int numeroPosti = fe.getNumeroPosti();
                int cilindrata = fe.getCilindrata();

                switch (fe.getBagagliaio()) {
                    case 0:
                        bagagliaio = "Piccolo";
                        break;
                    
                    case 1: 
                        bagagliaio = "Medio";
                        break;

                    case 2:
                        bagagliaio = "Grande";
                        break;
                }

                textAreaPanel.appendiTesto("Marca: " + marca + "\nModello: " + modello + "\nVenduta: " + vendita + "\nTarga: " + targa + 
                                            "\nCambio: " + cambio + "\nBagagliaio: " + bagagliaio + "\nAlimentazione: " + alimentazione + 
                                            "\nPosti: " + numeroPosti + "\nCilindrata: " + cilindrata + "\n");
            }
        });

        add(textAreaPanel, BorderLayout.CENTER);
        add(barraStrumenti, BorderLayout.PAGE_START);
        add(pannelloForm, BorderLayout.LINE_START);

        setSize(800,500);
        setLocationRelativeTo(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}