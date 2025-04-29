package sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sudoku {
    int[][] sudokuBoard = new int[GridConstants.GRID_SIZE][GridConstants.GRID_SIZE];
    int[][] finishedBoard = new int[GridConstants.GRID_SIZE][GridConstants.GRID_SIZE];
    boolean[][] isFilled = new boolean[GridConstants.GRID_SIZE][GridConstants.GRID_SIZE];

    int squareRootGrid;
    int missing;

    public Sudoku() {
        super();
        double SQRGd = Math.sqrt(GridConstants.GRID_SIZE);
        squareRootGrid = (int) SQRGd;
    }

    public void newSudoku(Difficulty difficulty) {

        if (difficulty == Difficulty.EASY) {
            missing = 1;
        }else if (difficulty == Difficulty.MEDIUM) {
            missing = 30;
        }else if (difficulty == Difficulty.HARD) {
            missing = 60;
        }

        for (int i = 0; i < GridConstants.GRID_SIZE; i++) {
            for (int j = 0; j < GridConstants.GRID_SIZE; j++) {
                isFilled[i][j] = true;
            }
        }

        fillValues();
        // save as the finished solution before removing the values
        for (int i = 0; i < GridConstants.GRID_SIZE; i++) {
            System.arraycopy(sudokuBoard[i], 0, finishedBoard[i], 0, GridConstants.GRID_SIZE);
        }
        removeDigits();
        printSudoku();
    }


    public boolean fillValues() {
        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                if (sudokuBoard[row][col] == 0) {

                    List<Integer> numbers = getShuffled();

                    for (int number : numbers) {
                        if (isValidPlacement(sudokuBoard, number, row, col)) {
                            sudokuBoard[row][col] = number;

                            if (fillValues()) {
                                return true;
                            }
                            sudokuBoard[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void removeDigits(){
        int count = missing;
        while (count != 0) {

            int cellID = randomGenerator();
            int row = cellID / GridConstants.GRID_SIZE;
            int col = cellID % GridConstants.GRID_SIZE;
            if (sudokuBoard[row][col] != 0){
                count--;
                sudokuBoard[row][col] = 0;

                isFilled[row][col] = false;
            }
        }
    }

    private boolean isNumberInRow(int[][] sudokuBoard, int answer, int row){
        for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
            if (sudokuBoard[row][col] == answer){
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInColumn(int[][] sudokuBoard, int answer, int col){
        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            if (sudokuBoard[row][col] == answer){
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInGrid(int[][] sudokuBoard, int answer, int row, int col){
        int localGridRow = row-row % GridConstants.SUBGRID_SIZE;
        int localGridCol = col-col % GridConstants.SUBGRID_SIZE;

        for (int i = localGridRow; i < localGridRow + squareRootGrid; i++) {
            for (int j = localGridCol; j < localGridCol + squareRootGrid; j++) {
                if (sudokuBoard[i][j] == answer){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValidPlacement(int[][] sudokuBoard, int answer, int row, int col){
        return !isNumberInRow(sudokuBoard,answer,row)
                && !isNumberInColumn(sudokuBoard,answer,col)
                && !isNumberInGrid(sudokuBoard,answer,row,col);
    }

    public void printSudoku(){
        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                System.out.print(finishedBoard[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    int randomGenerator(){
        return (int)Math.floor((Math.random() * GridConstants.BOARD_SIZE));
    }

    List<Integer> getShuffled(){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= GridConstants.GRID_SIZE; i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }

}
