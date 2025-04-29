package sudoku;

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

        System.out.println(difficulty);
        if (difficulty == Difficulty.EASY) {
            missing = 15;
        }else if (difficulty == Difficulty.MEDIUM) {
            missing = 25;
        }else if (difficulty == Difficulty.HARD) {
            missing = 40;
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


    public boolean fillValues(){
        int number;
        for (int row = 0; row < GridConstants.GRID_SIZE; row++) {
            for (int col = 0; col < GridConstants.GRID_SIZE; col++) {
                number = randomGenerator(GridConstants.GRID_SIZE);
                if (isValidPlacement(sudokuBoard,number, row, col)){
                    sudokuBoard[row][col] = number;
                    if (fillValues()){
                        return true;
                    }
                    else {
                        sudokuBoard[row][col] = 0;
                    }
                }
                if (sudokuBoard[row][col] == 0){
                    for (int numberToTry = 1; numberToTry <= GridConstants.GRID_SIZE; numberToTry++) {
                       if (isValidPlacement(sudokuBoard,numberToTry,row,col)){
                           sudokuBoard[row][col] = numberToTry;

                           if (fillValues()){
                               return true;
                           }else {
                               sudokuBoard[row][col] = 0;
                           }
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
            int cellID = randomGenerator(GridConstants.GRID_SIZE*GridConstants.GRID_SIZE)-1;
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
                System.out.print(sudokuBoard[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    int randomGenerator(int size){
        return (int)Math.floor((Math.random() * size+1));
    }

}
