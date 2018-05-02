/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;


/**
 *
 * @author Bernat2
 */
public class Casella extends JTextField{
    public Casella(){
        setPreferredSize(new Dimension(40, 40));
        Font fuente = new Font("fuente",Font.BOLD, 30);
        setFont(fuente);
    }
}
