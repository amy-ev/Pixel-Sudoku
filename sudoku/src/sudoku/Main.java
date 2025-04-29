package sudoku;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public Main() {

        super.getContentPane().setLayout(new BorderLayout());


        JComboBox<Difficulty> difficulty = new JComboBox<>(Difficulty.values());
        difficulty.setSelectedIndex(2);
        // difficulty.getSelectedItem = NAME
        // difficulty.getSelectedIndex = 0,1,2 ... but enum starts at 1
       //System.out.println(difficulty.getSelectedItem());
        SudokuGrid grid = new SudokuGrid();
        grid.newGrid((Difficulty) difficulty.getSelectedItem());


        super.add(difficulty,BorderLayout.NORTH);
        super.add(grid, BorderLayout.CENTER);
        super.pack();

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}