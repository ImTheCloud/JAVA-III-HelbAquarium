public class FishRed extends Fish {
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

    public FishRed() {
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
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishRed" == EdiblePellet.get_NameFishTouchPellet()) {
            closestFish();
            if ((getPos_x() >= getPos_x_target() - hitBoxFish) && (getPos_x() <= getPos_x_target() + hitBoxFish)
                    && (getPos_y() >= getPos_y_target() - hitBoxFish)
                    && (getPos_y() <= getPos_y_target() + hitBoxFish)) {
                fishKilling();

            }
            super.update();
        } else if ("FishPurple" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "R");

        }
    }

    private void closestFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() != Board.get_listFish().get(i).getClass().getName()) {

                x = Board.get_listFish().get(i).getPos_x() - this.getPos_x();
                y = Board.get_listFish().get(i).getPos_y() - this.getPos_y();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y());

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