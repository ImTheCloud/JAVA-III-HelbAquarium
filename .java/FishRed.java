public class FishRed extends Fish {
    ///////////////////////////////////
    // The variables&
    //////////////////////////////////
    private static int speedFish = 5;
    private Fish deathFish;
    private int hitBoxFish = 6;
    private double calculDistance = 0;
    private double closestDistance = Board.getB_WIDTH();
    private int x;
    private int y;

    private boolean stopMoveFishFromKeyEvent = false;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

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
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {
        set_speedFish(speedFish);

        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            moving();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);

        } else {

            set_speedFish(get_SpeedFish());
            moving();
        }

    }

    public void moving() {

        if (Board.get_colourFishKeyPressed() == "FishRed") {
            stopMoveFishFromKeyEvent = true;
        } else {
            stopMoveFishFromKeyEvent = false;
        }
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || stopMoveFishFromKeyEvent == true) {
            closestFish();
            if ((getPos_x_fish() >= getPos_x_target() - hitBoxFish)
                    && (getPos_x_fish() <= getPos_x_target() + hitBoxFish)
                    && (getPos_y_fish() >= getPos_y_target() - hitBoxFish)
                    && (getPos_y_fish() <= getPos_y_target() + hitBoxFish)) {
                fishKilling();

            }
            super.update();
        } else if ("FishPurple" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet() && stopMoveFishFromKeyEvent == false) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "R");

        }
    }

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() != Board.get_listFish().get(i).getClass().getName()
                    && FishBlack.class.getName() != Board.get_listFish().get(i).getClass().getName()) {

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

    private void fishKilling() {
        Board.get_listFish().remove(deathFish);

    }

}