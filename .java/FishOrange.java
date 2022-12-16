public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private static int speedFish = 5;
    private static int numberEdgeExisting = 3;
    private static int randomEdge;
    private boolean stopMoveFishFromKeyEvent = false;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////
    public FishOrange() {
        set_speedFish(speedFish);

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
    // Method for a random Edge (target of the orange fish)
    //////////////////////////////////

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
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        ifTheOrangeFishTouchAnInsectPlusPellet();
    }

    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifTheOrangeFishTouchAnInsectPlusPellet() {
        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            ifTheOrangeFishTouchAPellet();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);
        } else {
            speedFish = 5;
            ifTheOrangeFishTouchAPellet();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void ifTheOrangeFishTouchAPellet() {

        if (Board.get_colourFishKeyPressed() == "FishOrange") {
            stopMoveFishFromKeyEvent = true;
        } else {
            stopMoveFishFromKeyEvent = false;
        }
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()
                || stopMoveFishFromKeyEvent == true) {

            if (getPos_x_fish() <= getPos_x_target() + 6
                    && getPos_x_fish() >= getPos_x_target() - 6
                    && getPos_y_fish() <= getPos_y_target() + 6
                    && getPos_y_fish() >= getPos_y_target() - 6) {
                randomEdgePosition();
            }

            super.update();

        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet() && stopMoveFishFromKeyEvent == false) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
        }
    }

}
