public class Obstacle {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x_obstacle;
    private int pos_y_obstacle;

    private static int hitBoxOBstacle = 20; // 40 W / 20 H
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

    ///////////////////////////////////
    // Method for put a obstacle in a random position at the beginning
    //////////////////////////////////

    public void positionRandomObstacle() {
        pos_x_obstacle = (int) (Math.random() * screen_W);
        pos_y_obstacle = (int) (Math.random() * screen_H);
    }

}