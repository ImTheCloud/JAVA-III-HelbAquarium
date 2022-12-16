public class FishPurple extends Fish {
    //////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int corner = 20;// 20 because 0 its the corner and we cant see the fish
    private double calculDistance = 0;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x; // calcul for the closest distance
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
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        ifThePurpleFishTouchAnInsectPlusPellet();
    }

    ///////////////////////////////////
    // If the fish touch an insect
    // hes speed upgrade for a definite time in the class insect
    //////////////////////////////////

    public void ifThePurpleFishTouchAnInsectPlusPellet() {
        if (Insect.get_timmerSpeedFish() != 0) {
            speedFish = 8;
            ifThePurpleFishTouchAPellet();
            Insect.set_timmerSpeedFish(Insect.get_timmerSpeedFish() - 1);
        } else {
            speedFish = 5 + Board.get_numberObstacle();
            ifThePurpleFishTouchAPellet();
        }
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    private void ifThePurpleFishTouchAPellet() {

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

    ///////////////////////////////////
    // the fish will go every moment in the farthest corner of the fish red
    // its exactly the farthest position of the fish red
    //////////////////////////////////

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
        closestDistance = Board.getB_WIDTH();
    }

}