public class FishBlue extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int speedFish = 7;

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        ifTheBlueFishTouchAnInsectPlusPellet();
    }

    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifTheBlueFishTouchAnInsectPlusPellet() {
        if (Insect.get_timmerSpeedFish() != getEndOfTheCounter()) {
            set_speedFish(getSpeedUpgrade()); // upgrade speed 7 to 10
            ifTheBlueFishTouchAPelletPlusKeyEvent();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - getCounterDecrement());

        } else {
            set_speedFish(speedFish);
            ifTheBlueFishTouchAPelletPlusKeyEvent();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void ifTheBlueFishTouchAPelletPlusKeyEvent() {

        if (Board.get_colourFishKeyPressed() != "FishBlue" && Board.get_colourFishKeyPressed() != "Default") {
            // empty because if the user press the key r,m,o the blue fish cant move
        } else if (EdiblePellet.get_counterToStopMoveFish() == getEndOfTheCounter()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlack" == EdiblePellet.get_NameFishTouchPellet()) {

            if (Obstacle.getnameFishTouchedTheObstacle() == this.getClass().getName()) {

                setPos_x_target(getPos_x_fish() - getCounterDecrement());
                Obstacle.setnameFishTouchedTheObstacle("");

            } else {
                directionToFishBlueOrPurple();
            }

            super.update();

        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - getCounterDecrement());

        }
    }

    ///////////////////////////////////
    // The blue fish follow the closest fish purple or blue
    //////////////////////////////////

    private void directionToFishBlueOrPurple() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if (FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()
                    || FishBlue.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                if (Board.get_listFish().get(i).getPos_x_fish() != this.getPos_x_fish()
                        && Board.get_listFish().get(i).getPos_y_fish() != this.getPos_y_fish()) {

                    setX(Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish());
                    setY(Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish());
                    setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                    if (getClosestDistance() > getCalculDistance()) {
                        setClosestDistance(getCalculDistance());

                        setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                        setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                    }
                }

            }

        }
        setClosestDistance(get_screen_W());
    }

}