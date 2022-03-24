package net.gbfactory.concessionaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraStrumenti extends JPanel implements ActionListener {

    private JButton bottoneBuongiorno;
    private JButton bottoneBuonasera;
    private TextListener textListener;

    BarraStrumenti(){
        bottoneBuongiorno = new JButton("Buongiorno");
        bottoneBuonasera = new JButton("Buonasera");

        bottoneBuongiorno.addActionListener((ActionListener) this);
        bottoneBuonasera.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(bottoneBuongiorno);
        add(bottoneBuonasera);
    }

    public void setTextListener(TextListener textListener){
        this.textListener = textListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(textListener != null){
            JButton premuto = (JButton) e.getSource();

            if(premuto == bottoneBuongiorno){
                textListener.testoEmesso("Buongiorno!\n");
            }else if(premuto == bottoneBuonasera){
                textListener.testoEmesso("Buonasera!\n");
            }
        }
    }

}