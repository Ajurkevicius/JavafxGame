package com.example.minesweeper_javafx_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void startGameButtonClicked(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signup-form.fxml"));
        Parent root = fxmlLoader.load();


        Scene scene = new Scene(root);

        Stage stage = (Stage) welcomeText.getScene().getWindow();

        stage.setTitle("Main window");
        stage.setScene(scene);
        stage.show();
    }
}