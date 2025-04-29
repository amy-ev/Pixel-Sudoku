package sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public Main() {

        super.getContentPane().setLayout(new BorderLayout());

        JButton finishedButton =  new JButton("Finished");


        JComboBox<Difficulty> difficulty = new JComboBox<>(Difficulty.values());
        difficulty.setSelectedIndex(0);
        // difficulty.getSelectedItem = NAME
        // difficulty.getSelectedIndex = 0,1,2 ... but enum starts at 1

        SudokuGrid grid = new SudokuGrid();
        grid.newGrid((Difficulty) difficulty.getSelectedItem());

        finishedButton.addActionListener(e -> grid.newGrid((Difficulty) difficulty.getSelectedItem()));
        super.add(difficulty,BorderLayout.NORTH);
        super.add(grid, BorderLayout.CENTER);
        super.add(finishedButton, BorderLayout.SOUTH);

        super.pack();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}