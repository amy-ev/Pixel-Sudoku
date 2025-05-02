package main.sudoku;

import javax.swing.*;
import java.awt.*;

public class Cell extends JTextField {
    int row,col;
    int c_row, c_col;
    int answer;
    CellState state;

    // pre-filled cell values
    public static final Color BG_FILLED = Color.WHITE;
    public static final Color FG_FILLED = Color.BLACK;

    // empty cells
    public static final Color BG_EMPTY = Color.WHITE;
    public static final Color FG_EMPTY = Color.GRAY;

    // to use when the correct/incorrect value has been inputted
    // may remove in favour for end of game check
    public static final Color FG_CORRECT = new Color(0,153,0);   //new Color(144,223,144);
    //public static final Color FG_CORRECT = Color.BLACK;
    public static final Color FG_INCORRECT = Color.RED;

    // to be changed
    // constructor
    public Cell(int row, int col){
        super();
        this.row = row;
        this.col = col;
        c_row = row +=1;
        c_col = col +=1;

        super.setHorizontalAlignment(JTextField.CENTER);
    }

    public void newGrid(int answer, boolean isFilled){
        this.answer = answer;
        // if isFilled = true, then CellState is .FILLED, otherwise .EMPTY
        state = isFilled ? CellState.FILLED : CellState.EMPTY;
        paint();
    }

    public void paint(){
        if (c_row % 3 == 0){
            setBorder(BorderFactory.createMatteBorder(0,0,2,1,Color.BLACK));
            if (c_col == 1){
                setBorder(BorderFactory.createMatteBorder(0,2,2,1,Color.BLACK));
            }
        } else if (c_col % 3 == 0)  {
            setBorder(BorderFactory.createMatteBorder(0,0,1,2,Color.BLACK));
            if (c_row == 1){
                setBorder(BorderFactory.createMatteBorder(2,0,1,2,Color.BLACK));
            }
        } else if (c_col == 1) {
            setBorder(BorderFactory.createMatteBorder(0, 2, 1, 1, Color.BLACK));
            // for the top left-hand cell
            if (c_row == 1){
                setBorder(BorderFactory.createMatteBorder(2,2,1,1,Color.BLACK));
            }
        } else if (c_row == 1) {
            setBorder(BorderFactory.createMatteBorder(2, 0, 1, 1, Color.BLACK));

        } else{
            setBorder(BorderFactory.createMatteBorder(0,0,1,1,Color.BLACK));
        }
        // for each 3x3 corner
        if (c_row % 3 == 0 && c_col % 3 == 0){
            setBorder(BorderFactory.createMatteBorder(0,0,2,2,Color.BLACK));
        }

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
            //setBackground(BG_CORRECT);
            setForeground(FG_CORRECT);
            super.setEditable(false);

        } else if (state == CellState.INCORRECT) {
            setForeground(FG_INCORRECT);
        }
    }
}
