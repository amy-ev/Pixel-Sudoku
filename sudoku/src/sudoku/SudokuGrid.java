package sudoku;

import javax.swing.*;
import java.awt.*;

public class SudokuGrid extends JPanel {
    private Cell[][] cells = new Cell[GridConstants.GRID_SIZE][GridConstants.GRID_SIZE];

    public SudokuGrid() {
        super.setLayout(new GridLayout(GridConstants.GRID_SIZE, GridConstants.GRID_SIZE));

        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                cells[row][col] = new Cell(row, col);
                super.add(cells[row][col]);
            }
        }
        super.setPreferredSize(new Dimension(GridConstants.GRID_WIDTH, GridConstants.GRID_HEIGHT));
    }
}
