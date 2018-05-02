/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Bernat2
 */
public class Taulell extends JPanel {

    public class Comprobar implements DocumentListener {

        @Override
        public void changedUpdate(DocumentEvent e) {
            comprobarStatus();
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            comprobarStatus();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            comprobarStatus();
        }
    }

    private Joc joc;
    private Casella[][] caselles = new Casella[9][9];

    public Taulell(int[][] sudoku) {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int x = 0; x < caselles.length; x++) {
            for (int y = 0; y < caselles[x].length; y++) {
                c.gridx = x;
                c.gridy = y;
                if (sudoku[x][y] != 0) {
                    CasellaFixa casella = new CasellaFixa(sudoku[x][y]);
                    casella.setTaulell(this);
                    casella.setHorizontalAlignment(JTextField.CENTER);
                    casella.setBackground(Color.magenta);
                    casella.setForeground(Color.white);
                    add(casella, c);
                    caselles[x][y] = casella;
                } else {
                    CasellaVaria casella = new CasellaVaria();
                    casella.getDocument().addDocumentListener(new Comprobar());
                    casella.setHorizontalAlignment(JTextField.CENTER);
                    casella.setBackground(Color.cyan);
                    casella.setForeground(Color.black);
                    add(casella, c);
                    caselles[x][y] = casella;
                }

            }
        }
        bordeSector();

    }

    public Taulell() {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int x = 0; x < caselles.length; x++) {
            for (int y = 0; y < caselles[x].length; y++) {
                c.gridx = x;
                c.gridy = y;
                CasellaFixa casella = new CasellaFixa();
                add(casella, c);
                caselles[x][y] = casella;
            }

        }
    }

    public void bordeSector() {

        Color color = Color.black;
        int n = 2;

        Color color2 = Color.white;
        int m = 2;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color, n));
            }
        }

        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color, n));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color, n));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color, n));
            }
        }

        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color, n));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color2, m));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color2, m));
            }
        }

        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color2, m));
            }
        }

        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                caselles[i][j].setBorder(BorderFactory.createLineBorder(color2, m));
            }
        }

    }

    /**
     * Comprueba los criterios del sudoku en un array. Este método evalua si, un
     * array pasada por parámetros, cumple las reglas del sudoku tales como, Los
     * números introducidos van de 1 a 9, no puede haber ningún número repetido
     * y además la suma de todos es 45. Esta última regla ya viene determinada
     * por las dos primeras pero se ha añadido una comprobación por si acaso.
     *
     * @param array El array de tipo int, tendrá que ser de 9 posiciones
     * @return un int. Devuelve 3 si los números introducidos no están entre 1 y
     * 9, 2 si hay alguno repetido o no suma 45 y 1 si no hay ningúna excepción.
     */
    public int comprobar(int[] array) {

        //comprobar si los numeros son adecuados
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 9 || array[i] < 0) {
                return 3;
            }
        }
        //comprobar si hay alguno repetido y además suman 45

        int suma = 0;
        for (int vuelta = 0; vuelta < array.length; vuelta++) {
            for (int i = 0, cuenta = 0; i < array.length; i++) {

                if (array[i] == vuelta && array[i]!=0) {
                    cuenta++;
                }

                if (cuenta > 1) {
                    return 3;
                }
            }
            suma += array[vuelta];

        }
        if (suma != 45) {
            return 2;
        } else {
            return 1;
        }

    }

    public int recorridoComprobar() {

        int[] array = new int[9];
        int resultado = 1;
        CasellaVaria prueba = new CasellaVaria();

        for (int c = 0; c < 9; c += 3) {
            for (int z = 0; z < 9; z += 3) {
                int w = c;
                if (c == 0) {
                    w = 3;
                }
                for (int x = c, cont = 0; x < w; x++) {
                    for (int y = z; y < w; y++, cont++) {
                        if (caselles[x][y].getText().equals("")) {
                            array[cont] = 0;
                        } else {
                            array[cont] = Integer.parseInt(caselles[x][y].getText());
                        }
                    }
                }
                if (comprobar(array) != 1) {
                    if (resultado != 3) {
                        resultado = (comprobar(array));
                    }
                }
            }
        }

        for (int x = 0; x < caselles.length; x++) {

            for (int y = 0; y < caselles.length; y++) {
                if (caselles[x][y].getText().equals("")) {
                    array[y] = 0;
                } else {
                    array[y] = Integer.parseInt(caselles[x][y].getText());
                }
            }

            if (comprobar(array) != 1) {
                if (resultado != 3) {

                    resultado = (comprobar(array));
                }
            }
        }

        for (int y = 0; y < caselles.length; y++) {

            for (int x = 0; x < caselles.length; x++) {
                if (caselles[x][y].getText().equals("")) {
                    array[y] = 0;
                } else {
                    array[y] = Integer.parseInt(caselles[x][y].getText());
                }
            }
        }

        if (comprobar(array) != 1) {
            if (resultado != 3) {

                resultado = (comprobar(array));
            }
        }

        return resultado;

    }

    public void comprobarStatus() {
        int n = recorridoComprobar();
        switch (n) {
            case 1:
                getJoc().getSemaforo().setStatus(n);
                getJoc().getCrono().getTim().stop();
                for (int i = 0; i < caselles.length; i++) {
                    for (int j = 0; j < caselles[i].length; j++) {
                        caselles[i][j].setEditable(false);
                        caselles[i][j].setBackground(Color.white);
                    }
                }
                break;
            case 2:
                getJoc().getSemaforo().setStatus(n);
                break;
            case 3:
                getJoc().getSemaforo().setStatus(n);
                break;
        }

    }

    public Joc getJoc() {
        return joc;
    }

    public void setJoc(Joc joc) {
        this.joc = joc;
    }

    public Casella[][] getCaselles() {
        return caselles;
    }

    public void setCaselles(Casella[][] caselles) {
        this.caselles = caselles;
    }

}
