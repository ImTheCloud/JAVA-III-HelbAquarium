import java.util.ArrayList;

public class FishRed extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int destination_pos_x;
    private static int destination_pos_y;
    private int moveFish;
    private int MoveFishEverymoment = 1;

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

        ArrayList<Fish> listFishPrey = Board.get_listFish();
        for (Fish fishprey : listFishPrey) {
            // if (getPos_x() == fishprey.getPos_x() && getPos_y() == fishprey.getPos_y()) {
            // System.out.println("tuer");
            // }

            destination_pos_x = fishprey.getPos_x();
            destination_pos_y = fishprey.getPos_y();

        }

        if (getPos_x() == destination_pos_x && getPos_y() == destination_pos_y) {
            System.out.println("tuer");
        }
        if (getPos_y() < destination_pos_y) {
            moveFish = getPos_y() + MoveFishEverymoment;
            setPos_y(moveFish);
        }
        if (getPos_x() < destination_pos_x) {
            moveFish = getPos_x() + MoveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_x() > destination_pos_x) {
            moveFish = getPos_x() - MoveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_y() > destination_pos_y) {
            moveFish = getPos_y() - MoveFishEverymoment;
            setPos_y(moveFish);
        }

    }

}