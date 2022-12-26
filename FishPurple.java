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
        set_speedFish(speedFish);
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

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                setX(Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish());
                setY(Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish());

                setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                if (getClosestDistance() > getCalculDistance()) {
                    setClosestDistance(getCalculDistance());

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

        setClosestDistance(get_screen_W());
        super.update();
    }

}