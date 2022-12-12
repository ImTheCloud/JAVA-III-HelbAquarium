import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Obstacle {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private Image obstacle_Image;
    private static int HitBoxOBstacle = 20; // 40 W / 20 H
    protected int screen_W = Board.getB_WIDTH() - (HitBoxOBstacle * 2); // *2 because it's a rectangle not a square
    protected int screen_H = Board.getB_HEIGHT() - HitBoxOBstacle;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Obstacle() {
        ImageIcon iio = new ImageIcon("Image/obstacle.png");
        obstacle_Image = iio.getImage();
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
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
        return obstacle_Image;
    }

    ///////////////////////////////////
    // If a fish touch a obstacle he take an other edge random for the new position
    ///////////////////////////////////

    public void update() {

        ArrayList<Fish> listFish = Board.get_listFish();
        for (Fish fish : listFish) {
            if ((getPos_x() - HitBoxOBstacle <= fish.getPos_x()) && (getPos_x() + HitBoxOBstacle >= fish.getPos_x())
                    && (getPos_y() - HitBoxOBstacle <= fish.getPos_y())
                    && (getPos_y() + HitBoxOBstacle >= fish.getPos_y())) {

                System.out.println("obstacle toucher");
            }
        }

    }

}