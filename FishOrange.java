public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int numberEdgeExisting = 3; // 0,1,2,3 = 4 edge
    private final int speedFish = 6; // base speed
    private static int randomEdge;

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {
        set_speedFish(speedFish);
        moveFishOrange();
    }

    ///////////////////////////////////
    // If the fish touch a pellet
    // he will stop every other fish who dont have the same colour than him
    //////////////////////////////////

    public void moveFishOrange() {

        if (getPos_x_fish() <= getPos_x_target() + getHitBoxFish()
                && getPos_x_fish() >= getPos_x_target() - getHitBoxFish()
                && getPos_y_fish() <= getPos_y_target() + getHitBoxFish()
                && getPos_y_fish() >= getPos_y_target() - getHitBoxFish()) {
            // hitbox of the target because hes speed his more than 1
            // so in x,y its important to enter its the hitbox of the target
            // to change the edge
            randomEdgePosition();
        }

        super.update();

    }

    ///////////////////////////////////
    // Method for a random Edge (target of the orange fish)
    // calculate exactly for evry condition a random position in the edge
    //////////////////////////////////

    public void randomEdgePosition() {

        randomEdge = (int) (Math.random() * numberEdgeExisting);
        if (randomEdge == 0) {
            setPos_x_target(0);
            setPos_y_target((int) (Math.random() * screen_H));
        } else if (randomEdge == 1) {
            setPos_x_target(screen_W);
            setPos_y_target((int) (Math.random() * screen_H));
        } else if (randomEdge == 2) {
            setPos_y_target(0);
            setPos_x_target((int) (Math.random() * screen_W));
        } else if (randomEdge == 3) {
            setPos_y_target(screen_H);
            setPos_x_target((int) (Math.random() * screen_W));
        }
    }

}
