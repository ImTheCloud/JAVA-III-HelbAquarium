public class FishBlue extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int speedFish = 7;
    private double calculDistance;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x;// calcul for the closest distance
    private int y;
    private boolean stopMoveFishFromKeyEvent = false;
    private final int endOfTheCounter = 0;
    private final int counterDecrement = 1;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishBlue() {
        set_speedFish(speedFish);
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        obstacleTouched();
        ifTheBlueFishTouchAnInsectPlusPellet();
    }

    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifTheBlueFishTouchAnInsectPlusPellet() {
        if (Insect.get_timmerSpeedFish() != endOfTheCounter && Insect.getNameFishTouchInsect() == "FishBlue") {
            speedFish = 11; // upgrade speed 7 to 11
            ifTheBlueFishTouchAPellet();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - counterDecrement);

        } else {
            speedFish = 7;// base speed
            ifTheBlueFishTouchAPellet();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void ifTheBlueFishTouchAPellet() {

        if (Board.get_colourFishKeyPressed() == "FishBlue") {
            stopMoveFishFromKeyEvent = true;
        } else {
            stopMoveFishFromKeyEvent = false;
        }
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlack" == EdiblePellet.get_NameFishTouchPellet()
                || stopMoveFishFromKeyEvent == true) {

            directionToFishBlueOrPurple();

            super.update();

        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet() || stopMoveFishFromKeyEvent == false) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - counterDecrement);

        }
    }

    ///////////////////////////////////
    // The blue fish follow the closest fish purple or blue
    //////////////////////////////////

    private void directionToFishBlueOrPurple() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if (FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()) {
                x = Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish();
                y = Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                }
            }

        }
        closestDistance = Board.getB_WIDTH();
    }

    ///////////////////////////////////
    // What does the fish if he touch an obstacle
    //////////////////////////////////

    public void obstacleTouched() {
        if (Obstacle.getnameFishTouchedTheObstacle() == this.getClass().getName()) {
            if (Obstacle.getSideObstacle() == "botTop") {
                setPos_x_target(getPos_x_fish() - counterDecrement);
            } else {
                setPos_y_target(getPos_y_fish() - counterDecrement);
            }
        }
    }

}