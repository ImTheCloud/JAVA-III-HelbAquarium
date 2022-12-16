public class Fish {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x_Fish;
    private int pos_y_Fish;
    private int pos_x_target;
    private int pos_y_target;
    private static int sizeFish = 20;
    protected static int screen_W = Board.getB_WIDTH() - sizeFish;
    // - sizeFish, if not its possible to see the pellet halfway
    // if is appear at the limit of the screen
    protected static int screen_H = Board.getB_HEIGHT() - sizeFish;
    private static int hitBoxOBstacle = 100; // 40 W / 20 H
    private int speedFish;

    ///////////////////////////////////
    // get and set
    //////////////////////////////////
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

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Fish() {
        positionFish();

    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        move();
        // couplingFish();
    }

    ///////////////////////////////////
    // Movement for every fish
    //////////////////////////////////

    public void move() {

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

                    // System.out.println("test");
                    // Board.get_listFish().remove(this);
                    // Board.get_listFish().remove(Board.get_listFish().get(j));

                    // Board.addNewFish(this.getClass().getName());

                }

            }

        }
    }

    ///////////////////////////////////
    // Method for the obstacle
    // when a obstacle is touched it bypasses it
    //////////////////////////////////

    public void obstacleTouched() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if ((getPos_x_fish() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_x_fish() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_y_fish() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y_fish())
                    && (getPos_y_fish() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y_fish())) {
                // System.out.println("obstacle touched");

                if ((getPos_y_fish() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y_fish())
                        || (getPos_y_fish() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y_fish())) {
                    // Board.get_listFish().get(i).setPos_x(Board.get_listFish().get(i).getPos_y() +
                    // 1);

                } else if ((getPos_x_fish() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x_fish())
                        || (getPos_x_fish() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x_fish())) {
                    // Board.get_listFish().get(i).setPos_y(Board.get_listFish().get(i).getPos_x() +
                    // 1);
                }

            }

        }
    }

}
