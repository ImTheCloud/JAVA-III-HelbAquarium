import java.util.ArrayList;

public class FishRed extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishPrey;
    private static int pos_y_fishPrey;
    private int moveFish;
    private int MoveFishEverymoment = 1;
    private int followedId;
    private int hitBoxFish = 3;
    private double rep = 0;
    private double min = 1000;
    private int EatId = 0;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishRed() {
        super("Image/fishRed.png");
    }

    ///////////////////////////////////
    // Method called every moment for a chhange, here for move
    //////////////////////////////////

    @Override
    public void update() {

        // for (int i = 0; i < Board.get_listFish().size(); i++) {

        // if (Board.get_listFish().get(i).getClass().getName() !=
        // FishRed.class.getName()) {

        // pos_x_fishPrey = Board.get_listFish().get(i).getPos_x();
        // pos_y_fishPrey = Board.get_listFish().get(i).getPos_y();

        // followedId = Board.get_listFish().get(i).get_id();

        // }

        // }

        closestFish();

        if ((getPos_x() >= pos_x_fishPrey - hitBoxFish) && (getPos_x() <= pos_x_fishPrey + hitBoxFish)
                && (getPos_y() >= pos_y_fishPrey - hitBoxFish) && (getPos_y() <= pos_y_fishPrey + hitBoxFish)) {
            // System.out.println("tuer2");
            fishKilling();

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

    private void closestFish() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (Board.get_listFish().get(i).getClass().getName() != FishRed.class.getName()) {

                rep = Math.sqrt(((getPos_x() - Board.get_listFish().get(i).getPos_x())
                        * (getPos_x() - Board.get_listFish().get(i).getPos_x())) +
                        ((getPos_y() - Board.get_listFish().get(i).getPos_y())
                                * (getPos_y() - Board.get_listFish().get(i).getPos_y())));

                if (min > rep) {
                    min = rep;
                    pos_x_fishPrey = Board.get_listFish().get(i).getPos_x();
                    pos_y_fishPrey = Board.get_listFish().get(i).getPos_y();
                    EatId = get_id();
                }

            }

        }
    }

    private void fishKilling() {
        Board.get_listFish().remove(followedId);

    }

}