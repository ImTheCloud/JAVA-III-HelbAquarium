import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Insect {
    private int pos_x;
    private int pos_y;
    protected int screen_W = Board.getB_WIDTH() - 15;
    protected int screen_H = Board.getB_HEIGHT() - 15;
    private final Image pathToImage;
    private int tailleInsect = 10;

    public Insect(String Image) {
        ImageIcon iid = new ImageIcon(Image);
        pathToImage = iid.getImage();
        positionRandomInsect();

    }

    public void positionRandomInsect() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Image getPathToImage() {
        return pathToImage;
    }

    public void update() {
        ArrayList<Fish> listFish = Board.get_listFish();
        for (Fish fish : listFish) {

            if ((getPos_x() - tailleInsect <= fish.getPos_x()) && (getPos_x() + tailleInsect >= fish.getPos_x())
                    && (getPos_y() - tailleInsect <= fish.getPos_y())
                    && (getPos_y() + tailleInsect >= fish.getPos_y())) {

                positionRandomInsect();

                // System.out.println("Insect manger");
            }

        }
    }

}