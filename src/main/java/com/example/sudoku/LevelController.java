package com.example.sudoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LevelController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void easyLevel(ActionEvent event) throws IOException{
        SudokuModel sudokuModel = SudokuModel.getInstance();
        sudokuModel.setLevel("easy");
        root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void mediumLevel(ActionEvent event) throws IOException{
        SudokuModel sudokuModel = SudokuModel.getInstance();
        sudokuModel.setLevel("medium");
        root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void hardLevel(ActionEvent event) throws IOException{
        SudokuModel sudokuModel = SudokuModel.getInstance();
        sudokuModel.setLevel("hard");
        root = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("slottosave.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}