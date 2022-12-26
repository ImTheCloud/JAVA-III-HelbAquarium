public class FishRed extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int key3Press = 10;// 10 its the upgrade speed of the fish red, when key 3 its pressed
    private static int speedFish = 6;

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
        set_speedFish(speedFish);
        moveFishRed();
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void moveFishRed() {
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
    // the fish will kill every fish,
    // he follos first the closest fish but not the black
    //////////////////////////////////

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() != Board.get_listFish().get(i).getClass().getName()
                    && FishBlack.class.getName() != Board.get_listFish().get(i).getClass().getName()) {

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
    // Kill the fish who is touched by the red
    //////////////////////////////////
    private void fishKilling() {
        Board.deleteFish(getIdTargetDeathFish());

    }

}