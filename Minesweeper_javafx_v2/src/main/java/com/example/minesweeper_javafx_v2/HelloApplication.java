package com.example.minesweeper_javafx_v2;

import ds.Mape;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
     //   Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        try {Mape mape = new Mape();
            Scene scene = new Scene(mape.initialiazeMap());
            stage.setTitle("Minesweeper");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {

            // generic exception handling
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}