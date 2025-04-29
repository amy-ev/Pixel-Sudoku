package sudoku;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SudokuGrid grid = new SudokuGrid();
        grid.newGrid();
        super.add(grid);
        super.pack();
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}