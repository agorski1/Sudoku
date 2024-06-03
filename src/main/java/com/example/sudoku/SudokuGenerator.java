package com.example.sudoku;

import java.util.Random;


public class SudokuGenerator {

    public static SudokuBoard sudokuLevelBoard(String level){
        SudokuBoard levelBoard = new SudokuBoard();
        switch(level) {
            case "easy":
                levelBoard = generateBoard(40);
                break;
            case "medium":
                levelBoard = generateBoard(30);
                break;
            case "hard":
                levelBoard = generateBoard(20);
                break;
            default:
                // code block
        }
        return levelBoard;
    }

    private static SudokuBoard generateBoard(int numberPols){
        SudokuBoard genBoard = new SudokuBoard();
        int randX, randY, randDigit, counter = 0;

        Random rand = new Random();

        while (counter<numberPols){
            randX = rand.nextInt(9);
            randY = rand.nextInt(9);
            randDigit = rand.nextInt(9)+1;

            if(SudokuSolver.isDigitAllowed(randX,randY,genBoard,randDigit)){
                counter++;
                genBoard.setDigit(randX,randY,randDigit);
            }
        }
        return genBoard;
    }
}

