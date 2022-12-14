import javax.swing.*;
import java.awt.*;

public class Insect {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private int HitBoxInsect = 15;
    protected int screen_W = Board.getB_WIDTH();
    protected int screen_H = Board.getB_HEIGHT();
    private final Image pathToImage;
    private static int SpeedUpgrade;
    private static String nameInsectColour;

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

    public static int getSpeedUpgrade() {
        return SpeedUpgrade;
    }

    public static void setSpeedUpgrade(int setSpeedUpgrade) {
        SpeedUpgrade = setSpeedUpgrade;
    }

    public Image getPathToImage() {
        return pathToImage;
    }

    static String get_nameInsectColour() {
        return nameInsectColour;
    }

    ///////////////////////////////////
    // create a random position for the Pellet
    //////////////////////////////////

    public void positionRandomInsect() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // If a fish touch a insect he eats it and another insect appears in a random
    // and another insect appears in a random position
    ///////////////////////////////////

    public void update() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if ((getPos_x() - HitBoxInsect <= Board.get_listFish().get(i).getPos_x())
                    && (getPos_x() + HitBoxInsect >= Board.get_listFish().get(i).getPos_x())
                    && (getPos_y() - HitBoxInsect <= Board.get_listFish().get(i).getPos_y())
                    && (getPos_y() + HitBoxInsect >= Board.get_listFish().get(i).getPos_y())) {

                positionRandomInsect();
                SpeedUpgrade = 4;

                // nameInsectColour = Insect.getName();

            }

        }
    }

}