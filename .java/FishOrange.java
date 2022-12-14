public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int destination_pos_x;
    private static int destination_pos_y;
    private int moveFish;
    private static int speedFish = 3;
    private static int numberEdgeExisting = 3;
    private static int randomEdge;
    private int timmerSpeedInsect = 20;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // Method for a random Edge
    //////////////////////////////////

    public void randomEdgePosition() {

        randomEdge = (int) (Math.random() * numberEdgeExisting);
        if (randomEdge == 0) {
            destination_pos_x = 0;
            destination_pos_y = (int) (Math.random() * screen_H);
        } else if (randomEdge == 1) {
            destination_pos_x = screen_W;
            destination_pos_y = (int) (Math.random() * screen_H);
        } else if (randomEdge == 2) {
            destination_pos_y = 0;
            destination_pos_x = (int) (Math.random() * screen_W);
        } else if (randomEdge == 3) {
            destination_pos_y = screen_H;
            destination_pos_x = (int) (Math.random() * screen_W);
        }
    }

    ///////////////////////////////////
    // the get/set
    //////////////////////////////////

    public static int getSpeedUpgrade() {
        return speedFish;
    }

    public static void setSpeedUpgrade(int speeedFish) {
        speeedFish = speedFish;
    }

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()) {
            // System.out.println(EdiblePellet.get_counterToStopMoveFish());
            if (getPos_x() <= destination_pos_x + 5
                    && getPos_x() >= destination_pos_x - 5
                    && getPos_y() <= destination_pos_y + 5
                    && getPos_y() >= destination_pos_y - 5) {
                randomEdgePosition();
            }

            if (getPos_y() < destination_pos_y) {
                moveFish = getPos_y() + speedFish;
                setPos_y(moveFish);
            }
            if (getPos_x() < destination_pos_x) {
                moveFish = getPos_x() + speedFish;
                setPos_x(moveFish);
            }
            if (getPos_x() > destination_pos_x) {
                moveFish = getPos_x() - speedFish;
                setPos_x(moveFish);
            }
            if (getPos_y() > destination_pos_y) {
                moveFish = getPos_y() - speedFish;
                setPos_y(moveFish);
            }
        }
        if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish());
        }
    }

}
