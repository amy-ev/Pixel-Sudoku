package main.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SudokuGrid extends JPanel {
    private final Cell[][] cells = new Cell[GridConstants.GRID_SIZE][GridConstants.GRID_SIZE];
    private final Sudoku sudoku = new Sudoku();

    public SudokuGrid() {
        super.setLayout(new GridLayout(GridConstants.GRID_SIZE, GridConstants.GRID_SIZE));

        CellInputListener listener = new CellInputListener();

        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);
                if (cells[row][col].isEditable()) {
                    cells[row][col].addActionListener(listener);
                }
            }
        }
        super.setPreferredSize(new Dimension(GridConstants.GRID_WIDTH, GridConstants.GRID_HEIGHT));
    }

    public void newGrid(Difficulty difficulty) {
        sudoku.newSudoku(difficulty);
        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                cells[row][col].newGrid(sudoku.sudokuBoard[row][col],sudoku.isFilled[row][col]);

            }
        }
    }

    public void isFinished(){
        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                if (cells[row][col].state == CellState.EMPTY || cells[row][col].state == CellState.INCORRECT) {
                    return;
                }
            }
        }
        End end = new End();
    }

    private class CellInputListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Cell eCell = (Cell) e.getSource();
            try {
                int answer = Integer.parseInt(eCell.getText());

                if (answer == sudoku.finishedBoard[eCell.row][eCell.col]){
                    eCell.state = CellState.CORRECT;
                }else{
                    eCell.state = CellState.INCORRECT;
                }
                eCell.paint();

            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        }
    }
}
