import java.util.ArrayList;

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

        ArrayList<Fish> get_listFish = Board.get_listFish();
        for (int i = 0; i < get_listFish.size(); i++) {

            Fish fish = get_listFish.get(i);
            String nameFishCurrent = fish.getClass().getName();
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if (FishRed.class.getName() == nameFishCurrent) {

                setX(pos_x_fish - this.getPos_x_fish());
                setY(pos_y_fish - this.getPos_y_fish());

                setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                if (getClosestDistance() > getCalculDistance()) {
                    setClosestDistance(getCalculDistance());

                    setPos_x_target(pos_x_fish);
                    setPos_y_target(pos_y_fish);

                    setIdTargetDeathFish(fish.getIdFish());
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