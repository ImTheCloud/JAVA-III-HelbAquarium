import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Insect {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private int sizeInsect = 15;
    protected int screen_W = Board.getB_WIDTH() - sizeInsect;
    protected int screen_H = Board.getB_HEIGHT() - sizeInsect;
    private final Image pathToImage;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Insect(String Image) {
        ImageIcon iid = new ImageIcon(Image);
        pathToImage = iid.getImage();
        positionRandomInsect();

    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Image getPathToImage() {
        return pathToImage;
    }

    ///////////////////////////////////
    // If a fish touch a insect he eats it and another insect appears in a random
    // and another insect appears in a random position
    ///////////////////////////////////

    public void update() {
        ArrayList<Fish> listFish = Board.get_listFish();
        for (Fish fish : listFish) {

            if ((getPos_x() - sizeInsect <= fish.getPos_x()) && (getPos_x() + sizeInsect >= fish.getPos_x())
                    && (getPos_y() - sizeInsect <= fish.getPos_y())
                    && (getPos_y() + sizeInsect >= fish.getPos_y())) {

                positionRandomInsect();

                // System.out.println("Insect manger");
            }

        }
    }

    ///////////////////////////////////
    // create a random position for the Pellet
    //////////////////////////////////

    public void positionRandomInsect() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

}