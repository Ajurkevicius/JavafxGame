package ds;
import ds.Box;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Mape {

    private int height = 600;
    private int width =800;
    public int boxSize1 = 40;

    private int field_x= width/boxSize1;
    private int field_y= height/boxSize1;
    Box [][] field = new Box[field_x][field_y];
   //gal ir public reikia sitam kintamajam

    //GameController controller1 = new GameController();

    public Mape() {
    }

    public Parent initialiazeMap() {
        Pane root = new Pane();
        Mape firstMap = new Mape();
        root.setPrefSize(width,height); // setinam mapo dydi

        for(int y=0; y<field_y; y++){
            for( int x=0; x<field_x;x++){
                Box individualBox= new Box(x,y,Math.random()<0.1); // setinam bombas
                field[x][y]=individualBox;
                root.getChildren().add(individualBox);
            }
        }

        GameController controller1 = new GameController();

        for (int y=0; y<field_y; y++){
            for (int x=0; x<field_x; x++){
                Box individualBox = field [x][y];

                Boolean is_Bomb= individualBox.getisBomb();
                if(is_Bomb==true){
                    continue;
                }
                //
                    long bombs = getNeighbours(individualBox).stream().filter(t -> t.getisBomb()).count();
                // long bombs = controller1.getNeighbours(individualBox).forEach(t -> t.getisBomb()).count();
//                getNeighbours(box_tile).forEach(t -> open(t.getX(), t.getY()));
                if(bombs> 0) {
                    Text text = new Text();
                    text.setText(String.valueOf(bombs));
                    individualBox.setText(text);
                }
            }
        }
        return root;
    }




    public List<Box> getNeighbours (Box oneBox){
        List<Box> neighbours = new ArrayList<>();

        int[] points = new int[]{
                -1,-1,
                -1,0,
                -1,1,
                0,-1,
                0,1,
                1,-1,
                1,0,
                1,1
        };

        for (int i=0; i<points.length; i++){
            int dx= points[i];
            int dy= points[++i];

            int newX = oneBox.getX()+dx;
            int newY = oneBox.getY()+dy;

            if(newX>=0 && newX <field_x &&
                    newY>=0 && newY<field_y){
                neighbours.add(field[newX][newY]);
            }

        }
        return neighbours;
    }

    /*
    public void open(Box box_tile) {
        //   box_tile = controller_field[x][y];
        if (box_tile.isOpen()) {
            return;
        }
        /*
        isOpen = true;
        text.setVisible(true);
        square.setFill(null);
        */
    /*
        box_tile.openActions();
        if (text.getText().isEmpty()) {
            //  gameController.getNeighbours().forEach(Box::open);
            map_field.getNeighbours(box_tile).forEach(t -> open(t.getX(), t.getY()));
        }
    }
    */


    public int getField_x() {
        return field_x;
    }

    public void setField_x(int field_x) {
        this.field_x = field_x;
    }

    public int getField_y() {
        return field_y;
    }

    public void setField_y(int field_y) {
        this.field_y = field_y;
    }

    public Box[][] getField() {
        return field;
    }

    public void setField(Box[][] field) {
        this.field = field;
    }
}
