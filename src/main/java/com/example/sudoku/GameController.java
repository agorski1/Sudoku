package com.example.sudoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;
    @FXML
    private Button back;

    @FXML Label info;

    @FXML
    private GridPane gridPane;

    private SudokuModel boardModel = SudokuModel.getInstance();

    private Label fieldChecked;



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        gridPane.setGridLinesVisible(true);
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                if(boardModel.getDigitBoard(i,j)!=0){
                    Label label = (Label) gridPane.lookup("#lab"+i+j);
                    label.setText(String.valueOf(boardModel.getDigitBoard(i,j)));
                }
            }
        }
    }

    @FXML
    public void save(ActionEvent event) throws IOException {
        SaveLoadManager save = SaveLoadManager.getInstance();
        save.write(boardModel.getSudokuBoard(),boardModel.getSolvedBoard());
    }

    @FXML
    public void handleMouseClick(MouseEvent event) {
        Label clickedLabel = (Label) event.getSource();
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                if (clickedLabel.getId().equals("lab"+i+j) && boardModel.getDigitBoard(i,j)==0) {
                    this.fieldChecked = clickedLabel;
                    boardModel.setFieldState(true);
                    info.setText("");
                    boardModel.setCoords(i,j);
                }
                else if(clickedLabel.getId().equals("lab"+i+j) && boardModel.getDigitBoard(i,j)!=0) {
                    info.setText("Field is already correctly filled");
                    boardModel.setFieldState(false);
                }
            }
        }
    }

    @FXML
    public void handleButtonBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleButtonClick(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if(boardModel.getFieldState()){
            switch (clickedButton.getId()) {
                case "button1":
                    if(boardModel.checkCorrectDigit(1)) {
                        this.boardModel.setDigitBoard(1);
                        this.fieldChecked.setText("1");}
                    else {info.setText("Incorrect digit");}

                    break;
                case "button2":
                    if(boardModel.checkCorrectDigit(2)) {
                        this.boardModel.setDigitBoard(2);
                        this.fieldChecked.setText("2");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button3":
                    if(boardModel.checkCorrectDigit(3)) {
                        this.boardModel.setDigitBoard(3);
                        this.fieldChecked.setText("3");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button4":
                    if(boardModel.checkCorrectDigit(4)) {
                        this.boardModel.setDigitBoard(4);
                        this.fieldChecked.setText("4");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button5":
                    if(boardModel.checkCorrectDigit(5)) {
                        this.boardModel.setDigitBoard(5);
                        this.fieldChecked.setText("5");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button6":
                    if(boardModel.checkCorrectDigit(6)) {
                        this.boardModel.setDigitBoard(6);
                        this.fieldChecked.setText("6");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button7":
                    if(boardModel.checkCorrectDigit(7)) {
                        this.boardModel.setDigitBoard(7);
                        this.fieldChecked.setText("7");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button8":
                    if(boardModel.checkCorrectDigit(8)) {
                        this.boardModel.setDigitBoard(8);
                        this.fieldChecked.setText("8");}
                    else {info.setText("Incorrect digit");}
                    break;
                case "button9":
                    if(boardModel.checkCorrectDigit(9)) {
                        this.boardModel.setDigitBoard(9);
                        this.fieldChecked.setText("9");}
                    else {info.setText("Incorrect digit");}
                    break;
                default:
                    break;
            }
        }
        setWinScene(boardModel.isSolved());
        boardModel.setFieldState(false);
    }

    @FXML
    public void setWinScene(boolean isSolved) {
        if (isSolved) {
            try {
                root = FXMLLoader.load(getClass().getResource("win.fxml"));
                Stage stage = (Stage) anchorPane.getScene().getWindow();
                Scene newScene = new Scene(root);
                stage.setScene(newScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
