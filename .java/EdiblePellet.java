import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    public void set_counterToStopMoveFish(int counterToStopMoveFish) {
        // this.stop = stop;
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
        ArrayList<Fish> listFish = Board.get_listFish();
        for (Fish fish : listFish) {
            if ((getPos_x() - HitBoxPellet <= fish.getPos_x()) && (getPos_x() + HitBoxPellet >= fish.getPos_x())
                    && (getPos_y() - HitBoxPellet <= fish.getPos_y())
                    && (getPos_y() + HitBoxPellet >= fish.getPos_y())) {

                positionRandomEdiblePellet();
                counterToStopMoveFish = 1000;

                // System.out.println("Pellet");
            }

        }
    }

}