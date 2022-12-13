public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishRed;
    private static int pos_y_fishRed;
    private int moveFish;
    private int speedFish = 3 + Board.get_speed_fish();

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishPurple() {
        super("Image/fishPurple.png");
    }

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        // if ("FishPurple" != EdiblePellet.get_NameFishTouchPellet() &&
        // EdiblePellet.get_counterToStopMoveFish() == 0) {
        // if (EdiblePellet.get_counterToStopMoveFish() == 0) {
        oppositeDirectionofTheRedFish();
        if (getPos_y() < pos_y_fishRed) {
            moveFish = getPos_y() - speedFish;
            setPos_y(moveFish);
            oppositeDirectionofTheRedFish();
        }
        if (getPos_x() < pos_x_fishRed) {
            moveFish = getPos_x() - speedFish;
            setPos_x(moveFish);
            oppositeDirectionofTheRedFish();
        }
        if (getPos_x() > pos_x_fishRed) {
            moveFish = getPos_x() + speedFish;
            setPos_x(moveFish);
            oppositeDirectionofTheRedFish();
        }
        if (getPos_y() > pos_y_fishRed) {
            moveFish = getPos_y() + speedFish;
            setPos_y(moveFish);
            oppositeDirectionofTheRedFish();
        }
        // } else {
        // EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish()
        // - 1);
        // // System.out.println(EdiblePellet.get_counterToStopMoveFish());

        // }

    }

    private void oppositeDirectionofTheRedFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                // calculDistance = Math.sqrt(((getPos_x() -
                // Board.get_listFish().get(i).getPos_x())
                // * (getPos_x() - Board.get_listFish().get(i).getPos_x()))
                // + ((getPos_y() - Board.get_listFish().get(i).getPos_y())
                // * (getPos_y() - Board.get_listFish().get(i).getPos_y())));

                // if (calculClosestDistance > calculDistance) {
                // calculClosestDistance = calculDistance;
                pos_x_fishRed = Board.get_listFish().get(i).getPos_x();
                pos_y_fishRed = Board.get_listFish().get(i).getPos_y();
                // }

            }

        }
    }

}