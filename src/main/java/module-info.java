module com.example.sudoku {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.sudoku to javafx.fxml;
    exports com.example.sudoku;
}