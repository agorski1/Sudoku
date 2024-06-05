package com.example.sudoku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SaveController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane background;

    private String saveDir = System.getProperty("user.home") + "/SudokuSaves/";

    @FXML
    public void initialize() {
        Path dirPath = Paths.get(saveDir);
        try {
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 3; i++) {
            Button button = (Button) background.lookup("#slot" + i);
            String filePath = saveDir + "save" + i + ".csv";

            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                button.setText("Used");
            } else {
                button.setText("Empty slot");
            }
        }
    }

    @FXML
    public void saveSlot1(ActionEvent event) throws IOException {
        SaveLoadManager save = SaveLoadManager.getInstance();
        String filePath = saveDir + "save1.csv";
        save.setPath(filePath);
        root = FXMLLoader.load(getClass().getResource("level.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void saveSlot2(ActionEvent event) throws IOException {
        SaveLoadManager save = SaveLoadManager.getInstance();
        String filePath = saveDir + "save2.csv";
        save.setPath(filePath);
        root = FXMLLoader.load(getClass().getResource("level.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void saveSlot3(ActionEvent event) throws IOException {
        SaveLoadManager save = SaveLoadManager.getInstance();
        String filePath = saveDir + "save3.csv";
        save.setPath(filePath);
        root = FXMLLoader.load(getClass().getResource("level.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}