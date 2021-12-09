package com.example.minesweeper_javafx_v2;

//import ds.Mape;
import game_clases.GameController;
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
    public void start(Stage stage) throws Exception {
       // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("gameEntry.fxml"));
       // Scene scene = new Scene(fxmlLoader.load());
        GameController gameController=new GameController();
        gameController.start(stage);
       /*
        Map mape = new Map();
        Scene scene = new Scene(mape.createMap());
        stage.setTitle("Minesweeper");
        stage.setScene(scene);
        stage.show();
        */
        //gameController.newTryEMailStage(stage);

        /*
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
         */
    }

    /*
    void displayApplication(boolean ending_triggerred) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

     */
//onMousePressedEventHandler
    public static void main(String[] args) {
        launch();
    }
}

