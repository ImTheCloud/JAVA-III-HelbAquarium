public class Obstacle {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxOBstacle = 20; // / 20 H
    private int pos_x_obstacle;
    private int pos_y_obstacle;
    private static String nameFishTouchedTheObstacle;
    private static String sideObstacle;

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
        pos_x_obstacle = (int) (Math.random() * Board.getB_WIDTH() - (hitBoxOBstacle * 2));
        pos_y_obstacle = (int) (Math.random() * Board.getB_HEIGHT() - hitBoxOBstacle);
        // - hitbox, if not its possible to see the obstacle halfway
        // if is appear at the limit of the screen
    }

    ///////////////////////////////////
    // Method for the obstacle
    // when a obstacle is touched it bypasses it or for the orange take
    // an other random edge
    //////////////////////////////////
    public void obstacleTouched() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if ((getPos_x_obstacle() - (hitBoxOBstacle * 2) <= Board.get_listFish().get(i).getPos_x_fish())
                    // for x its *2 hitbox bcs width its longer than height
                    && (getPos_x_obstacle() + (hitBoxOBstacle * 2) >= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_y_obstacle() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y_fish())
                    && (getPos_y_obstacle() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y_fish())) {

                if ((getPos_x_obstacle() - (hitBoxOBstacle * 2) <= Board.get_listFish().get(i).getPos_x_fish())
                        && (getPos_x_obstacle() + (hitBoxOBstacle * 2) >= Board.get_listFish().get(i)
                                .getPos_x_fish())) {
                    getnameFishTouchedTheObstacle(Board.get_listFish().get(i).getClass().getName());
                    sideObstacle = "botTop";

                } else if ((getPos_y_obstacle() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y_fish())
                        && (getPos_y_obstacle() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y_fish())) {
                    getnameFishTouchedTheObstacle(Board.get_listFish().get(i).getClass().getName());
                }

            } else {
                getnameFishTouchedTheObstacle("");
            }
        }
    }

}