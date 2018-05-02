/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.event.*;

/**
 *
 * @author Bernat2
 */
public class CasellaVaria extends Casella {

    public CasellaVaria() {
        super();
        setText("");

    }

    @Override
    public void processKeyEvent(KeyEvent ev) {
        if (Character.isDigit(ev.getKeyChar())
                ||ev.getKeyChar()==KeyEvent.VK_BACK_SPACE
                ||ev.getKeyChar()==KeyEvent.VK_DELETE) {
            super.processKeyEvent(ev);
        }
        ev.consume();
        return;
    }

}
