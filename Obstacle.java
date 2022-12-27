import java.util.ArrayList;

public class Obstacle {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxOBstacleWidth = 40; // / 20 H
    private final int hitBoxOBstacleHeight = 12; // / 20 H

    private static int pos_x_obstacle;
    private int pos_y_obstacle;
    private static boolean fishTouchObstacle = false;

    private final static int idFishTouchInsectByDefault = -1;
    // by default is -1 because if no fish touch insect = no id Fish
    private static int idFishTouchInsect = idFishTouchInsectByDefault;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public static int getIdFishTouchInsect() {
        return idFishTouchInsect;
    }

    public static void setIdFishTouchInsect(int idFishTouchInsect) {
        Obstacle.idFishTouchInsect = idFishTouchInsect;
    }

    public Obstacle() {
        positionRandomObstacle();
    }

    ///////////////////////////////////
    // GET
    //////////////////////////////////

    public static boolean isFishTouchObstacle() {
        return fishTouchObstacle;
    }

    public int getPos_x_obstacle() {
        return pos_x_obstacle;
    }

    public int getPos_y_obstacle() {
        return pos_y_obstacle;
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
        fishTouchObstacle = false;
        idFishTouchInsect = idFishTouchInsectByDefault;
        ArrayList<Fish> get_listFish = Board.get_listFish();
        for (int i = 0; i < get_listFish.size(); i++) {

            Fish fish = get_listFish.get(i);
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if ((getPos_x_obstacle() - hitBoxOBstacleWidth <= pos_x_fish)
                    // for x its *2 hitbox bcs width its longer than height
                    && (getPos_x_obstacle() + hitBoxOBstacleWidth >= pos_x_fish)
                    && (getPos_y_obstacle() - hitBoxOBstacleHeight <= pos_y_fish)
                    && (getPos_y_obstacle() + hitBoxOBstacleHeight >= pos_y_fish)) {

                fishTouchObstacle = true;
                idFishTouchInsect = fish.getIdFish();

            }
        }
    }

}