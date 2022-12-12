public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishRed;
    private static int pos_y_fishRed;
    private int moveFish;
    private int speedFish = Board.get_speed_fish();

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