public class FishBlue extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int speedFish = 6;
    private double calculDistance;
    private double closestDistance = 1500;
    private int x;
    private int y;

    private boolean stopMoveFishFromKeyEvent = false;
    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishBlue() {
        set_speedFish(speedFish);
    }

    ///////////////////////////////////
    // Method called every moment for a chhange, here for move
    //////////////////////////////////

    @Override
    public void update() {
        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            moving();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);
        } else {
            speedFish = 6;
            moving();
        }
    }

    public void moving() {

        if (Board.get_colourFishKeyPressed() == "FishBlue") {
            stopMoveFishFromKeyEvent = true;
        } else {
            stopMoveFishFromKeyEvent = false;
        }
        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || stopMoveFishFromKeyEvent == true) {

            directionToFishBlueOrPurple();

            super.update();

        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()
                || "FishPurple" == EdiblePellet.get_NameFishTouchPellet() && stopMoveFishFromKeyEvent == false) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "B");

        }
    }

    private void directionToFishBlueOrPurple() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if (FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()
                    || ((FishBlue.class.getName() == Board.get_listFish().get(i).getClass().getName())
                            && (FishBlue.class.getName() != Board.get_listFish().get(i).getClass().getName()))) {

                x = Board.get_listFish().get(i).getPos_x() - this.getPos_x();
                y = Board.get_listFish().get(i).getPos_y() - this.getPos_y();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y());

                }
            }

        }
        closestDistance = 1500;
    }

}