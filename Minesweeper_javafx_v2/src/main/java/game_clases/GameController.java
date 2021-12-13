package game_clases;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController extends Application {
 private Tile tile;
 private Map map ;
 private final int a =1;
private Stage initialStage ;
private Scene scene1 ;

    public GameController() {
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
       // map = new Map();
        map = Map.getInstance();
        map.populatehnd(hnd);
        map.tileCount();
        scene1 = new Scene(map.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene1);
        initialStage.show();
      //  System.out.println("scene in game initialization" + scene1);
      //  System.out.println("STAGE in game initialization " + initialStage);
     //   newGameInitialization(scene1);

    }


    void newGameInitialization(Scene scene){
      //  System.out.println("Code was here in new game initialization");
       // map = new Map();
        map = Map.getInstance();
        map.populatehnd(hnd);
        scene.setRoot(map.createMap());
    }

    EventHandler<MouseEvent> hnd = event -> {
     //   System.out.println("cia buvo kodas, kuris pasieke eventa");
    //    System.out.println(event.getSource());
        Tile tile = (Tile) event.getSource();
      //  System.out.println("x :" + tile.getX());
     //   System.out.println("y :" + tile.getY());
        open(tile);
    };


    public void open(Tile tile){
        if(tile.isOpen()==true){
            return;
        }
        if(tile.isHasBomb()==true && map.isFirst_move()==false){
            System.out.println("You lucky bastard, first move is on us :)");
            map.setFirst_move(true);
            map.setTiles_count(map.getTiles_count()-1);
            map.setBomb_count(map.getBomb_count()-1);
            //first_move=true;
            //tiles_count--;
            //bomb_count--;

        } else if(tile.isHasBomb() == true){
            System.out.println("You lost, play again");
            map.tileCount();
            map.setBomb_count(0);
            map.setFirst_move(false);
            newGameInitialization(scene1);
            /*
            System.out.println("You lost, play again");
            // scene.setRoot(createMap());
            bomb_count=0;
            tiles_count=tiles_x*tiles_y;
            first_move=false;
            //gameController.displayApplication();
            System.out.println("code was here in map tile for new game");
            //gameController.newGameTriggered(true);
            scene = tile.getScene();
            gameController.newGameInitialization(scene);
            //return;

             */
        }
        else if(!tile.isHasBomb()){
            map.setFirst_move(true);
            map.setTiles_count(map.getTiles_count()-1);
//            first_move=true;
  //          tiles_count--;
            System.out.println("TilesCOunt: " + map.getTiles_count());
            tile.setOpen(true);
            tile.visibleTextSetting();
            tile.borderFillNullSetter();
        }
        if(map.getTiles_count()== map.getBomb_count()){
            System.out.println("You won, play again");
            map.tileCount();
            map.setBomb_count(0);
            map.setFirst_move(false);
            newGameInitialization(scene1);
            /*
            System.out.println("You won, play again");
            scene = tile.getScene();
            gameController.newGameInitialization(scene);
        */
        }

        if(tile.getTextInString().isEmpty()){
            // List <Tile> neighboursList = getNeighbours(tile);
            map.getNeighbours(tile).forEach( tile1 -> open(tile1)); // reikia perrasyt

        }
    }


    public void newTryEMailStage(Stage primaryStage) throws IOException {
    }

}
