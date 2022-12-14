import java.util.ArrayList;

public class Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private int pos_x;
    private int pos_y;
    private static int hitBoxFish = 20;
    protected static int screen_W = Board.getB_WIDTH() - hitBoxFish;
    protected static int screen_H = Board.getB_HEIGHT() - hitBoxFish;
    private static int hitBoxOBstacle = 20; // 40 W / 20 H

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

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

        System.out.println();
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
        // couplingFish();
        // obstacleTouched();
    }

    public void couplingFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            for (int j = 0; j < Board.get_listFish().size(); j++) {

                if (Board.get_listFish().get(j).getClass().getName() == Board.get_listFish().get(i).getClass()
                        .getName()) {
                    if (Board.get_listFish().get(j).getPos_x() <= Board.get_listFish().get(i).getPos_x() + 20
                            && Board.get_listFish().get(j).getPos_x() >= Board.get_listFish().get(i).getPos_x() - 20
                            && Board.get_listFish().get(j).getPos_y() <= Board.get_listFish().get(i).getPos_y() + 20
                            && Board.get_listFish().get(j).getPos_y() >= Board.get_listFish().get(i).getPos_y() - 20) {

                        Board.get_listFish().remove(Board.get_listFish().get(i));
                        Board.get_listFish().remove(Board.get_listFish().get(j));

                        Board.get_listFish().add(Board.get_listFish().get(i));
                        Board.get_listFish().add(Board.get_listFish().get(i));
                        Board.get_listFish().add(Board.get_listFish().get(i));

                    }

                }
            }

        }
    }

    public void obstacleTouched() {
        ArrayList<Obstacle> obstacleList = Board.get_listObstacle();
        for (Obstacle obstacle : obstacleList) {
            if ((getPos_x() <= obstacle.getPos_x() + hitBoxOBstacle)
                    && (getPos_x() >= obstacle.getPos_x() - hitBoxOBstacle)
                    && (getPos_y() <= obstacle.getPos_y() + hitBoxOBstacle)
                    && (getPos_y() >= obstacle.getPos_y() - hitBoxOBstacle)) {

                if ((getPos_y() <= obstacle.getPos_y() + hitBoxOBstacle)
                        || (getPos_y() >= obstacle.getPos_y() - hitBoxOBstacle)) {
                    pos_x += 1;
                } else {
                    pos_y += 1;
                }

            }
        }
    }

}
