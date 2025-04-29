package sudoku;

import javax.swing.*;
import java.awt.*;

public class Cell extends JTextField {
    int row,col;
    int answer;
    CellState state;

    // pre-filled cell values
    public static final Color BG_FILLED = Color.WHITE;
    public static final Color FG_FILLED = Color.BLACK;

    // empty cells
    public static final Color BG_EMPTY = Color.LIGHT_GRAY;
    public static final Color FG_EMPTY = Color.GRAY;

    // to use when the correct/incorrect value has been inputted
    // may remove in favour for end of game check
    public static final Color BG_CORRECT = Color.GREEN;
    public static final Color BG_INCORRECT = Color.RED;

    // to be changed
    public static final Font FONT = new Font("SansSerif", Font.PLAIN, 12);

    // constructor
    public Cell(int row, int col){
        super();
        this.row = row;
        this.col = col;

        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT);
    }

    public void newGrid(int answer, boolean isFilled){
        this.answer = answer;
        // if isFilled = true, then CellState is .FILLED, otherwise .EMPTY
        state = isFilled ? CellState.FILLED : CellState.EMPTY;
        paint();
    }

    public void paint(){
        if (state == CellState.EMPTY){
            super.setText("");
            super.setEditable(true);
            setBackground(BG_EMPTY);
            setForeground(FG_EMPTY);

        } else if (state == CellState.FILLED) {
            super.setText(answer + "");
            super.setEditable(false);
            setBackground(BG_FILLED);
            setForeground(FG_FILLED);

        } else if (state == CellState.CORRECT) {
            setBackground(BG_CORRECT);

        } else if (state == CellState.INCORRECT) {
            setBackground(BG_INCORRECT);
        }
    }
}
