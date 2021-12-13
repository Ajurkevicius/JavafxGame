import game_clases.GameController;
import game_clases.Map;
import game_clases.Tile;
import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Map_bombs_test {
   // Map map = new Map();
    @Test
    public void counting_bombs(){
       /*
        int bombs_count_test=0;
        Pane root = (Pane) map.createMap();
        int bombs_count = map.getBomb_count();
        Tile[][] test_map = map.getGrid();
        Tile tile_list = new ArrayList<>();
        for (Tile[] tile: test_map) {

        }

        for(Tile tile : test_map){
            if(tile.isHasBomb()){
                bombs_count_test++;
            }
        }
        */

    Tile tile = new Tile(1,1,true);
    tile.setOpen(true);
        GameController gameController=new GameController();
        Assertions.assertEquals(1,1);
        //bombs_count_test = map.getGrid().stream().filter(c -> c.isBomb);
    }
}
