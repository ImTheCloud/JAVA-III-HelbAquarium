public class FishRed extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishPrey;
    private static int pos_y_fishPrey;
    private int moveFish;
    private int moveFishEverymoment = 1;
    private int idFishPrey;
    private int hitBoxFish = 3;
    private double calculDistance = 0;
    private double calculClosestDistance = 1000;
    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishRed() {
        super("Image/fishRed.png");
    }

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        closestFish();

        if ((getPos_x() >= pos_x_fishPrey - hitBoxFish) && (getPos_x() <= pos_x_fishPrey + hitBoxFish)
                && (getPos_y() >= pos_y_fishPrey - hitBoxFish) && (getPos_y() <= pos_y_fishPrey + hitBoxFish)) {
            fishKilling();
            closestFish();
        }
        if (getPos_y() < pos_y_fishPrey) {
            moveFish = getPos_y() + moveFishEverymoment;
            setPos_y(moveFish);
        }
        if (getPos_x() < pos_x_fishPrey) {
            moveFish = getPos_x() + moveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_x() > pos_x_fishPrey) {
            moveFish = getPos_x() - moveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_y() > pos_y_fishPrey) {
            moveFish = getPos_y() - moveFishEverymoment;
            setPos_y(moveFish);
        }

    }

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (Board.get_listFish().get(i).getClass().getName() != FishRed.class.getName()) {

                calculDistance = Math.sqrt(((getPos_x() - Board.get_listFish().get(i).getPos_x())
                        * (getPos_x() - Board.get_listFish().get(i).getPos_x())) +
                        ((getPos_y() - Board.get_listFish().get(i).getPos_y())
                                * (getPos_y() - Board.get_listFish().get(i).getPos_y())));

                if (calculClosestDistance > calculDistance) {
                    calculClosestDistance = calculDistance;
                    pos_x_fishPrey = Board.get_listFish().get(i).getPos_x();
                    pos_y_fishPrey = Board.get_listFish().get(i).getPos_y();
                    idFishPrey = get_idFish();
                }

            }

        }
    }

    private void fishKilling() {
        Board.get_listFish().remove(idFishPrey);

    }

}