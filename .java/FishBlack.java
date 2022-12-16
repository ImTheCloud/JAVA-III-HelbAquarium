public class FishBlack extends Fish {
    ///////////////////////////////////
    // The variables&
    //////////////////////////////////
    private static int speedFish = 5;
    private Fish deathFish;
    private int hitBoxFish = 6;
    private double calculDistance = 0;
    private double closestDistance = 1500;
    private int x;
    private int y;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishBlack() {
        set_speedFish(speedFish);

    }

    ///////////////////////////////////
    // the get/set
    //////////////////////////////////

    public static int getSpeed() {
        return speedFish;
    }

    public static void setSpeedUpgrade(int speeedFish) {
        speedFish = speeedFish;
    }

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            moving();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);
        } else {
            setSpeedUpgrade(getSpeed());
            moving();
        }

    }

    public void moving() {

        closestFish();
        if ((getPos_x_fish() >= getPos_x_target() - hitBoxFish) && (getPos_x_fish() <= getPos_x_target() + hitBoxFish)
                && (getPos_y_fish() >= getPos_y_target() - hitBoxFish)
                && (getPos_y_fish() <= getPos_y_target() + hitBoxFish)) {
            fishKilling();
        }
        super.update();

    }

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                x = Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish();
                y = Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                    deathFish = Board.get_listFish().get(i);
                }

            }

        }
        closestDistance = 1500;
    }

    private void fishKilling() {
        Board.get_listFish().remove(deathFish);

    }

}