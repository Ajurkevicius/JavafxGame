package game_clases;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class Tile extends StackPane {
    GameController controller = new GameController();
    private int tile_size=80;
    private int  x, y;
    private boolean hasBomb;
    private boolean isOpen=false;
    private Rectangle border = new Rectangle(tile_size -2, tile_size-2 );
    private Text text= new Text();
    public Tile(int x, int y, boolean hasBomb) {
        this.x = x;
        this.y = y;
        this.hasBomb = hasBomb;
        border.setStroke(Color.GRAY);
        //text.setFill(Color.WHITE);
        text.setText(hasBomb ? "X" : "");
        text.setVisible(false);
        //border.setFill(null);
        getChildren().addAll(border, text);
        setTranslateX(x*tile_size);
        setTranslateY(y*tile_size);

        //setOnMouseClicked(e -> open());
      //  setOnMouseClicked(e -> controller.listenToClick(this.x,this.y));

    }



    public void updateText(String textforUpdating){
        this.text.setText(textforUpdating);
    }

    public void visibleTextSetting(){
        this.text.setVisible(true);
    }

    public boolean isHasBomb() {
        return hasBomb;
    }

    public void setHasBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public String getTextInString(){
        return this.text.getText();
    }

    public void borderFillNullSetter(){
        this.border.setFill(null);
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

}