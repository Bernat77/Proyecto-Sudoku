/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.Image;
import javax.swing.*;

/**
 *
 * @author Bernat2
 */
public class Semafor extends JLabel{
    
    private Joc joc;
    
    
    public Semafor(){
        setIcon(new ImageIcon(Joc.class.getResource("4apagado.png")));
    }

    
    public void setStatus(int n){
        switch(n){
            case 1:
                setIcon(new ImageIcon(Joc.class.getResource("1verde.png")));
                break;
            case 2:
                setIcon(new ImageIcon(Joc.class.getResource("2amarillo.png")));
                break;
            case 3:
                setIcon(new ImageIcon(Joc.class.getResource("3rojo.png")));
                break;
            case 4:
                setIcon(new ImageIcon(Joc.class.getResource("4apagado.png")));
                break;
        }
        
        joc.getVentana().revalidate();
        joc.getVentana().repaint();
    }
    
    
    public Joc getJoc() {
        return joc;
    }

    public void setJoc(Joc joc) {
        this.joc = joc;
    }
    
    
    
}
