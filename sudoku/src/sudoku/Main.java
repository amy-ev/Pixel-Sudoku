package sudoku;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SudokuGrid grid = new SudokuGrid();
        frame.add(grid);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Main();
    }
}