public class Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private int pos_x_target;
    private int pos_y_target;
    private static int hitBoxFish = 20;
    protected static int screen_W = Board.getB_WIDTH() - hitBoxFish;
    protected static int screen_H = Board.getB_HEIGHT() - hitBoxFish;
    private static int hitBoxOBstacle = 100; // 40 W / 20 H
    private int speedFish;
    private int moveFish;

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public int get_SpeedFish() {
        return speedFish;
    }

    public void set_speedFish(int speedFish) {
        this.speedFish = speedFish;
    }

    public int get_screen_W() {
        return screen_W;
    }

    public int get_screen_H() {
        return screen_H;
    }

    public int getPos_y() {
        return pos_y;
    }

    public int getPos_x() {
        return pos_x;
    }

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

    public void setPos_x(int pos_x) {
        this.pos_x = pos_x;
    }

    public void setPos_y(int pos_y) {
        this.pos_y = pos_y;
    }

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Fish() {
        positionFish();

    }

    public void move() {

        if (getPos_y() < getPos_y_target()) {
            moveFish = getPos_y() + speedFish;
            setPos_y(moveFish);
        }
        if (getPos_x() < getPos_x_target()) {
            moveFish = getPos_x() + speedFish;
            setPos_x(moveFish);
        }
        if (getPos_x() > getPos_x_target()) {
            moveFish = getPos_x() - speedFish;
            setPos_x(moveFish);
        }
        if (getPos_y() > getPos_y_target()) {
            moveFish = getPos_y() - speedFish;
            setPos_y(moveFish);
        }
    }

    ///////////////////////////////////
    // Movement Fish every moment
    //////////////////////////////////
    public void positionFish() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // create a random position for the Fish
    //////////////////////////////////

    public void update() {
        move();
        // couplingFish();
    }

    public void couplingFish() {

        for (int j = 0; j < Board.get_listFish().size(); j++) {

                if (Board.get_listFish().get(j).getClass().getName() == this.getClass().getName()) {

                    // System.out.println("test");
                    // Board.get_listFish().remove(this);
                    // Board.get_listFish().remove(Board.get_listFish().get(j));

                    // Board.addNewFish(this.getClass().getName());

                }

            }

        }
    }

    public void obstacleTouched() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if ((getPos_x() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x())
                    && (getPos_x() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x())
                    && (getPos_y() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y())
                    && (getPos_y() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y())) {
                // System.out.println("obstacle touched");

                if ((getPos_y() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y())
                        || (getPos_y() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y())) {
                    // Board.get_listFish().get(i).setPos_x(Board.get_listFish().get(i).getPos_y() +
                    // 1);

                } else if ((getPos_x() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x())
                        || (getPos_x() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x())) {
                    // Board.get_listFish().get(i).setPos_y(Board.get_listFish().get(i).getPos_x() +
                    // 1);
                }

            }

        }
    }

}
