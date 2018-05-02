/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosudoku;

import java.util.*;

/**
 *
 * @author Bernat2
 */
public class Sudoku {

    private ArrayList<int[][]> sudokus;
    private int[] tuputamadre = {1, 2, 3};

    public Sudoku() {
        sudokus = new ArrayList<int[][]>();
        int[][] sudokubeta = new int[][]{{5, 7, 6, 8, 1, 2, 3, 0, 4}, {0, 1, 4, 7, 5, 3, 6, 8, 2}, {3, 2, 8, 0, 4, 6, 7, 1, 5}, {6, 9, 3, 2, 8, 7, 5, 4, 1}, {2, 5, 1, 4, 6, 0, 8, 3, 7}, {4, 8, 7, 5, 3, 1, 9, 2, 6}, {1, 3, 5, 6, 0, 4, 2, 7, 8}, {7, 6, 0, 1, 2, 8, 4, 5, 3}, {8, 4, 2, 3, 7, 5, 1, 6, 0}};

        int[][] sudoku1 = new int[][]{{0, 0, 6, 0, 0, 2, 3, 0, 4}, {9, 0, 4, 7, 5, 0, 0, 8, 2}, {0, 0, 8, 0, 0, 6, 0, 0, 5}, {0, 0, 3, 0, 0, 0, 0, 4, 0}, {2, 0, 0, 4, 0, 0, 8, 3, 0}, {4, 0, 7, 5, 0, 0, 0, 0, 0}, {0, 0, 0, 6, 0, 0, 0, 0, 8}, {7, 0, 0, 0, 2, 0, 4, 5, 3}, {0, 0, 0, 3, 7, 0, 0, 6, 9}};

        int[][] sudoku2 = new int[][]{{0, 0, 2, 8, 0, 0, 0, 7, 0}, {6, 0, 9, 0, 7, 4, 0, 2, 3}, {4, 0, 8, 0, 0, 3, 0, 5, 0}, {0, 0, 5, 0, 8, 0, 0, 3, 0}, {0, 0, 0, 0, 0, 0, 7, 4, 0}, {0, 2, 7, 0, 3, 0, 0, 8, 5}, {0, 0, 0, 3, 6, 0, 0, 0, 0}, {0, 0, 0, 5, 1, 7, 4, 0, 8}, {0, 0, 0, 2, 0, 8, 0, 9, 0}};

        sudokus.add(sudokubeta);
        sudokus.add(sudoku1);
        sudokus.add(sudoku2);
        //      sudokus.add(sudoku3);
        //      sudokus.add(sudoku4);
        //      sudokus.add(sudoku5);

    }

    public ArrayList<int[][]> getSudokus() {
        return sudokus;
    }

    public int[][] getSudokuRandom(int[][] sudokuactual) {

        int random;
        boolean sw = true;

        do {

            random = (int) (Math.random() * (sudokus.size()));
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (sudokuactual[i][j] != sudokus.get(random)[i][j]) {
                        sw = false;
                    }
                }
            }
        } while (sw == true);
        return sudokus.get(random);

    }

}
