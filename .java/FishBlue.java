import java.util.ArrayList;

public class FishBlue extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishPrey;
    private static int pos_y_fishPrey;
    private int moveFish;
    private int MoveFishEverymoment = 1;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishBlue() {
        super("Image/fishBlue.png");
    }

    ///////////////////////////////////
    // Method called every moment for a chhange, here for move
    //////////////////////////////////

    @Override
    public void update() {

        ArrayList<Fish> listFishPrey = Board.get_listFish();
        for (Fish fishprey : listFishPrey) {
            // if (getPos_x() == fishprey.getPos_x() && getPos_y() == fishprey.getPos_y()) {
            // System.out.println("tuer");
            // }

            if ((getPos_x() >= pos_x_fishPrey) && (getPos_x() <= pos_x_fishPrey)
                    && (getPos_y() >= pos_y_fishPrey) && (getPos_y() <= pos_y_fishPrey)) {
                pos_x_fishPrey = fishprey.getPos_x();
                pos_y_fishPrey = fishprey.getPos_y();
            }

        }

        // if ((getPos_x() >= pos_x_fishPrey) && (getPos_x() <= pos_x_fishPrey)
        // && (getPos_y() >= pos_y_fishPrey) && (getPos_y() <= pos_y_fishPrey)) {
        // System.out.println("tuer");
        // }
        if (getPos_x() == pos_x_fishPrey && getPos_y() == pos_y_fishPrey) {
            System.out.println("");
        }
        if (getPos_y() < pos_y_fishPrey) {
            moveFish = getPos_y() + MoveFishEverymoment;
            setPos_y(moveFish);
        }
        if (getPos_x() < pos_x_fishPrey) {
            moveFish = getPos_x() + MoveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_x() > pos_x_fishPrey) {
            moveFish = getPos_x() - MoveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_y() > pos_y_fishPrey) {
            moveFish = getPos_y() - MoveFishEverymoment;
            setPos_y(moveFish);
        }

    }

}