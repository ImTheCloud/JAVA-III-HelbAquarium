public class Obstacle {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxOBstacleWidth = 40; // / 20 H
    private final int hitBoxOBstacleHeight = 12; // / 20 H
    private static String nameFishTouchedTheObstacle;

    private int pos_x_obstacle;
    private int pos_y_obstacle;

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

    public static String getnameFishTouchedTheObstacle() {
        return nameFishTouchedTheObstacle;
    }

    public static void setnameFishTouchedTheObstacle(String nameFishToucehdTheObstacleChange) {
        nameFishTouchedTheObstacle = nameFishToucehdTheObstacleChange;
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
        for (int i = 0; i < Board.get_listFish().size(); i++) {
            if ((getPos_x_obstacle() - hitBoxOBstacleWidth <= Board.get_listFish().get(i).getPos_x_fish())
                    // for x its *2 hitbox bcs width its longer than height
                    && (getPos_x_obstacle() + hitBoxOBstacleWidth >= Board.get_listFish().get(i).getPos_x_fish())
                    && (getPos_y_obstacle() - hitBoxOBstacleHeight <= Board.get_listFish().get(i).getPos_y_fish())
                    && (getPos_y_obstacle() + hitBoxOBstacleHeight >= Board.get_listFish().get(i).getPos_y_fish())) {

                setnameFishTouchedTheObstacle(Board.get_listFish().get(i).getClass().getName());

            }
        }
    }

}