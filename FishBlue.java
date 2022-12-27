import java.util.ArrayList;

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
        setSpeedFish(speedFish);
        directionToFishBlueOrPurple();

    }

    ///////////////////////////////////
    // The blue fish follow the closest fish purple or blue
    //////////////////////////////////

    private void directionToFishBlueOrPurple() {

        ArrayList<Fish> get_listFish = Board.get_listFish();
        for (int i = 0; i < get_listFish.size(); i++) {

            Fish fish = get_listFish.get(i);
            String nameFishCurrent = fish.getClass().getName();
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if (FishPurple.class.getName() == nameFishCurrent
                    || FishBlue.class.getName() == nameFishCurrent) {

                if (pos_x_fish != this.getPos_x_fish()
                        && pos_y_fish != this.getPos_y_fish()) {

                    setX(pos_x_fish - this.getPos_x_fish());
                    setY(pos_y_fish - this.getPos_y_fish());
                    setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                    if (getClosestDistance() > getCalculDistance()) {
                        setClosestDistance(getCalculDistance());

                        setPos_x_target(pos_x_fish);
                        setPos_y_target(pos_y_fish);

                    }
                }

            }

        }
        setClosestDistance(get_screen_W());
        super.update();
    }

}