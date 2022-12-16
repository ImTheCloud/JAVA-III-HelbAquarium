public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private double calculDistance = 0;
    private double closestDistance = 1500;
    private int x;
    private int y;
    private int speedFish = 5 + Board.get_numberObstacle();

    private boolean stopMoveFishFromKeyEvent = false;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////
    public FishPurple() {
        set_speedFish(speedFish);
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
            speedFish = 5 + Board.get_numberObstacle();
            moving();
        }

    }

    private void moving() {

        if (Board.get_colourFishKeyPressed() == "FishPurple") {
            stopMoveFishFromKeyEvent = true;
        } else {
            stopMoveFishFromKeyEvent = false;
        }

        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()
                || stopMoveFishFromKeyEvent == true) {

            oppositeDirectionofTheRedFish();

            super.update();
        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet() && stopMoveFishFromKeyEvent == false) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "M");

        }
    }

    private void oppositeDirectionofTheRedFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                x = Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish();
                y = Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                    setPos_y_target(Board.get_listFish().get(i).getPos_x_fish());
                }

                if (getPos_x_fish() <= getPos_x_target() && getPos_x_fish() <= getPos_y_target()) {
                    setPos_x_target(10); // 5 because 0 its the edge and we cant see the fish
                    setPos_y_target(10);
                } else if (getPos_x_fish() >= getPos_x_target() && getPos_y_fish() >= getPos_y_target()) {
                    setPos_x_target(get_screen_W()); // 5 because 0 its the edge and we cant see the fish
                    setPos_y_target(get_screen_H());
                } else if (getPos_x_fish() <= getPos_x_target() && getPos_y_fish() >= getPos_y_target()) {
                    setPos_x_target(10);
                    setPos_y_target(get_screen_H());
                } else {
                    setPos_x_target(get_screen_W());
                    setPos_y_target(10);
                }

            }

        }
        closestDistance = 1500;
    }

}