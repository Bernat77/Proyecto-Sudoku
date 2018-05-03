/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.Color;
import java.awt.event.*;


/**
 *
 * @author Bernat2
 */
public class CasellaVaria extends Casella{

    public CasellaVaria() {
        super();
        setText("");
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                CasellaVaria.this.select(0,getText().length());
            }

            @Override
            public void focusLost(FocusEvent e) {
                CasellaVaria.this.select(0,0);
            }
        });

    }

    @Override
    public void processKeyEvent(KeyEvent ev) {
        if (Character.isDigit(ev.getKeyChar())
                || ev.getKeyChar() == KeyEvent.VK_BACK_SPACE
                || ev.getKeyChar() == KeyEvent.VK_DELETE) {
            super.processKeyEvent(ev);
        }
        ev.consume();
        return;
    }

}
