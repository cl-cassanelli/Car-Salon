import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.*;

public class PannelloForm extends JPanel {

    private JLabel labelMarca;
    private JLabel labelModello;

    private JTextField fieldMarca;
    private JTextField fieldModello;

    private JLabel lableVendita;
    private JCheckBox checkVendita;

    private JLabel labelTarga;
    private JTextField fieldTarga;

    private JLabel labelCambio;
    private JRadioButton radioCambioManuale;
    private JRadioButton radioCambioAutomatico;
    private ButtonGroup gruppoRadioCambio;

    private JLabel labelBagagliaio;
    private JList listaBagagliaio;

    private JButton bottoneAggiungi;

    private FormListener formListener;

    PannelloForm(){

        setPreferredSize(new Dimension(300,100));
        setLayout(new GridBagLayout());

        //Bordi
        Border bordoInterno = BorderFactory.createTitledBorder("Aggiungi Automobile");
        Border bordoEsterno = BorderFactory.createEmptyBorder(5,5,5,5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);

        setBorder(bordoFinale);

        //Marca
        labelMarca = new JLabel("Marca: ");
        fieldMarca = new JTextField(15);

        //Modello
        labelModello = new JLabel("Modello: ");
        fieldModello = new JTextField(15);

        //Vendita e Targa
        lableVendita = new JLabel("Vendita: ");
        checkVendita = new JCheckBox();

        labelTarga = new JLabel("Targa: ");
        fieldTarga = new JTextField(15);

        labelTarga.setEnabled(false);
        fieldTarga.setEnabled(false);

        checkVendita.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selezione = checkVendita.isSelected();
                
                labelTarga.setEnabled(selezione);
                fieldTarga.setEnabled(selezione);

                if(!selezione) fieldTarga.setText("");
            }
        });

        //Cambio
        labelCambio = new JLabel("Cambio: ");

        radioCambioManuale = new JRadioButton("Manuale");
        radioCambioManuale.setActionCommand("manuale");
        radioCambioAutomatico = new JRadioButton("Automatico");
        radioCambioAutomatico.setActionCommand("automatico");

        gruppoRadioCambio = new ButtonGroup();
        gruppoRadioCambio.add(radioCambioManuale);
        gruppoRadioCambio.add(radioCambioAutomatico);

        //Bagagliaio
        labelBagagliaio = new JLabel("Bagagliaio: ");

        listaBagagliaio = new JList();
        listaBagagliaio.setPreferredSize(new Dimension(170, 55));
        listaBagagliaio.setBorder(BorderFactory.createEtchedBorder());

        DefaultListModel modelloBagagliaio = new DefaultListModel();
        modelloBagagliaio.addElement(new Bagagliaio(0, "Piccolo"));
        modelloBagagliaio.addElement(new Bagagliaio(1, "Medio"));
        modelloBagagliaio.addElement(new Bagagliaio(2, "Grande"));

        listaBagagliaio.setModel(modelloBagagliaio);

        //Bottone
        bottoneAggiungi = new JButton("Aggiungi!");

        bottoneAggiungi.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String marca = fieldMarca.getText();
                String modello = fieldModello.getText();
                Boolean vendita = checkVendita.isSelected();
                String targa = fieldTarga.getText();
                String cambio = gruppoRadioCambio.getSelection().getActionCommand();
                int bagagliaio = ((Bagagliaio) listaBagagliaio.getSelectedValue()).getId();

                FormEvent  formEvent = new FormEvent(this, marca, modello, vendita, targa, cambio, bagagliaio);

                if(formListener != null){
                    formListener.formEventListener(formEvent);
                }
            }
        });

        //Layout
        GridBagConstraints gbc = new GridBagConstraints();

        //RIGA 1: lable marca
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        add(labelMarca, gbc);

        //RIGA 1: field marca
        gbc.gridx = 1;
        gbc.gridy = 0;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(fieldMarca, gbc);

        //RIGA 2: label modello
        gbc.gridx = 0;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        add(labelModello, gbc);

        //RIGA 2: field modello
        gbc.gridx = 1;
        gbc.gridy = 1;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(fieldModello, gbc);

        //RIGA 3: cambio
        gbc.gridx = 0;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        add(labelCambio, gbc);

        //RIGA 3: cambio manuale
        gbc.gridx = 1;
        gbc.gridy = 2;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(radioCambioManuale, gbc);

        //RIGA 4: cambio automatico
        gbc.gridx = 1;
        gbc.gridy = 3;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(radioCambioAutomatico, gbc);

        //RIGA 5: label bagagliaio
        gbc.gridx = 0;
        gbc.gridy = 4;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        add(labelBagagliaio, gbc);

        //RIGA 5: lista bagagliaio
        gbc.gridx = 1;
        gbc.gridy = 4;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(listaBagagliaio, gbc);

        //RIGA 5: lable vendita
        gbc.gridx = 0;
        gbc.gridy = 5;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        add(lableVendita, gbc);

        //RIGA 5: checkbox vendita
        gbc.gridx = 1;
        gbc.gridy = 5;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(checkVendita, gbc);

        //RIGA 6: lable targa
        gbc.gridx = 0;
        gbc.gridy = 6;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_END;

        gbc.insets = new Insets(0,0,0,5);

        add(labelTarga, gbc);

        //RIGA 6: field targa
        gbc.gridx = 1;
        gbc.gridy = 6;

        gbc.weightx = 0.01;
        gbc.weighty = 0.01;

        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.insets = new Insets(0,0,0,0);

        add(fieldTarga, gbc);

        //RIGA FINALE: bottone
        gbc.gridx = 0;
        gbc.gridy = 7;

        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        gbc.gridwidth = 2;
        gbc.gridheight = 1;

        gbc.anchor = GridBagConstraints.PAGE_START; 

        add(bottoneAggiungi, gbc);

    }

    public void setFormListener(FormListener formListener){
        this.formListener = formListener;
    }
    
}

class Bagagliaio{
    private int id;
    private String nome;

    public Bagagliaio(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}