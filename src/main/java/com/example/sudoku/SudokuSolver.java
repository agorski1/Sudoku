package com.example.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuSolver {

    public static boolean isDigitAllowed(int x, int y, SudokuBoard sudokuBoard, int digit){
        if((sudokuBoard.getDigit(x,y) == 0) &&  (!checkInRegion(x,y,sudokuBoard,digit)) && (!checkInVertHor(x,y,sudokuBoard,digit))){
            return true;
        }
        return false;
    }


    private static boolean checkInRegion(int x, int y, SudokuBoard sudokuBoard, int digit) {
        int[][] board = sudokuBoard.getBoard();

        // Oblicz indeks wiersza i kolumny regionu, do którego należy pole (x, y)
        int regionRow = (x / 3) * 3;
        int regionCol = (y / 3) * 3;

        // Sprawdź, czy cyfra digit występuje już w regionie
        for (int i = regionRow; i < regionRow + 3; i++) {
            for (int j = regionCol; j < regionCol + 3; j++) {
                if (board[i][j] == digit) {
                    return true; // Cyfra digit już występuje w regionie
                }
            }
        }
        return false; // Cyfra digit nie występuje jeszcze w regionie
    }


    private static boolean checkInVertHor(int x, int y, SudokuBoard sudokuBoard, int digit) {
        for(int i = 0 ; i < 9 ; i++){
            if((sudokuBoard.getDigit(x,i) == digit) || (sudokuBoard.getDigit(i,y) == digit)){
                return true; // Cyfra digit już występuje w wierszu lub kolumnie
            }
        }
        return false; // Cyfra digit nie występuje jeszcze w wierszu ani kolumnie
    }

    public static int[] availableNumbers(int x, int y, SudokuBoard sudokuBoard) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = 1 ; i <= 9 ; i++) {
            if(isDigitAllowed(x, y, sudokuBoard, i))
                numbers.add(i);
        }

        return setToArray(numbers);
    }

    private static int[] setToArray(Set<Integer> set) {
        int[] result = new int[set.size()];
        int i = 0;
        for (Integer element : set) {
            result[i++] = element;
        }
        return result;
    }

    public static boolean verifyUniqueSolution(SudokuBoard sudokuBoard) {
        for(int x = 0 ; x < 9 ; x++){
            for (int y = 0 ; y < 9 ; y++){
                if(sudokuBoard.getDigit(x,y)==0 && SudokuSolver.availableNumbers(x,y,sudokuBoard).length!=1){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSolved(SudokuBoard sudokuBoard) {
        for(int x = 0 ; x < 9 ; x++){
            for (int y = 0 ; y < 9 ; y++){
                if(sudokuBoard.getDigit(x,y)==0){
                    return false;
                }
            }
        }
        return true;
    }
}
