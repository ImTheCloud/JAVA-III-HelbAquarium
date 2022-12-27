public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int numberEdgeExisting = 3; // 0,1,2,3 = 4 edge
    private final int speedFish = 6; // base speed
    private static int randomEdge;
    private final int randomEdgenumberOne = 0;
    private final int randomEdgenumberTwo = 1;
    private final int randomEdgenumberThree = 2;
    private final int randomEdgenumberFour = 3;

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    @Override
    public void update() {

        setSpeedFish(speedFish);

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
        if (randomEdge == randomEdgenumberOne) {
            setPos_x_target(0); // 0 is the edge left
            setPos_y_target((int) (Math.random() * screen_H));
        } else if (randomEdge == randomEdgenumberTwo) {
            setPos_x_target(screen_W); // screen_W is the edge right
            setPos_y_target((int) (Math.random() * screen_H));
        } else if (randomEdge == randomEdgenumberThree) {
            setPos_y_target(0); // 0 is the edge top
            setPos_x_target((int) (Math.random() * screen_W));
        } else if (randomEdge == randomEdgenumberFour) {
            setPos_y_target(screen_H);// screen_W is the edge bottom
            setPos_x_target((int) (Math.random() * screen_W));
        }
    }

}
