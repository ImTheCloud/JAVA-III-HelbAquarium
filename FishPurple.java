import java.util.ArrayList;

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

        setSpeedFish(speedFish);
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        oppositeDirectionofTheRedFish();
    }

    ///////////////////////////////////
    // the fish will go every moment in the farthest corner of the fish red
    // its exactly the farthest position of the fish red
    //////////////////////////////////

    private void oppositeDirectionofTheRedFish() {

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
                }

                // go to the farthest position of the red fish here

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
        super.update();
    }

}