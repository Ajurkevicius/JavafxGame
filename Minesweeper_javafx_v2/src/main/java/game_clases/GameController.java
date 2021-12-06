package game_clases;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController extends Application {
 private Tile tile;
 //private Map map ;
 private final int a =1;
private Stage initialStage ;
//private Scene scene ;

    public GameController() {
    }

    void gameLogic()
 {
    }

    private boolean gameIsBeingPlayed = true;
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
        Map mape = new Map();
        Scene scene = new Scene(mape.createMap());
        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.show();
*/
        initialStage = primaryStage;
        Map map = new Map();
        Scene scene1 = new Scene(map.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene1);
        initialStage.show();
        System.out.println("scene in game initialization" + scene1);
        System.out.println("STAGE in game initialization " + initialStage);
        newGameInitialization(scene1);

    }
    /*
    void displayApplication() {

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
    void newGameTriggered(boolean gametrigger){
     if(gametrigger == true){
        gameIsBeingPlayed=false;
     }
    }
    */

    void newGameInitialization(Scene scene){
        System.out.println("Code was here in new game initialization");
        Map map = new Map();
        scene.setRoot(map.createMap());

       // initialStage.close();
        /*
        Map map = new Map();
        initialStage = new Stage();
        scene = new Scene(map.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene);
        initialStage.show();
        */
        /*

        System.out.println("scene in NEW " + scene);
        System.out.println("STAGE in NEW " + initialStage);
        scene.setRoot(map.createMap());
        System.out.println("scene in NEW " + scene);
        System.out.println("STAGE in NEW " + initialStage);
        */
      //  scene = new Scene(map.createMap());

      //  initialStage.setScene(new Scene(map.createMap()));
      //  initialStage.show();



       // initialStage.show();
        /*
        scene= new Scene(map.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene);
        initialStage.show();
        */
         /*
       initialStage.close();
        Map mape = new Map();
        Scene scene1 = new Scene(mape.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene1);
        initialStage.show();
        scene1.setRoot(map.createMap());

      */
    }
    public void newTryEMailStage(Stage primaryStage) throws IOException {
        //initialStage = primaryStage;
        //initialStage.setTitle("Minesweeper");
      //  initialStage.setScene(scene);
        //initialStage.show();
       // newGameInitialization();
        /*
        Map mape = new Map();
        scene = new Scene(mape.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene);
        initialStage.show();
         */

    }
    /*
    void listenToClick(int x, int y){
     System.out.println("Click listened");
     Tile tile = map.TileConstructor(x,y);
     map.open(tile);
    }
*/
}
