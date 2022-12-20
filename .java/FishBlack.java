public class FishBlack extends Fish {
    ///////////////////////////////////
    // The variables&
    //////////////////////////////////
    private final int speedFish = 6; // base speed

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        ifTheBlackFishTouchAnInsect();
    }
    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifTheBlackFishTouchAnInsect() {
        if (Insect.get_timmerSpeedFish() != getEndOfTheCounter() && Insect.getNameFishTouchInsect() == "FishBlack") {
            set_speedFish(getSpeedUpgrade()); // boost speed 11
            killFishRed();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - getCounterDecrement());
        } else {
            set_speedFish(speedFish); // base speed
            killFishRed();
        }
    }

    ///////////////////////////////////
    // the fish will follow the closest fish red and he will kill him
    //////////////////////////////////
    public void killFishRed() {

        closestFish();
        if ((getPos_x_fish() >= getPos_x_target() - getHitBoxFish())
                && (getPos_x_fish() <= getPos_x_target() + getHitBoxFish())
                && (getPos_y_fish() >= getPos_y_target() - getHitBoxFish())
                && (getPos_y_fish() <= getPos_y_target() + getHitBoxFish())) {
            fishKilling();
        }
        super.update();

    }

    ///////////////////////////////////
    // method to calculate the closest fish red
    //////////////////////////////////

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                setX(Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish());
                setY(Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish());

                setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                if (getClosestDistance() > getCalculDistance()) {
                    setClosestDistance(getCalculDistance());

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                    setDeathFish(Board.get_listFish().get(i));
                }

            }

        }
        setClosestDistance(get_screen_W());
    }

    ///////////////////////////////////
    // method to kill fish red
    //////////////////////////////////

    private void fishKilling() {
        Board.get_listFish().remove(getDeathFish());

    }

}