/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.Color;

/**
 *
 * @author Bernat2
 */
public class CasellaFixa extends Casella {

    public CasellaFixa(int n) {
        super();
        setText(Integer.toString(n));
        setEditable(false);
        setBackground(Color.white);

    }

    public CasellaFixa() {
        super();
        setEditable(false);
        setBackground(Color.white);
    }

}
