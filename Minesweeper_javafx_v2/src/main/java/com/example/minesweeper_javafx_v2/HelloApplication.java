package com.example.minesweeper_javafx_v2;

//import ds.Mape;
import game_clases.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
     //   Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Platform.setImplicitExit(false);

        try {
                Map mape = new Map();
                Scene scene = new Scene(mape.createMap());
                stage.setTitle("Minesweeper");
                stage.setScene(scene);
                stage.show();

        } catch (Exception e) {

            // generic exception handling
            e.printStackTrace();
        }

    }
//onMousePressedEventHandler
    public static void main(String[] args) {
        launch();
    }
}

