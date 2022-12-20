public class Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    protected final int endOfTheCounter = 0;
    private final int counterDecrement = 1;
    private final static int sizeFish = 20; // 20 beacause its the zise of the fish
    protected final static int screen_W = Board.getB_WIDTH() - sizeFish;
    // protected, this variable can be used in other class extends the fish
    // - sizeFish, if not its possible to see the fish halfway
    // if is appear at the limit of the screen
    private final static int screen_H = Board.getB_HEIGHT() - sizeFish;
    private final int speedUpgrade = 11; // 11 if a fish touch a insect
    private Fish deathFish;
    private int pos_x_Fish; // position of the fish will be random
    private int pos_y_Fish;
    private int pos_x_target; // target of every fish
    private int pos_y_target;
    private int speedFish; // important to put the good speed for every fish
    private double calculDistance = 0;
    private double closestDistance = Board.getB_WIDTH();
    // by default its the width but when the calcul start the closest
    // distance become the closest distance of the fish
    private int x;// calcul for the closest distance
    private int y;
    private boolean stopMoveFishFromKeyEvent = false; // stop move fish from key R,M,B,O
    private static int hitBoxFish = 12; // 12 bcs if the speed upgrade to 11, the hitbox need to be bigger

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Fish() {
        positionFish(); // put a random position for every fish
    }

    ///////////////////////////////////
    // get and set
    //////////////////////////////////
    // Hitbox
    public static int getHitBoxFish() {
        return hitBoxFish;
    }

    // speed upgrade
    public int getSpeedUpgrade() {
        return speedUpgrade;
    }

    // calcul closest distance
    public double getCalculDistance() {
        return calculDistance;
    }

    public void setCalculDistance(double calculDistance) {
        this.calculDistance = calculDistance;
    }

    public double getClosestDistance() {
        return closestDistance;
    }

    public void setClosestDistance(double closestDistance) {
        this.closestDistance = closestDistance;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // screen
    public int get_screen_W() {
        return screen_W;
    }

    public int get_screen_H() {
        return screen_H;
    }

    // speed
    public int get_SpeedFish() {
        return speedFish;
    }

    public void set_speedFish(int speedFish) {
        this.speedFish = speedFish;
    }

    // Fish
    public int getPos_y_fish() {
        return pos_y_Fish;
    }

    public int getPos_x_fish() {
        return pos_x_Fish;
    }

    public void setPos_x_Fish(int pos_x) {
        this.pos_x_Fish = pos_x;
    }

    public void setPos_y_Fish(int pos_y) {
        this.pos_y_Fish = pos_y;
    }
    // target Fish

    public int getPos_y_target() {
        return pos_y_target;
    }

    public int getPos_x_target() {
        return pos_x_target;
    }

    public void setPos_x_target(int pos_x_target) {
        this.pos_x_target = pos_x_target;
    }

    public void setPos_y_target(int pos_y_target) {
        this.pos_y_target = pos_y_target;
    }

    // counter
    public int getEndOfTheCounter() {
        return endOfTheCounter;
    }

    public int getCounterDecrement() {
        return counterDecrement;
    }

    // death fish
    public Fish getDeathFish() {
        return deathFish;
    }

    public void setDeathFish(Fish deathFish) {
        this.deathFish = deathFish;
    }
    // boolean to stop or not the fish from touch key

    public boolean getIsStopMoveFishFromKeyEvent() {
        return stopMoveFishFromKeyEvent;
    }

    public void setStopMoveFishFromKeyEvent(boolean stopMoveFishFromKeyEvent) {
        this.stopMoveFishFromKeyEvent = stopMoveFishFromKeyEvent;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        movefishToTarget();
        couplingFish();
    }

    ///////////////////////////////////
    // Movement for the fish, same just a different target dependant
    // of the behavior of the fish
    // if the pos x its smaler than the pos x target the pos x
    // will just decrement (speed), etc..
    //////////////////////////////////

    public void movefishToTarget() {

        if (getPos_y_fish() < getPos_y_target()) {
            setPos_y_Fish(getPos_y_fish() + speedFish);
        }
        if (getPos_x_fish() < getPos_x_target()) {
            setPos_x_Fish(getPos_x_fish() + speedFish);
        }
        if (getPos_x_fish() > getPos_x_target()) {
            setPos_x_Fish(getPos_x_fish() - speedFish);
        }
        if (getPos_y_fish() > getPos_y_target()) {
            setPos_y_Fish(getPos_y_fish() - speedFish);
        }
    }

    ///////////////////////////////////
    // Method for put a fish in a random position ah the beginning
    //////////////////////////////////
    public void positionFish() {
        pos_x_Fish = (int) (Math.random() * screen_W);
        pos_y_Fish = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // Method for the couple of the fish
    //////////////////////////////////

    public void couplingFish() {

        for (int j = 0; j < Board.get_listFish().size(); j++) {

            if (Board.get_listFish().get(j).getPos_x_fish() == this.getPos_x_fish()) {
                if (Board.get_listFish().get(j).getClass().getName() == this.getClass().getName()) {

                    // Board.get_listFish().remove(Board.get_listFish().get(j));
                    // for (int i = 0; i < 3; i++) {
                    // Board.addNewFish(this.getClass().getName());
                    // }

                }

            }

        }
    }

}
