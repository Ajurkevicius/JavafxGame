import game_clases.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class neighboursTest {

    final int width=800;
    final int height= 600;
    final int tile_size=80;
    int tiles_x=width/tile_size; //20
    int tiles_y=height/tile_size; //15
    int tiles_count;
    int bomb_count=0;
    Tile[][] grid = new Tile[tiles_x][tiles_y];

    @Test
    void neighboursTestResult(){

        settingBombs();
        countingMapWithBombs();
        Tile tile = grid[4][4];
        List<Tile> tilesToTest=getNeighbours(tile);

        Assertions.assertEquals(8,tilesToTest.size());

    }

    private void settingBombs(){
        for (int y=0; y<tiles_y; y++){
            for(int x=0; x<tiles_x; x++){
                Tile tile= new Tile(x, y,false);
                //tile.setOnMouseClicked(hnd);
                if(x==4 && y ==4){
                    tile.setHasBomb(true);
                }
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

    public List<Tile> getNeighbours(Tile tile) {
        List<Tile> neighbours = new ArrayList<>();

        int[] points = new int[]{
                -1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1
        };
        for (int i = 0; i < points.length; i = i + 2) {
            int dx = points[i];
            int dy = points[i + 1];
            int newX = tile.getX()+dx;
            int newY = tile.getY()+dy;
            if (newX >= 0 && newX < tiles_x &&
                    newY >= 0 && newY < tiles_y) {
                neighbours.add(grid[newX][newY]);
            }

        }
        return neighbours;
    }

}
