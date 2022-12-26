public class Obstacle {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxOBstacleWidth = 40; // / 20 H
    private final int hitBoxOBstacleHeight = 12; // / 20 H

    private int pos_x_obstacle;
    private int pos_y_obstacle;
    private static boolean posOk = true;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Obstacle() {
        positionRandomObstacle();
    }

    ///////////////////////////////////
    // GET
    //////////////////////////////////

    public int getPos_x_obstacle() {
        return pos_x_obstacle;
    }

    public int getPos_y_obstacle() {
        return pos_y_obstacle;
    }

    public static boolean isPosOk() {
        return posOk;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        obstacleTouched();
    }

    ///////////////////////////////////
    // Method for put a obstacle in a random position at the beginning
    //////////////////////////////////

    public void positionRandomObstacle() {
        pos_x_obstacle = (int) (Math.random() * Board.getB_WIDTH() - hitBoxOBstacleWidth);
        pos_y_obstacle = (int) (Math.random() * Board.getB_HEIGHT() - hitBoxOBstacleHeight);
        // - hitbox, if not its possible to see the obstacle halfway
        // if is appear at the limit of the screen
    }

    ///////////////////////////////////
    // Method for the obstacle
    // when a obstacle is touched it bypasses it or for the orange take
    // an other random edge
    //////////////////////////////////
    public void obstacleTouched() {
        posOk = true;
        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if ((getPos_x_obstacle() - hitBoxOBstacleWidth <= Board.get_listFish().get(i).getPos_x_fish())
                    // for x its *2 hitbox bcs width its longer than height
                    && (getPos_x_obstacle() + hitBoxOBstacleWidth >= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_y_obstacle() - hitBoxOBstacleHeight <= Board.get_listFish().get(i).getPos_y_fish())
                    && (getPos_y_obstacle() + hitBoxOBstacleHeight >= Board.get_listFish().get(i).getPos_y_fish())) {

                posOk = false;

            }
        }
    }

}