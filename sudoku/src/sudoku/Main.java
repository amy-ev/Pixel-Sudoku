package sudoku;

import jdk.jfr.Description;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public static TimerLabel timerLabel;
    public Main() {

        super.getContentPane().setLayout(new BorderLayout());

        JButton startButton =  new JButton("Start");
        JButton finishedButton =  new JButton("Finish");
        JButton restartButton =  new JButton("Restart");


        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttonPanel.add(restartButton);
        buttonPanel.add(finishedButton);

        timerLabel = new TimerLabel();

        JPanel menuPanel = new JPanel(new GridLayout(1, 2));
        menuPanel.add(timerLabel);
        menuPanel.add(buttonPanel);

        JComboBox<Difficulty> difficulty = new JComboBox<>(Difficulty.values());
        difficulty.setSelectedIndex(0);

        SudokuGrid grid = new SudokuGrid();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Main.super.add(grid,BorderLayout.CENTER);
                grid.newGrid((Difficulty) difficulty.getSelectedItem());

                Main.super.remove(startButton);
                Main.super.add(menuPanel,BorderLayout.SOUTH);
                Main.super.repaint();
                Main.super.pack();
            }
        });

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.newGrid((Difficulty) difficulty.getSelectedItem());
                timerLabel.resetCountSecs();
                timerLabel.repaint();
            }
        });

        // difficulty.getSelectedItem = NAME
        // difficulty.getSelectedIndex = 0,1,2 ... but enum starts at 1

        finishedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                grid.isFinished();
            }
        });

        //finishedButton.addActionListener(e -> grid.newGrid((Difficulty) difficulty.getSelectedItem()));
        super.add(difficulty,BorderLayout.NORTH);
        super.add(startButton,BorderLayout.SOUTH);
        //super.add(finishedButton, BorderLayout.SOUTH);

        super.pack();
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}