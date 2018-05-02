/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Bernat2
 */
public class Cronometre extends JTextField {

    private Joc joc;

    private int h, m, s;
    Timer tim;

    public class EventoCrono implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            s++;
            if (s == 60) {
                s = 0;
                m++;
            }

            if (m == 60) {
                m = 0;
                h++;
            }

            actualizarCrono();

        }
    }

    public Cronometre() {
        this.h = 0;
        this.m = 0;
        this.s = 0;
        tim = new Timer(1000, new EventoCrono());
        this.setEditable(false);
        this.setBackground(Color.white);
        Font fuente = new Font("fuente",Font.BOLD, 28);
        setFont(fuente);       

    }

    public void actualizarCrono() {

        String h1, m1, s1;

        if (h < 10) {
            h1 = "0";
        } else {
            h1 = "";
        }

        if (m < 10) {
            m1 = "0";
        } else {
            m1 = "";
        }

        if (s < 10) {
            s1 = "0";
        } else {
            s1 = "";
        }

        String crono = h1 + h + ":" + m1 + m + ":" + s1 + s;
        setText(crono);

    }
    
    public void reset(){
        tim.stop();
        this.setText("00:00:00");
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    public Joc getJoc() {
        return joc;
    }

    public void setJoc(Joc juego) {
        this.joc = juego;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public Timer getTim() {
        return tim;
    }

    public void setTim(Timer tim) {
        this.tim = tim;
    }

}
