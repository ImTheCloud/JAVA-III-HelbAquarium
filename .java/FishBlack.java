public class FishBlack extends Fish {
    ///////////////////////////////////
    // The variables&
    //////////////////////////////////
    private static int speedFish = 6;
    private Fish deathFish;
    private int hitBoxFish = 6;
    private double calculDistance = 0;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x;// calcul for the closest distance
    private int y;
    private final int endOfTheCounter = 0;
    private final int counterDecrement = 1;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishBlack() {
        set_speedFish(speedFish);

    }

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
        if (Insect.get_timmerSpeedFish() != endOfTheCounter && Insect.getNameFishTouchInsect() == "FishBlack") {
            speedFish = 11; // boost speed 11
            killFishRed();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - counterDecrement);
        } else {
            speedFish = 6; // base speed
            killFishRed();
        }
    }

    ///////////////////////////////////
    // the fish will follow the closest fish red and he will kill him
    //////////////////////////////////
    public void killFishRed() {

        closestFish();
        if ((getPos_x_fish() >= getPos_x_target() - hitBoxFish) && (getPos_x_fish() <= getPos_x_target() + hitBoxFish)
                && (getPos_y_fish() >= getPos_y_target() - hitBoxFish)
                && (getPos_y_fish() <= getPos_y_target() + hitBoxFish)) {
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
        closestDistance = Board.getB_WIDTH();
    }

    ///////////////////////////////////
    // method to kill fish red
    //////////////////////////////////

    private void fishKilling() {
        Board.get_listFish().remove(deathFish);

    }

}