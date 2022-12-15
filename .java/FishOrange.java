public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private static int speedFish = 5;
    private static int numberEdgeExisting = 3;
    private static int randomEdge;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // Method for a random Edge
    //////////////////////////////////

    public FishOrange() {
        set_speedFish(speedFish);
    }

    public void randomEdgePosition() {

        randomEdge = (int) (Math.random() * numberEdgeExisting);
        if (randomEdge == 0) {
            setPos_x_target(0);
            setPos_y_target((int) (Math.random() * screen_H));
        } else if (randomEdge == 1) {
            setPos_x_target(screen_W);
            setPos_y_target((int) (Math.random() * screen_H));
        } else if (randomEdge == 2) {
            setPos_y_target(0);
            setPos_x_target((int) (Math.random() * screen_W));
        } else if (randomEdge == 3) {
            setPos_y_target(screen_H);
            setPos_x_target((int) (Math.random() * screen_W));
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

        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            moving();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);
        } else {
            speedFish = 5;
            moving();
        }

    }

    public void moving() {
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()) {
            if (getPos_x() <= getPos_x_target() + 6
                    && getPos_x() >= getPos_x_target() - 6
                    && getPos_y() <= getPos_y_target() + 6
                    && getPos_y() >= getPos_y_target() - 6) {
                randomEdgePosition();
            }

            super.update();

        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "O");
        }
    }

}
