package com.example.sudoku;

import java.io.*;

public class SaveLoadManager {
    private String filename;
    private SudokuBoard sudokuBoard;
    private SudokuBoard solvedBoard;
    private String fileText;
    private String[] elements;
    private static SaveLoadManager instance;



    public static SaveLoadManager getInstance() {
        if (instance == null) {
            synchronized (SaveLoadManager.class) {
                if (instance == null) {
                    instance = new SaveLoadManager();
                }
            }
        }
        return instance;
    }

    public void setPath(String path) {
        this.filename = path;
    }


    private void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            StringBuilder fileContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append(System.lineSeparator());
            }
            this.fileText = fileContent.toString();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public void load() {
        read();
        String textboard = getFragmentByIndex(0);
        String solvedboard = getFragmentByIndex(1);

        this.sudokuBoard = new SudokuBoard();
        this.solvedBoard = new SudokuBoard();
        sudokuBoard.setBoard(convertTo2DArray(textboard));
        solvedBoard.setBoard(convertTo2DArray(solvedboard));
        SudokuModel sudokuModel = SudokuModel.getInstance();
        sudokuModel.setBoards(sudokuBoard,solvedBoard);


    }

    public void write(SudokuBoard sudokuBoard, SudokuBoard solvedBoard) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            int [][] board = sudokuBoard.getBoard();
            int [][] solved = solvedBoard.getBoard();
            writer.write(convert2DArrayToText(board));
            writer.write("%");
            writer.write(convert2DArrayToText(solved));
            writer.write("%");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String convert2DArrayToText(int[][] array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sb.append(array[i][j]);
                if (j < array[i].length - 1) {
                    sb.append(",");
                }
            }
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public int[][] convertTo2DArray(String text) {
        String[] rows = text.split("\\R");
        int[][] array = new int[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            array[i] = new int[values.length];

            for (int j = 0; j < values.length; j++) {
                array[i][j] = Integer.parseInt(values[j]);
            }
        }

        return array;
    }

    public String getFragmentByIndex(int index) {
        String[] parts = this.fileText.split("%");
        if (index >= 0 && index < parts.length) {
            return parts[index];
        }
        return null;
    }

}
