module com.example.minesweeper_javafx_v2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.minesweeper_javafx_v2 to javafx.fxml;
    exports com.example.minesweeper_javafx_v2;
   // exports game_clases to  javafx.graphics;
    exports game_clases;
}