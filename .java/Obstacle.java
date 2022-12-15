
public class Obstacle {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;

    private static int hitBoxOBstacle = 20; // 40 W / 20 H
    protected int screen_W = Board.getB_WIDTH() - (hitBoxOBstacle * 2); // *2 because it's a rectangle not a square
    protected int screen_H = Board.getB_HEIGHT() - hitBoxOBstacle;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Obstacle() {
        pos_x = (int) (Math.random() * screen_W);
        pos_y = (int) (Math.random() * screen_H);
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public int getPos_x() {
        return pos_x;
    }

    public int getPos_y() {
        return pos_y;
    }

    public void update() {
        obstacleTouched();

    }

    public void obstacleTouched() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if ((getPos_x() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_x())
                    && (getPos_x() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_x())
                    && (getPos_y() - hitBoxOBstacle <= Board.get_listFish().get(i).getPos_y())
                    && (getPos_y() + hitBoxOBstacle >= Board.get_listFish().get(i).getPos_y())) {
                System.out.println("obstacle touched");

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