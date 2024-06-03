package com.example.sudoku;

import java.util.Random;

public class SudokuGenerator2 {
    public static SudokuBoard generateBoard() {

        SudokuBoard sudokuBoard = new SudokuBoard();
        Random random = new Random();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int[] availableNumbers = SudokuSolver.availableNumbers(x, y, sudokuBoard);
                if (availableNumbers.length != 0) {
                    sudokuBoard.setDigit(x, y, availableNumbers[random.nextInt(availableNumbers.length)]);
                } else {
                    x = 0;
                    y = -1;
                    sudokuBoard.clearBoard();
                }
            }
        }
        return sudokuBoard;
    }

    public static SudokuBoard sudokuLevelBoard(String level, SudokuBoard solvedBoard){
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.copy(solvedBoard);
        switch(level) {
            case "easy":
                clearFileds(sudokuBoard,40);
                break;
            case "medium":
                clearFileds(sudokuBoard,50);
                break;
            case "hard":
                clearFileds(sudokuBoard,60);
                break;
            default:
                // code block
        }
        return sudokuBoard;
    }

    private static void clearFileds(SudokuBoard sudokuBoard, int number) {
        Random random = new Random();
        SudokuBoard tempBoard = new SudokuBoard();
        tempBoard.copy(sudokuBoard);
        int randX, randY, counter = 0;
        while (counter < number && SudokuSolver.verifyUniqueSolution(tempBoard)) {
            randX = random.nextInt(9);
            randY = random.nextInt(9);
            if (sudokuBoard.getDigit(randX, randY) != 0) {
                sudokuBoard.setDigit(randX, randY, 0);
                counter++;
            }
            if (!SudokuSolver.verifyUniqueSolution(tempBoard)) {
                tempBoard.copy(sudokuBoard);
                counter = 0;
            }
        }
    }
}
