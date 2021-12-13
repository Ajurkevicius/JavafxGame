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

        initialStage = primaryStage;
        map = Map.getInstance();
        map.populatehnd(hnd);
        map.tileCount();
        scene1 = new Scene(map.createMap());
        initialStage.setTitle("Minesweeper");
        initialStage.setScene(scene1);
        initialStage.show();

    }


    void newGameInitialization(Scene scene){
        map = Map.getInstance();
        map.populatehnd(hnd);
        scene.setRoot(map.createMap());
    }

    EventHandler<MouseEvent> hnd = event -> {
        Tile tile = (Tile) event.getSource();
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


        } else if(tile.isHasBomb() == true){
            System.out.println("You lost, play again");
            map.tileCount();
            map.setBomb_count(0);
            map.setFirst_move(false);
            newGameInitialization(scene1);
        }
        else if(!tile.isHasBomb()){
            map.setFirst_move(true);
            map.setTiles_count(map.getTiles_count()-1);
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
        }

        if(tile.getTextInString().isEmpty()){
            map.getNeighbours(tile).forEach( tile1 -> open(tile1));

        }
    }


}
