/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Bernat2
 */
public class Boton extends JButton {

    private Joc joc;

    public class EventoNueva implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Boton.this.joc.getSemaforo().setStatus(4);
            Boton.this.joc.getCrono().reset();
            Boton.this.joc.getCrono().getTim().start();
            Boton.this.joc.enable();
            Boton.this.joc.nuevoTaulell();
        }
    }

    public class EventoComprob implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int n = joc.getTaulell().recorridoComprobar();
            switch (n) {
                case 1:
                    Boton.this.joc.getSemaforo().setStatus(n);
                    Boton.this.joc.getCrono().getTim().stop();
                    for (int i = 0; i < Boton.this.joc.getTaulell().getCaselles().length; i++) {
                        for (int j = 0; j < Boton.this.joc.getTaulell().getCaselles()[i].length; j++) {
                            Boton.this.joc.getTaulell().getCaselles()[i][j].setEditable(false);
                            Boton.this.joc.getTaulell().getCaselles()[i][j].setBackground(Color.white);
                        }
                    }
                    break;
                case 2:
                    Boton.this.joc.getSemaforo().setStatus(n);
                    break;
                case 3:
                    Boton.this.joc.getSemaforo().setStatus(n);
                    break;
            }

        }
    }

    public class EventoReint implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Boton.this.joc.getSemaforo().setStatus(4);
            Boton.this.joc.getCrono().reset();
            Boton.this.joc.getCrono().getTim().start();
            Casella[][] caselles = Boton.this.joc.getTaulell().getCaselles();
            for (int i = 0; i < caselles.length; i++) {
                for (int j = 0; j < caselles[i].length; j++) {
                    if (caselles[i][j] instanceof CasellaVaria) {
                        caselles[i][j].setEditable(true);
                        caselles[i][j].setText("");
                    }
                }
            }
            Boton.this.joc.getVentana().revalidate();
            Boton.this.joc.getVentana().repaint();
        }
    }

    public class EventoSalir implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public Boton(String texto) {
        super(texto);

    }

    public Joc getJoc() {
        return joc;
    }

    public void setJoc(Joc joc) {
        this.joc = joc;
    }

    public void setAccion(int n) {

        switch (n) {
            case 1:
                addActionListener(new Boton.EventoNueva());
                break;
            case 2:
                addActionListener(new Boton.EventoComprob());
                break;
            case 3:
                addActionListener(new Boton.EventoSalir());
                break;
            case 4:
                addActionListener(new Boton.EventoReint());
        }

    }

}
