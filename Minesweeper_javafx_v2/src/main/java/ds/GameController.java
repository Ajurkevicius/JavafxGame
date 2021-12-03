package ds;

import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private int height = 600;
    private int width = 800;
    private int boxSize1 = 40;

    private int field_x = width / boxSize1;
    private int field_y = height / boxSize1;
    Mape map_field;
    Box box_tile ;
    private Box[][] controller_field = map_field.getField();
    private Text text = box_tile.getText();
    // private boolean isBomb;
    private boolean isOpen = box_tile.isOpen();
    private Rectangle square = box_tile.getSquare();


    // private boolean isOpen= box_tile.isOpen();
    /*
    public List<Box> getNeighbours(Box oneBox) {
        List<Box> neighbours = new ArrayList<>();

        int[] points = new int[]{
                -1, -1, -1, 0, -1, 1, 0, -1, 0, 1, 1, -1, 1, 0, 1, 1
        };
        for (int i = 0; i < points.length; i = i + 2) {
            int dx = points[i];
            int dy = points[i + 1];
            int newX = oneBox.getX() + dx;
            int newY = oneBox.getY() + dy;
            if (newX >= 0 && newX < field_x &&
                    newY >= 0 && newY < field_y) {
                neighbours.add(controller_field[newX][newY]);
            }

        }
        return neighbours;
    }
*/
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
                neighbours.add(controller_field[newX][newY]);
            }

        }
        return neighbours;
    }

    public void open(int x, int y) {
        box_tile = controller_field[x][y];

        if (box_tile.isOpen()) {
            return;
        }
        isOpen = true;
        text.setVisible(true);
        square.setFill(null);

        if (text.getText().isEmpty()) {

            //  gameController.getNeighbours().forEach(Box::open);
            getNeighbours(box_tile).forEach(t -> open(t.getX(), t.getY()));
        }
    }

}
