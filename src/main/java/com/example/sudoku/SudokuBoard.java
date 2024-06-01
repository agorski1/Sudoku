package com.example.sudoku;


public class SudokuBoard {
    private int[][] board;


    public SudokuBoard() {
        this.board = new int[9][9];
    }


    public void setDigit(int x, int y, int digit) {
        this.board[x][y] = digit;
    }
    public int getDigit(int x, int y) {
        return this.board[x][y];
    }

    public void setBoard(int[][] board){
        this.board = board;
    }

    public int[][] getBoard() {
        return this.board;
    }
    public void clearBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void copy(SudokuBoard board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                setDigit(i, j, board.getDigit(i, j));
            }
        }
    }

    public  void printArray() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
