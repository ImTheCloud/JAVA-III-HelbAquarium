public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private double calculDistance = 0;
    private double closestDistance = 1500;
    private int x;
    private int y;
    private int speedFish = 3 + Board.get_speed_fish();

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        if (EdiblePellet.get_counterToStopMoveFish() == 0 || "FishPurple" == EdiblePellet.get_NameFishTouchPellet()) {

            oppositeDirectionofTheRedFish();

            super.move(speedFish);
        } else if ("FishRed" == EdiblePellet.get_NameFishTouchPellet()
                || "FishBlue" == EdiblePellet.get_NameFishTouchPellet()
                || "FishOrange" == EdiblePellet.get_NameFishTouchPellet()) {
            EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            // System.out.println(EdiblePellet.get_counterToStopMoveFish() + "M");

        }

    }

    private void oppositeDirectionofTheRedFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                x = Board.get_listFish().get(i).getPos_x() - this.getPos_x();
                y = Board.get_listFish().get(i).getPos_y() - this.getPos_y();

                calculDistance = Math.sqrt(x * x + y * y);

                if (closestDistance > calculDistance) {
                    closestDistance = calculDistance;

                    setPos_x_target(Board.get_listFish().get(i).getPos_x());
                    setPos_y_target(Board.get_listFish().get(i).getPos_y());
                }

                if (getPos_x() <= getPos_x_target() && getPos_x() <= getPos_y_target()) {
                    setPos_x_target(10); // 5 because 0 its the edge and we cant see the fish
                    setPos_y_target(10);
                } else if (getPos_x() >= getPos_x_target() && getPos_y() >= getPos_y_target()) {
                    setPos_x_target(get_screen_W()); // 5 because 0 its the edge and we cant see the fish
                    setPos_y_target(get_screen_H());
                } else if (getPos_x() <= getPos_x_target() && getPos_y() >= getPos_y_target()) {
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