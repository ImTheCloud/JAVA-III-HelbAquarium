public class FishBlue extends Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int speedFish = 7;

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        setSpeedFish(speedFish);
        directionToFishBlueOrPurple();

    }

    ///////////////////////////////////
    // The blue fish follow the closest fish purple or blue
    //////////////////////////////////

    private void directionToFishBlueOrPurple() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if (FishPurple.class.getName() == Board.get_listFish().get(i).getClass().getName()
                    || FishBlue.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                if (Board.get_listFish().get(i).getPos_x_fish() != this.getPos_x_fish()
                        && Board.get_listFish().get(i).getPos_y_fish() != this.getPos_y_fish()) {

                    setX(Board.get_listFish().get(i).getPos_x_fish() - this.getPos_x_fish());
                    setY(Board.get_listFish().get(i).getPos_y_fish() - this.getPos_y_fish());
                    setCalculDistance(Math.sqrt(getX() * getX() + getY() * getY()));

                    if (getClosestDistance() > getCalculDistance()) {
                        setClosestDistance(getCalculDistance());

                        setPos_x_target(Board.get_listFish().get(i).getPos_x_fish());
                        setPos_y_target(Board.get_listFish().get(i).getPos_y_fish());

                    }
                }

            }

        }
        setClosestDistance(get_screen_W());
        super.update();
    }

}