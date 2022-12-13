import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private static int sizeFish = 15;
    protected static int screen_W = Board.getB_WIDTH() - sizeFish;
    protected static int screen_H = Board.getB_HEIGHT() - sizeFish;
    private final Image pathToImage;
    private int idFish = 0;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Fish(String string) {
        ImageIcon iid = new ImageIcon(string);

        pathToImage = iid.getImage();
        idFish += 1;

        positionFish();

    }

    public void couplingFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if (FishOrange.class.getName() == Board.get_listFish().get(i).getClass().getName()) {
                if (getPos_x() <= Board.get_listFish().get(i).getPos_x() + 20
                        && getPos_x() >= Board.get_listFish().get(i).getPos_x() - 20
                        && getPos_y() <= Board.get_listFish().get(i).getPos_y() + 20
                        && getPos_y() >= Board.get_listFish().get(i).getPos_y() - 20) {
                    System.out.println("Couple");
                }

            }
        }
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public int get_idFish() {
        return idFish;
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

    ///////////////////////////////////
    // create a random position for the Fish
    //////////////////////////////////

    public void positionFish() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // Movement Fish every moment
    //////////////////////////////////

    public void update() {

    }

}