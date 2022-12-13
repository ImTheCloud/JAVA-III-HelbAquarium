public class FishBlue extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishBlueOrPurple;
    private static int pos_y_fishBlueOrPurple;
    private int moveFish;
    private int speedFish = 4;
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

        // if ("FishBlue" != EdiblePellet.get_NameFishTouchPellet() &&
        // EdiblePellet.get_counterToStopMoveFish() == 0) {

        // if (EdiblePellet.get_counterToStopMoveFish() == 0) {

        directionToFishBlueOrPurple();

        if (getPos_y() < pos_y_fishBlueOrPurple) {
            moveFish = getPos_y() + speedFish;
            setPos_y(moveFish);
        }
        if (getPos_x() < pos_x_fishBlueOrPurple) {
            moveFish = getPos_x() + speedFish;
            setPos_x(moveFish);
        }
        if (getPos_x() > pos_x_fishBlueOrPurple) {
            moveFish = getPos_x() - speedFish;
            setPos_x(moveFish);
        }
        if (getPos_y() > pos_y_fishBlueOrPurple) {
            moveFish = getPos_y() - speedFish;
            setPos_y(moveFish);
        }
        // } else {

        // EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish()
        // - 1);
        // // System.out.println(EdiblePellet.get_counterToStopMoveFish());
        // }

    }

    private void directionToFishBlueOrPurple() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishBlue.class.getName() == Board.get_listFish().get(i).getClass().getName()
                    || FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                // calculDistance = Math.sqrt(((getPos_x() -
                // Board.get_listFish().get(i).getPos_x())
                // * (getPos_x() - Board.get_listFish().get(i).getPos_x()))
                // + ((getPos_y() - Board.get_listFish().get(i).getPos_y())
                // * (getPos_y() - Board.get_listFish().get(i).getPos_y())));

                // if (calculClosestDistance > calculDistance) {
                // calculClosestDistance = calculDistance;

                pos_x_fishBlueOrPurple = Board.get_listFish().get(i).getPos_x();
                pos_y_fishBlueOrPurple = Board.get_listFish().get(i).getPos_y();

                // }

            }

        }
    }

}