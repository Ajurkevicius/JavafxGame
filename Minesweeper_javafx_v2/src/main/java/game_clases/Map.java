package game_clases;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import com.example.minesweeper_javafx_v2.HelloApplication;

import java.util.ArrayList;
import java.util.List;

public class Map {

    EventHandler<MouseEvent> hnd;
    private static final int width=800;
    private static final int height= 600;
    private static final int tile_size=80;
    private static int tiles_x=width/tile_size; //20
    private static int tiles_y=height/tile_size; //15
    private int tiles_count;
    private int bomb_count=0;
    private Tile[][] grid = new Tile[tiles_x][tiles_y];
    private boolean first_move=false;
    private static Map single_instance = null;


    public Parent createMap(){
        Pane root = new Pane();
        root.setPrefSize(width, height);

        for (int y=0; y<tiles_y; y++){
            for(int x=0; x<tiles_x; x++){
                Tile tile= new Tile(x, y,Math.random() < 0.1);
                tile.setOnMouseClicked(hnd);
                grid[x][y]=tile;
                root.getChildren().add(tile);
            }
        }

        countingMapWithBombs();

        return root;
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

    private void countingMapWithBombs(){
        for (int y=0; y<tiles_y; y++){
            for (int x=0; x<tiles_x; x++){
                Tile tile = grid [x][y];

                if(tile.isHasBomb()==true){
                    bomb_count++;
                    continue;
                }
                long bombs = getNeighbours(tile).stream().filter(t -> t.isHasBomb()).count();

                if(bombs> 0) {
                    tile.updateText(String.valueOf(bombs));
                }
            }
        }
        System.out.println("Bomb count: " +bomb_count);
    }

    void tileCount(){
        tiles_count=tiles_x*tiles_y;
    }

    public static Map getInstance()
    {
        if (single_instance == null)
            single_instance = new Map();

        return single_instance;
    }


    void populatehnd(EventHandler<MouseEvent> hnd1){
        hnd = hnd1;
    }

    public int getTiles_count() {
        return tiles_count;
    }

    public void setTiles_count(int tiles_count) {
        this.tiles_count = tiles_count;
    }

    public int getBomb_count() {
        return bomb_count;
    }

    public void setBomb_count(int bomb_count) {
        this.bomb_count = bomb_count;
    }

    public boolean isFirst_move() {
        return first_move;
    }

    public void setFirst_move(boolean first_move) {
        this.first_move = first_move;
    }

    public Tile[][] getGrid() {
        return grid;
    }

    public void setGrid(Tile[][] grid) {
        this.grid = grid;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getTile_size(){
        return tile_size;
    }

    public int getTiles_x(){
        return tile_size;
    }

}
