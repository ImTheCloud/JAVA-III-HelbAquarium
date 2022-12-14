public class FishRed extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishPrey;
    private static int pos_y_fishPrey;
    private int moveFish;
    private static int speedFish = 3;
    private Fish deathFish;
    private int hitBoxFish = 2;
    private double calculDistance = 0;
    private double closestDistance = 1000;
    private int x;
    private int y;

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

        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishRed" == EdiblePellet.get_NameFishTouchPellet()) {
            closestFish();
            if ((getPos_x() >= pos_x_fishPrey - hitBoxFish) && (getPos_x() <= pos_x_fishPrey + hitBoxFish)
                    && (getPos_y() >= pos_y_fishPrey - hitBoxFish) && (getPos_y() <= pos_y_fishPrey + hitBoxFish)) {
                fishKilling();

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
        } else if ("FishPurple" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);

        }

    }

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() != Board.get_listFish().get(i).getClass().getName()) {

                x = Board.get_listFish().get(i).getPos_x() - this.getPos_x();
                y = Board.get_listFish().get(i).getPos_y() - this.getPos_y();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    pos_x_fishPrey = Board.get_listFish().get(i).getPos_x();
                    pos_y_fishPrey = Board.get_listFish().get(i).getPos_y();

                    deathFish = Board.get_listFish().get(i);
                }

            }

        }
    }

    private void fishKilling() {
        Board.get_listFish().remove(deathFish);
        closestDistance = 1000;

    }

}