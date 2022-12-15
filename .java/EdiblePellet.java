import javax.swing.*;
import java.awt.*;

public class EdiblePellet {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private Image ediblePellet_Image;
    private static int HitBoxPellet = 7;
    protected int screen_W = Board.getB_WIDTH();
    protected int screen_H = Board.getB_HEIGHT();
    private static int counterToStopMoveFish = 0;
    private static String nameFishTouchPellet;
    // private EdiblePellet deathPellet;
    // private EdiblePellet deathPellet;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public EdiblePellet() {
        ImageIcon iio = new ImageIcon("Image/ediblePellet.png");
        ediblePellet_Image = iio.getImage();
        positionRandomEdiblePellet();

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

    public Image PathToImage() {
        return ediblePellet_Image;
    }

    static int get_counterToStopMoveFish() {
        return counterToStopMoveFish;
    }

    static String get_NameFishTouchPellet() {
        return nameFishTouchPellet;
    }

    public static void set_counterToStopMoveFish(int setCounterToStopMoveFish) {
        counterToStopMoveFish = setCounterToStopMoveFish;
    }

    ///////////////////////////////////
    // create a random position for the Pellet
    //////////////////////////////////

    public void positionRandomEdiblePellet() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // If a fish touch a pellet he eats it and another pellet appears in a random
    // and another pellet appears in a random position
    ///////////////////////////////////

    public void update() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if ((Board.get_listFish().get(i).getPos_x() - HitBoxPellet <= getPos_x())
                    && (Board.get_listFish().get(i).getPos_x() + HitBoxPellet >= getPos_x())
                    && (Board.get_listFish().get(i).getPos_y() - HitBoxPellet <= getPos_y())
                    && (Board.get_listFish().get(i).getPos_y() + HitBoxPellet >= getPos_y())) {

                // deathPellet = Board.get_ediblePellet().get(i);
                // Board.get_ediblePellet().remove(deathPellet);
                positionRandomEdiblePellet();

                counterToStopMoveFish = 100 * Board.get_listFish().size();

                nameFishTouchPellet = Board.get_listFish().get(i).getClass().getName();

                System.out.println(get_NameFishTouchPellet() + " pellet");
            }

        }
    }

}