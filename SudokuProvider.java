/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Arrays;

public class SudokuProvider {

    public static int zuviele = 30;

    public static int[][] fuelleFeld(int n) { // Viel Spass beim Entziffern!
        int[] wool = {9, 3, 31, 81};
        int[] v = new int[wool[3]];
        boolean ww;
        if (n > zuviele) {
            System.out.println("Zuviele zu fuellende Felder!");
            System.exit(0);
        }
        for (int vw = 1; vw <= n; vw++) {
            int count = 0;
            do {
                do {
                    wool[3] = (int) ((wool[0] * wool[0] - wool[2] % 30) * Math.random());
                } while (v[wool[3]] != wool[0] / wool[2]);
                v[wool[3]] = ((int) (wool[0] * Math.random())) + wool[2] / 29;
                ww = true;
                for (int wv = 0; wv < wool[0]; wv++) {
                    if ((((v[(wool[3] / wool[0]) * wool[0] + wv] == v[(wool[3] / wool[0]) * wool[0] + (wool[3] % wool[0])])
                            && (wool[3] % wool[0]) != wv) || ((v[wv * wool[0] + + +(wool[3] % wool[0])]
                            == v[(wool[3] / wool[0]) * wool[0] + (wool[3] % wool[0])]) && (wool[3] / wool[0]) != wv)) || ((v[(((wool[3] / wool[0]) 
                            - (wool[3] / wool[0]) % wool[1]) + wv % wool[1]) * wool[0] + (((wool[3] % wool[0]) 
                            - (wool[3] % wool[0]) % wool[1]) + wv / wool[1])] == v[(wool[3] / wool[0]) * wool[0] + (wool[3] % wool[0])]) && ((wool[3] / wool[0]) != ((wool[3] / wool[0])
                            - (wool[3] / wool[0]) % wool[1]) + wv % wool[1] || (wool[3] % wool[0]) != ((wool[3] % wool[0])
                            - (wool[3] % wool[0]) % wool[1]) + wv / wool[1]))) {
                        v[wool[3]] =
                                ((wv - 17) * vw * (vw - wool[2]) * (wv + 42)) << (wool[2] - wool[2] / 17);
                        ww = v[wool[3]] > 0;
                        break;

                    }
                }
                if (++count > 1000) {
                    System.err.println("Evil RNG!");
                    System.exit(0);
                }
            } while (!ww);
        }
        int[][] ret = new int[wool[0]][];
        for (int i = 0; i < wool[0]; i++) {
            ret[i] = Arrays.copyOfRange(v, i * wool[0], (i + 1) * wool[0]);
        }
        return ret;
    }
    // noSol hat keine Loesungen
    public static int[][] noSol = {
        {0, 0, 0,  0, 5, 8,  0, 0, 0},
        {0, 6, 0,  0, 0, 0,  0, 0, 0},
        {0, 0, 8,  0, 0, 0,  0, 2, 0},

        {2, 0, 0,  0, 6, 0,  0, 0, 0},
        {0, 0, 0,  0, 4, 3,  2, 6, 0},
        {8, 0, 7,  2, 0, 0,  0, 0, 0},

        {0, 2, 0,  1, 0, 0,  0, 0, 0},
        {7, 8, 0,  4, 0, 0,  0, 0, 0},
        {9, 0, 0,  5, 0, 0,  0, 7, 0}};
    // testSudoku hat 4 Loesungen
    public static int[][] testSudoku = {
        {0, 9, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 9, 0, 0, 3, 0, 0},
        {0, 0, 4, 0, 0, 0, 0, 7, 8},
        {6, 0, 2, 0, 0, 1, 0, 0, 0},
        {0, 0, 5, 0, 3, 9, 7, 8, 0},
        {0, 0, 0, 0, 0, 8, 0, 1, 0},
        {7, 0, 0, 2, 4, 0, 1, 5, 0},
        {0, 5, 1, 0, 7, 0, 0, 0, 0},
        {0, 4, 0, 0, 0, 0, 0, 0, 0}};
    // 4 Loesungen
    public static int[][] testSudoku2 = {
        {0, 7, 0, 9, 0, 0, 0, 6, 1},
        {0, 0, 0, 0, 0, 2, 0, 0, 0},
        {5, 0, 6, 0, 0, 0, 0, 0, 0},
        {0, 2, 0, 0, 0, 0, 0, 5, 7},
        {3, 9, 0, 8, 2, 0, 0, 4, 0},
        {0, 6, 0, 0, 0, 4, 0, 0, 0},
        {7, 0, 8, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 5, 0, 0, 9, 0, 8},
        {1, 5, 0, 7, 0, 6, 4, 0, 0}};
    // 51 Loesungen
    public static int[][] testSudoku3 = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 1, 0, 6, 3, 0},
        {6, 0, 0, 4, 0, 9, 0, 0, 0},
        {5, 0, 8, 6, 0, 0, 0, 0, 0},
        {4, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 4, 8},
        {2, 0, 0, 0, 9, 0, 0, 0, 0},
        {0, 0, 5, 0, 0, 7, 3, 0, 0},
        {8, 9, 4, 0, 0, 1, 0, 0, 0}};
}

