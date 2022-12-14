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

    ///////////////////////////////////
    // Method called every moment for a chhange, here for move
    //////////////////////////////////

    @Override
    public void update() {

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

    }

    private void directionToFishBlueOrPurple() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()
                    || FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                pos_x_fishBlueOrPurple = Board.get_listFish().get(i).getPos_x();
                pos_y_fishBlueOrPurple = Board.get_listFish().get(i).getPos_y();

            }

        }
    }

}