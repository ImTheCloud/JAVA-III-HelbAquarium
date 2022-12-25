public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int numberEdgeExisting = 3; // 0,1,2,3 = 4 edge
    private final int speedFish = 6; // base speed
    private static int randomEdge;

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {

        ifTheOrangeFishTouchAnInsectPlusPellet();
    }

    ///////////////////////////////////
    // Method for a random Edge (target of the orange fish)
    // calculate exactly for evry condition a random position in the edge
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
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifTheOrangeFishTouchAnInsectPlusPellet() {
        if (Insect.get_timmerSpeedFish() != getEndOfTheCounter() && Insect.getNameFishTouchInsect() == "FishOrange") {
            set_speedFish(getSpeedUpgrade());
            ifTheOrangeFishTouchAPelletPlusKeyEvent();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - getCounterDecrement());

        } else {
            set_speedFish(speedFish);
            ifTheOrangeFishTouchAPelletPlusKeyEvent();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void ifTheOrangeFishTouchAPelletPlusKeyEvent() {

        if (Board.get_colourFishKeyPressed() != "FishOrange" && Board.get_colourFishKeyPressed() != "Default") {
            // empty because if the user press the key b,m,r the orange fish cant move
        } else if (EdiblePellet.get_counterToStopMoveFish() == getEndOfTheCounter()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlack" == EdiblePellet.get_NameFishTouchPellet()) {

            if (getPos_x_fish() <= getPos_x_target() + getHitBoxFish()
                    && getPos_x_fish() >= getPos_x_target() - getHitBoxFish()
                    && getPos_y_fish() <= getPos_y_target() + getHitBoxFish()
                    && getPos_y_fish() >= getPos_y_target() - getHitBoxFish()) {
                // hitbox of the target because hes speed his more than 1
                // so in x,y its important to enter its the hitbox of the target
                // to change the edge

                randomEdgePosition();
            }

            super.update();

        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - getCounterDecrement());
        }
    }

}
