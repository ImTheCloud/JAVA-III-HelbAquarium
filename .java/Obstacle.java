import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Obstacle {

    private int pos_x;
    private int pos_y;
    private Image obstacle_Image;
    private static int tailleObstacle = 20; // 40 Largeur / 20 Hauteur
    protected int screen_W = Board.getB_WIDTH() - (tailleObstacle * 2);
    protected int screen_H = Board.getB_HEIGHT() - tailleObstacle;

    public Obstacle() {
        ImageIcon iio = new ImageIcon("Image/obstacle.png");
        obstacle_Image = iio.getImage();
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public Image PathToImage() {
        return obstacle_Image;
    }

    public void update() {
        ArrayList<Fish> listFish = Board.get_listFish();
        for (Fish fish : listFish) {

            if ((getPos_x() >= fish.getPos_x() + tailleObstacle) && (getPos_x() <= fish.getPos_x())
                    && (getPos_y() >= fish.getPos_y() + tailleObstacle) && (getPos_y() <= fish.getPos_y())) {
                FishOrange.get_randomNvlPosition();

                // System.out.println("obstacle toucher");
            }
        }
    }
}