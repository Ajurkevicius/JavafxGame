package ds;

import ds.Mape;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;




public class Box extends StackPane {


    GameController gameController = new GameController();
    private int x,y;
    public int boxSize = 40;
    private boolean isBomb;
    private boolean isOpen=false;
    private Rectangle square = new Rectangle(boxSize -5, boxSize -5);
    private Text text = new Text();

    public Box(int x, int y, boolean isBomb) {
        this.x = x;
        this.y = y;
        this.isBomb = isBomb;
        square.setStroke(Color.GREY);

        //text.setFill(Color.WHITE);
        text.setText(isBomb ? "X" : "");
        text.setVisible(false);
        getChildren().addAll(square, text);
        System.out.println("Objektas cia buvo");
        setTranslateX(x*boxSize);
        setTranslateY(y*boxSize);

        setOnMouseClicked(e -> gameController.open();

    }
    public Box() {

    }

    public void open() {
        //   box_tile = controller_field[x][y];
        if (box_tile.isOpen()) {
            return;
        }
        /*
        isOpen = true;
        text.setVisible(true);
        square.setFill(null);
        */
        box_tile.openActions();
        if (text.getText().isEmpty()) {
            //  gameController.getNeighbours().forEach(Box::open);
            map_field.getNeighbours(box_tile).forEach(t -> open(t.getX(), t.getY()));
        }
    }

    /*
    public void openActions(){
        isOpen=true;
        text.setVisible(true);
        square.setFill(null);
    }
*/
    /*
    public void ClickListener(){
        setOnMouseClicked(e -> gameController.open(this.Box));
    }
*/
    /*
    public void open(Box box_tile) {
        //   box_tile = controller_field[x][y];

        if (box_tile.isOpen()) {
            return;
        }
        isOpen = true;
        text.setVisible(true);
        square.setFill(null);

        if (text.getText().isEmpty()) {
            //  gameController.getNeighbours().forEach(Box::open);
            map_field.getNeighbours(box_tile).forEach(t -> open(t.getX(), t.getY()));
        }
    }
*/


/*
    public void open(){
        if(isOpen){
            return;
        }
        isOpen=true;
        text.setVisible(true);
        square.setFill(null);

        if(text.getText().isEmpty()){

            gameController.getNeighbours().forEach(Box::open);
            getNeighbours().forEach(Box::open);

        }
    }
*/


    public boolean getisBomb() {
        return isBomb;
    }

    public Text getText() {
        return text;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBoxSize() {
        return boxSize;
    }

    public void setBoxSize(int boxSize) {
        this.boxSize = boxSize;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Rectangle getSquare() {
        return square;
    }

    public void setSquare(Rectangle square) {
        this.square = square;
    }

    public void setText(Text text) {
        this.text = text;
    }



}

