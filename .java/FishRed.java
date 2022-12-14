public class FishRed extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishPrey;
    private static int pos_y_fishPrey;
    private int moveFish;
    private static int speedFish = 3;
    private Fish deathFish;
    private int hitBoxFish = 3;
    // private double calculDistance = 0;
    // private double calculClosestDistance = 1000;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // the get/set
    //////////////////////////////////

    public static int getSpeed() {
        return speedFish;
    }

    public static void setSpeedUpgrade(int speeedFish) {
        speedFish = speeedFish;
    }

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        // if ("FishRed" != EdiblePellet.get_NameFishTouchPellet() &&
        // EdiblePellet.get_counterToStopMoveFish() == 0) {

        // if (EdiblePellet.get_counterToStopMoveFish() == 0) {
        closestFish();

        if ((getPos_x() >= pos_x_fishPrey - hitBoxFish) && (getPos_x() <= pos_x_fishPrey + hitBoxFish)
                && (getPos_y() >= pos_y_fishPrey - hitBoxFish) && (getPos_y() <= pos_y_fishPrey + hitBoxFish)) {
            fishKilling();
            closestFish();
        }
        if (getPos_y() < pos_y_fishPrey) {
            moveFish = getPos_y() + speedFish;
            setPos_y(moveFish);
        }
        if (getPos_x() < pos_x_fishPrey) {
            moveFish = getPos_x() + speedFish;
            setPos_x(moveFish);
        }
        if (getPos_x() > pos_x_fishPrey) {
            moveFish = getPos_x() - speedFish;
            setPos_x(moveFish);
        }
        if (getPos_y() > pos_y_fishPrey) {
            moveFish = getPos_y() - speedFish;
            setPos_y(moveFish);
        }
        // } else {

        // EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish()
        // - 1);
        // // System.out.println(EdiblePellet.get_counterToStopMoveFish());
        // }

    }

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() != Board.get_listFish().get(i).getClass().getName()) {

                // calculDistance = Math.sqrt(((getPos_x() -
                // Board.get_listFish().get(i).getPos_x())
                // * (getPos_x() - Board.get_listFish().get(i).getPos_x()))
                // + ((getPos_y() - Board.get_listFish().get(i).getPos_y())
                // * (getPos_y() - Board.get_listFish().get(i).getPos_y())));

                // if (calculClosestDistance > calculDistance) {
                // calculClosestDistance = calculDistance;

                pos_x_fishPrey = Board.get_listFish().get(i).getPos_x();
                pos_y_fishPrey = Board.get_listFish().get(i).getPos_y();
                deathFish = Board.get_listFish().get(i);
                // }

            }

        }
    }

    private void fishKilling() {
        Board.get_listFish().remove(deathFish);

    }

}