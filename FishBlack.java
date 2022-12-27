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
        setSpeedFish(speedFish);
        moveFishBlack();
    }

    ///////////////////////////////////
    // the fish will follow the closest fish red and he will kill him
    //////////////////////////////////
    public void moveFishBlack() {

        closestFishRed();

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

    private void closestFishRed() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                setX(Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish());
                setY(Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish());

                setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                if (getClosestDistance() > getCalculDistance()) {
                    setClosestDistance(getCalculDistance());

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                    setIdTargetDeathFish(Board.get_listFish().get(i).getIdFish());
                }

            }

        }
        setClosestDistance(get_screen_W());
    }

    ///////////////////////////////////
    // method to kill fish red
    //////////////////////////////////

    private void fishKilling() {
        Board.deleteFish(getIdTargetDeathFish());

    }

}