import javax.swing.*;
import java.awt.*;

public class Fish {
    private int pos_x;
    private int pos_y;
    private static int sizeFish = 15;
    protected static int screen_W = Board.getB_WIDTH() - sizeFish;
    protected static int screen_H = Board.getB_HEIGHT() - sizeFish;
    private final Image pathToImage;

    public Fish(String string) {
        ImageIcon iid = new ImageIcon(string);
        pathToImage = iid.getImage();
        positionFish();

    }

    public void positionFish() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    public void update() {

    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    public Image getPathToImage() {
        return pathToImage;
    }

}