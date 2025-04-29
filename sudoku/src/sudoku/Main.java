package sudoku;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        Sudoku sudoku = new Sudoku();
        sudoku.newSudoku(Difficulty.EASY);
    }
    public static void main(String[] args) {
        new Main();
    }
}