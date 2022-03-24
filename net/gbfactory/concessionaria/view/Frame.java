package net.gbfactory.concessionaria.view;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.KeyStroke;

import net.gbfactory.concessionaria.controller.Controller;

public class Frame extends JFrame {

    private TextAreaPanel textAreaPanel;
    private PannelloForm pannelloForm;
    private BarraStrumenti barraStrumenti;
    private JFileChooser fileChooser;
    private Controller controller;

    public Frame(){

        super("Titolo finestra");

        setLayout(new BorderLayout());

        setJMenuBar(creaBarraMenu());

        barraStrumenti = new BarraStrumenti();
        textAreaPanel = new TextAreaPanel();
        pannelloForm = new PannelloForm();

        controller = new Controller();

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilterAutomobile());
        fileChooser.setAcceptAllFileFilterUsed(false);

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
                int bagagliaio = fe.getBagagliaio();;
                String alimentazione = fe.getAlimentazione();
                int numeroPosti = fe.getNumeroPosti();
                int cilindrata = fe.getCilindrata();
                int colore = fe.getColore();

                controller.addAuto(marca, modello, vendita, targa, cambio, bagagliaio, alimentazione, numeroPosti, cilindrata, colore);
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

    private JMenuBar creaBarraMenu(){
        JMenuBar barraMenu = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);

        JMenuItem menuItemImporta = new JMenuItem("Importa...", new ImageIcon("./import.png")); //img size: 16px
        JMenuItem menuItemEsporta = new JMenuItem("Esporta...", new ImageIcon("./export.png")); //img size: 16px
        JMenuItem menuItemEsci = new JMenuItem("Esci (X)");
        menuItemEsci.setMnemonic(KeyEvent.VK_X);
        menuItemEsci.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        menuFile.add(menuItemImporta);
        menuFile.add(menuItemEsporta);
        menuFile.addSeparator();
        menuFile.add(menuItemEsci);

        JMenu menuFinestra = new JMenu("Finestra");

        JMenu menuMostra = new JMenu("Mostra");

        JMenuItem menuItemProblemi = new JMenuItem("Problemi");

        JCheckBoxMenuItem menuItemMostraForm = new JCheckBoxMenuItem("Mostra Form");
        menuItemMostraForm.setSelected(true);

        menuItemMostraForm.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                pannelloForm.setVisible(menuItem.isSelected());
            }
        });

        menuItemImporta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showOpenDialog(Frame.this) == JFileChooser.APPROVE_OPTION){

                }
            }
        });

        menuItemEsporta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fileChooser.showSaveDialog(Frame.this) == JFileChooser.APPROVE_OPTION){
                    
                }
            }
        });

        menuItemEsci.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int azioneFinestra = JOptionPane.showConfirmDialog(Frame.this, "Vuoi uscire dall'applicazione?", "Chiusura Applicazione", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
               
                if(azioneFinestra == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        menuMostra.add(menuItemProblemi);

        menuMostra.add(menuItemMostraForm);

        menuFinestra.add(menuMostra);


        barraMenu.add(menuFile);
        barraMenu.add(menuFinestra);


        return barraMenu;
    }
}