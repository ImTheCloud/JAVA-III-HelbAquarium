public class FishPurple extends Fish {
    //////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int corner = 20;// 20 because 0 its the corner and we cant see the fish
    private int speedFish = 6 + Board.get_numberObstacle();

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////
    public FishPurple() {
        set_speedFish(speedFish);
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        ifThePurpleFishTouchAnInsectPlusPellet();
    }

    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifThePurpleFishTouchAnInsectPlusPellet() {
        if (Insect.get_timmerSpeedFish() != getEndOfTheCounter() && Insect.getNameFishTouchInsect() == "FishPurple") {
            set_speedFish(getSpeedUpgrade());// 10 is the boost speed
            ifThePurpleFishTouchAPelletPlusKeyEvent();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - getCounterDecrement());

        } else {
            set_speedFish(speedFish); // base speed
            ifThePurpleFishTouchAPelletPlusKeyEvent();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    private void ifThePurpleFishTouchAPelletPlusKeyEvent() {

        if (Board.get_colourFishKeyPressed() != "FishPurple" && Board.get_colourFishKeyPressed() != "Default") {
            // empty because if the user press the key b,r,o the purple fish cant move
        } else if (EdiblePellet.get_counterToStopMoveFish() == getEndOfTheCounter()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlack" == EdiblePellet.get_NameFishTouchPellet()) {

            if (Obstacle.getnameFishTouchedTheObstacle() == this.getClass().getName()) {

                if (Obstacle.getSideObstacle() == "botTop") {
                    setPos_x_target(getPos_x_fish() - getCounterDecrement());
                } else {
                    setPos_y_target(getPos_y_fish() - getCounterDecrement());
                }
            } else {
                oppositeDirectionofTheRedFish();

            }

            super.update();
        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - getCounterDecrement());
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "M");

        }
    }

    ///////////////////////////////////
    // the fish will go every moment in the farthest corner of the fish red
    // its exactly the farthest position of the fish red
    //////////////////////////////////

    private void oppositeDirectionofTheRedFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                setX(Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish());
                setY(Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish());

                setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                if (getClosestDistance() > getCalculDistance()) {
                    setClosestDistance(getCalculDistance());

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_x_fish());
                }

                if (getPos_x_fish() <= getPos_x_target() && getPos_x_fish() <= getPos_y_target()) {
                    setPos_x_target(corner);
                    setPos_y_target(corner);
                } else if (getPos_x_fish() >= getPos_x_target() && getPos_y_fish() >= getPos_y_target()) {
                    setPos_x_target(get_screen_W());
                    setPos_y_target(get_screen_H());
                } else if (getPos_x_fish() <= getPos_x_target() && getPos_y_fish() >= getPos_y_target()) {
                    setPos_x_target(corner);
                    setPos_y_target(get_screen_H());
                } else {
                    setPos_x_target(get_screen_W());
                    setPos_y_target(corner);
                }

            }

        }
        setClosestDistance(get_screen_W());
    }

}