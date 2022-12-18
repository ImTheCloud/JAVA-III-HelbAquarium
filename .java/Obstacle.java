public class Obstacle {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x_obstacle;
    private int pos_y_obstacle;
    private static String nameFishTouchedTheObstacle;
    private static String sideObstacle;

    private final int hitBoxOBstacle = 20; // 40 W / 20 H

    protected int screen_W = Board.getB_WIDTH() - (hitBoxOBstacle * 2); // *2 because it's a rectangle not a square
    protected int screen_H = Board.getB_HEIGHT() - hitBoxOBstacle;
    // - hitbox, if not its possible to see the obstacle halfway
    // if is appear at the limit of the screen

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

    public int getHitBoxOBstacle() {
        return hitBoxOBstacle;
    }

    public static String getnameFishTouchedTheObstacle() {
        return nameFishTouchedTheObstacle;
    }

    public static void getnameFishTouchedTheObstacle(String nameFishToucehdTheObstacleChange) {
        nameFishTouchedTheObstacle = nameFishToucehdTheObstacleChange;
    }

    public static String getSideObstacle() {
        return sideObstacle;
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
        pos_x_obstacle = (int) (Math.random() * screen_W);
        pos_y_obstacle = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // Method for the obstacle
    // when a obstacle is touched it bypasses it
    //////////////////////////////////
    public void obstacleTouched() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if ((getPos_x_obstacle() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_x_obstacle() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_y_obstacle() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y_fish())
                    && (getPos_y_obstacle() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y_fish())) {

                if ((getPos_x_obstacle() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x_fish())
                        && (getPos_x_obstacle() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x_fish())) {
                    getnameFishTouchedTheObstacle(Board.get_listFish().get(i).getClass().getName());
                    sideObstacle = "botTop";

                } else if ((getPos_y_obstacle() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y_fish())
                        && (getPos_y_obstacle() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y_fish())) {
                    getnameFishTouchedTheObstacle(Board.get_listFish().get(i).getClass().getName());
                    sideObstacle = "rightLeft";
                }

            } else {
                getnameFishTouchedTheObstacle("");
            }
        }
    }

}