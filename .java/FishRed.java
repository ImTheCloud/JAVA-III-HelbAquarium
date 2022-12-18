public class FishRed extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private static int speedFish = 5;
    private Fish deathFish;
    private int hitBoxFish = 10;
    private double calculDistance = 0;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x;// calcul for the closest distance
    private int y;
    private boolean stopMoveFishFromKeyEvent = false;

    ///////////////////////////////////
    // the get/set
    //////////////////////////////////

    public static int getSpeed() {
        return speedFish;

    }

    public static void setSpeedUpgrade(int speedFishChange) {
        speedFish = speedFishChange;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        obstacleTouched();
        ifTheRedFishTouchAnInsectPlusPellet();
    }
    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifTheRedFishTouchAnInsectPlusPellet() {
        set_speedFish(speedFish);

        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            ifTheRedFishTouchAPellet();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);

        } else {

            set_speedFish(get_SpeedFish());
            ifTheRedFishTouchAPellet();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void ifTheRedFishTouchAPellet() {

        if (Board.get_colourFishKeyPressed() == "FishRed") {
            stopMoveFishFromKeyEvent = true;
        } else {
            stopMoveFishFromKeyEvent = false;
        }
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || stopMoveFishFromKeyEvent == true) {
            closestFish();
            if ((getPos_x_fish() >= getPos_x_target() - hitBoxFish)
                    && (getPos_x_fish() <= getPos_x_target() + hitBoxFish)
                    && (getPos_y_fish() >= getPos_y_target() - hitBoxFish)
                    && (getPos_y_fish() <= getPos_y_target() + hitBoxFish)) {
                fishKilling();

            }
            super.update();
        } else if ("FishPurple" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlack" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet() || stopMoveFishFromKeyEvent == false) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);

        }
    }

    ///////////////////////////////////
    // the fish will kill every fish,
    // he follos first the closest fish but not the black
    //////////////////////////////////

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() != Board.get_listFish().get(i).getClass().getName()
                    && FishBlack.class.getName() != Board.get_listFish().get(i).getClass().getName()) {

                x = Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish();
                y = Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                    deathFish = Board.get_listFish().get(i);
                }

            }

        }
        closestDistance = Board.getB_WIDTH();
    }

    ///////////////////////////////////
    // Kill the fish who is touched by the red
    //////////////////////////////////
    private void fishKilling() {
        Board.get_listFish().remove(deathFish);

    }

    ///////////////////////////////////
    // What does the fish if he touch an obstacle
    //////////////////////////////////

    public void obstacleTouched() {

        if (Obstacle.getnameFishTouchedTheObstacle() == this.getClass().getName()) {
            if (Obstacle.getSideObstacle() == "botTop") {
                setPos_x_target(getPos_x_fish() + 1);
            } else {
                setPos_y_target(getPos_y_fish() + 1);
            }

        }
    }

}