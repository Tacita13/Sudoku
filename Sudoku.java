/*
This program is designed to solve Sudoku puzzels, using iterative and recursive
methods, as well as backtracking. It then shows the unsolved and solved Sudoku at the end. 
*/
package sudoku;
/**
 *
 * @author Isamar
 */
public class Sudoku {
    
// METHOD #1: Checks if the Sudoku rules are not broken. If so, it returns false.
    static boolean testeFeld(int [][] sudoku, int i, int j, int val) {
// Rows
        for (int c = 0; c < 9; c++){  
            if (val == sudoku[c][j]){
                return false;
            }
        }
// Columns
        for (int c = 0; c < 9; c++){ 
            if (val == sudoku[i][c]){
                return false;
            }
        }
//Blocks
       int bRow = (i / 3)*3, bCol = (j / 3)*3;
        for (int c = 0; c < 3; c++){
            for (int m = 0; m < 3; m++){
                if (val == sudoku[bRow+c][bCol+m]){
                    return false;
                }
            }
        }
        return true;
    }
//METHOD #2: Proceeds to find possible solutions to fill the field, while still valid.
    static boolean loeseFeld(int [][] feld, int i, int j) {
        if (i == 9) {
            i = 0;
            if (++j == 9)
                return true;
        }
        if (feld[i][j] != 0){  //Skips the field because it already has a number
            return loeseFeld(feld, i+1,j);
        }
        for (int val = 1; val <= 9; val++) {
            if (testeFeld(feld, i,j,val)) {
                feld[i][j] = val;
                if (loeseFeld(feld, i+1,j)){
                    return true;
                }
            }
        }
        feld[i][j] = 0; // It resets on backtrack
        return false;
    }
//METHOD #3: Shows the unsolved Sudoku as well as the solved one.
    static void print(int[][] solution) {
        
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0){
                System.out.println(" -----------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0){ 
                    System.out.print("| ");
                }
                System.out.print(solution[i][j] == 0 ? " " : Integer.toString(solution[i][j]));
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
    
//Example and usage of the program in the main.
  public static void main(String[] args) {
    int [][] Sudoku = SudokuProvider.testSudoku;
    System.out.println("Unsolved Sudoku:");
    print(Sudoku);
    if (loeseFeld(Sudoku, 0,0)){
        System.out.println("Yay");
        System.out.println("Solved Sudoku:");
        print(Sudoku);
    }
    else{
       System.out.println("Boooo");  
    System.out.println("Unsolvable Sudoku:");
       print(Sudoku);
    } 
 }
}
