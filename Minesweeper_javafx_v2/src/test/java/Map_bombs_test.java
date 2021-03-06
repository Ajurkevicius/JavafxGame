import game_clases.GameController;
import game_clases.Map;
import game_clases.Tile;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import game_clases.*;

import java.util.ArrayList;


public class Map_bombs_test {
   // Map map = new Map();
   final int width=800;
    final int height= 600;
    final int tile_size=80;
    int tiles_x=width/tile_size; //20
    int tiles_y=height/tile_size; //15
    int tiles_count;
    int bomb_count=0;
    Tile[][] grid = new Tile[tiles_x][tiles_y];

    @Test
    public void counting_bombs(){


        settingBombs();
        countingMapWithBombs();


        Assertions.assertEquals(0,bomb_count);



    }

    private void settingBombs(){
        for (int y=0; y<tiles_y; y++){
            for(int x=0; x<tiles_x; x++){
                Tile tile= new Tile(x, y,false);
                //tile.setOnMouseClicked(hnd);
                grid[x][y]=tile;
                // root.getChildren().add(tile);
            }
        }
    }

    private void countingMapWithBombs(){
        for (int y=0; y<tiles_y; y++){
            for (int x=0; x<tiles_x; x++){
                Tile tile = grid [x][y];

                if(tile.isHasBomb()==true){
                    bomb_count++;
                    continue;
                }

            }
        }
        System.out.println("Bomb count: " +bomb_count);
    }
}
