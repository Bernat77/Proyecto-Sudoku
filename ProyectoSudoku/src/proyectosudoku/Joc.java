/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Bernat2
 */
public class Joc {

    private Semafor semaforo;
    private Cronometre crono;
    private Taulell taulell;
    private JFrame ventana;
    private ArrayList<Boton> botones;

    public Joc() {
        this.taulell = new Taulell();
        taulell.setJoc(this);
        this.semaforo = new Semafor();
        semaforo.setJoc(this);
        this.crono = new Cronometre();
        crono.setJoc(this);
        crono.setText("00:00:00");
        this.botones = new ArrayList<Boton>();

        //ventana
        ventana = new JFrame("Sudoku v1.1");
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(920, 750);
        Container cp = ventana.getContentPane();
        cp.setLayout(new FlowLayout());

        GridBagConstraints f = new GridBagConstraints();

        //
        JLabel main = new JLabel(new ImageIcon("img/fondo.jpg"));
        main.setLayout(new GridBagLayout());

        f.insets = new Insets(0, 0, 0, 0);
        f.gridy = 0;
        f.gridx = 0;
        main.add(panel1(), f);
        f.gridx = 1;
        main.add(panel2(), f);
        cp.add(main);
        ventana.setVisible(true);

    }

    public static void main(String[] args) {

        new Joc();

    }

    public JPanel panel1() {

        JPanel frame = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setBackground(new Color(0, 0, 0, 0));
        //c.weightx = 1;
        //c.weighty = 1;
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.insets = new Insets(0, 30, 0, 0);

        //cronometro
        crono.setPreferredSize(new Dimension(180, 40));
        crono.setHorizontalAlignment(JTextField.CENTER);
        frame.add(crono, c);

        //taulell 
        c.insets = new Insets(40, 40, 0, 0);
        c.gridheight = 3;
        c.gridy = 1;
        frame.add(taulell, c);

        //semafur
        c.insets = new Insets(60, 30, 0, 0);
        c.gridy = 4;
        frame.add(semaforo, c);

        return frame;
    }

    public JPanel panel2() {

        JPanel frame = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        frame.setBackground(new Color(0, 0, 0, 0));

        c.insets = new Insets(0, 80, 30, 0);

        //logo
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.gridheight = 3;

        JLabel logo = new JLabel(new ImageIcon("img/logo.png"));
        frame.add(logo, c);

        //botones
        Font fuente = new Font("fuentebot", Font.BOLD, 18);
        c.insets = new Insets(20, 50, 0, 0);
        c.gridheight = 1;
        c.gridy = 3;
        Boton boton1 = crearBoton("Nueva partida");
        boton1.setAccion(1);
        boton1.setPreferredSize(new Dimension(300, 50));
        boton1.setFont(fuente);
        frame.add(boton1, c);

        c.insets = new Insets(30, 115, 0, 0);
        c.gridy = 4;
        c.gridwidth = 1;
        Boton boton2 = crearBoton("Reiniciar");
        boton2.setAccion(4);
        boton2.setPreferredSize(new Dimension(130, 50));
        boton2.setFont(fuente);
        frame.add(boton2, c);

        c.insets = new Insets(30, 0, 0, 20);
        c.gridx = 1;

        Boton boton3 = crearBoton("Salir");
        boton3.setAccion(3);
        boton3.setPreferredSize(new Dimension(130, 50));
        boton3.setFont(fuente);
        frame.add(boton3, c);
        
        c.insets = new Insets(60, 20, 0, 0);
        c.gridy=5;
        c.gridx=1;
        Font fcopy = new Font("fuentecop", Font.ITALIC, 12);
        JLabel copyright= new JLabel("© Bernat Salleras,2018");
        copyright.setFont(fcopy);
        copyright.setForeground(Color.white);
        frame.add(copyright,c);
                

        return frame;
    }

    public void nuevoTaulell() {

        //obtengo el panel donde tengo los elementos
        Container cp = ventana.getContentPane();
        JLabel cp2 = (JLabel) cp.getComponent(0);
        JPanel panel = (JPanel) cp2.getComponent(0);
        panel.remove(this.taulell);

        //creo taulell y setteo la relacion estructural
        int[][] sudoku = getArraySudoku(taulell.getCaselles());
        Taulell taulell = new Taulell(new Sudoku().getSudokuRandom(sudoku));
        setTaulell(taulell);
        taulell.setJoc(this);

        //preparo las constraints
        GridBagConstraints c = new GridBagConstraints();
        c.gridheight = 3;
        c.gridy = 1;
        c.gridx = 0;
        c.insets = new Insets(40, 40, 0, 0);

        // añado el panel
        panel.add(taulell, c);

        // actualizo el jframe
        ventana.revalidate();
        ventana.repaint();

    }

    public int[][] getArraySudoku(Casella[][] a) {
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] instanceof CasellaFixa) {
                    if (a[i][j].getText().equals("")) {
                        sudoku[i][j] = 0;
                    } else {
                        sudoku[i][j] = Integer.parseInt(a[i][j].getText());
                    }
                }
            }
        }

        return sudoku;

    }


    public Boton crearBoton(String texto) {
        Boton boton = new Boton(texto);
        boton.setJoc(this);
        botones.add(boton);
        return boton;
    }

    public Semafor getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(Semafor semaforo) {
        this.semaforo = semaforo;
    }

    public Cronometre getCrono() {
        return crono;
    }

    public void setCrono(Cronometre crono) {
        this.crono = crono;
    }

    public Taulell getTaulell() {
        return taulell;
    }

    public void setTaulell(Taulell taulell) {
        this.taulell = taulell;
    }

    public JFrame getVentana() {
        return ventana;
    }

    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

}
