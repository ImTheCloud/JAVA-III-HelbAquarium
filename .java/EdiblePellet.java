import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EdiblePellet {

    private int pos_x;
    private int pos_y;
    private Image ediblePellet_Image;
    private static int taillePellet = 7;
    protected int screen_W = Board.getB_WIDTH() - taillePellet;
    protected int screen_H = Board.getB_HEIGHT() - taillePellet;
    private static int stop = 0;

    public EdiblePellet() {
        ImageIcon iio = new ImageIcon("Image/ediblePellet.png");
        ediblePellet_Image = iio.getImage();
        positionRandomEdiblePellet();

    }

    public void positionRandomEdiblePellet() {
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
        return ediblePellet_Image;
    }

    public void update() { // touche la pastille et le mange
        ArrayList<Fish> listFish = Board.get_listFish();
        for (Fish fish : listFish) {
            if ((getPos_x() - taillePellet <= fish.getPos_x()) && (getPos_x() + taillePellet >= fish.getPos_x())
                    && (getPos_y() - taillePellet <= fish.getPos_y())
                    && (getPos_y() + taillePellet >= fish.getPos_y())) {

                positionRandomEdiblePellet();
                stop = 1000;

                // System.out.println("Pastille manger");
            }

        }
    }

    static int get_stop() {
        return stop;
    }

    public void set_stop(int stop) {
        // this.stop = stop;
    }

}