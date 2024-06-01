package com.example.sudoku;

public class SudokuModel {
    private SudokuBoard sudokuBoard;
    private SudokuBoard solvedBoard;
    private int x,y;
    private static SudokuModel instance;
    private boolean fieldState = false;



    public static SudokuModel getInstance() {
        if (instance == null) {
            instance = new SudokuModel();
        }
        return instance;
    }

    public void setLevel(String level) {
        this.solvedBoard = SudokuGenerator2.generateBoard();
        this.sudokuBoard = SudokuGenerator2.sudokuLevelBoard(level, this.solvedBoard);
    }

    public void setDigitBoard(int digit) {
        this.sudokuBoard.setDigit(this.x,this.y,digit);
    }

    public int getDigitBoard(int x, int y) {
        return this.sudokuBoard.getDigit(x,y);
    }

    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkCorrectDigit(int digit) {
        if(solvedBoard.getDigit(this.x, this.y) == digit)
            return true;
        return false;
    }



    public void setFieldState(boolean state) {
        this.fieldState = state;
    }

    public boolean getFieldState() {
        return this.fieldState;
    }
    public SudokuBoard getSudokuBoard() {
        return this.sudokuBoard;
    }

    public SudokuBoard getSolvedBoard() {
        return this.solvedBoard;
    }

    public void setBoards(SudokuBoard sudokuBoard, SudokuBoard solvedBoard) {
        this.sudokuBoard = sudokuBoard;
        this.solvedBoard = solvedBoard;
    }

    public boolean isSolved() {
        if(SudokuSolver.isSolved(sudokuBoard))
            return true;
        return false;
    }

}
