public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int destination_pos_x;
    private static int destination_pos_y;
    private int moveFish;
    private static int speedFish = 3;
    private static int numberEdgeExisting = 3;
    private static int randomEdge;
    private static int[] tab = new int[2];
    private int timmerSpeedInsect = 20;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // Method for a random Edge
    //////////////////////////////////

    public static int[] randomEdgePosition() {

        randomEdge = (int) (Math.random() * numberEdgeExisting);
        if (randomEdge == 0) {
            destination_pos_x = 0;
            destination_pos_y = (int) (Math.random() * screen_H);
        } else if (randomEdge == 1) {
            destination_pos_x = screen_W;
            destination_pos_y = (int) (Math.random() * screen_H);
        } else if (randomEdge == 2) {
            destination_pos_y = 0;
            destination_pos_x = (int) (Math.random() * screen_W);
        } else if (randomEdge == 3) {
            destination_pos_y = screen_H;
            destination_pos_x = (int) (Math.random() * screen_W);
        }

        tab[0] = destination_pos_x;
        tab[1] = destination_pos_y;
        // System.out.println(tab[0]);
        // System.out.println(tab[1]);

        return tab;

    }

    ///////////////////////////////////
    // the get/set
    //////////////////////////////////

    public static int[] get_randomNvlPosition() {
        return randomEdgePosition();
    }

    public static int getSpeedUpgrade() {
        return speedFish;
    }

    public static void setSpeedUpgrade(int speeedFish) {
        speeedFish = speedFish;
    }

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        // if ("FishOrange" != EdiblePellet.get_NameFishTouchPellet()
        // && EdiblePellet.get_counterToStopMoveFish() == 0) {

        // if (Insect.get_nameInsectColour() == "InsectBlack") {

        // }

        if (Insect.getSpeedUpgrade() == 2 && timmerSpeedInsect != 0) {
            if (EdiblePellet.get_counterToStopMoveFish() == 0) {

                if (getPos_y() < destination_pos_y) {
                    moveFish = getPos_y() + 2;

                    setPos_y(moveFish);
                    timmerSpeedInsect--;
                }
                if (getPos_x() < destination_pos_x) {
                    moveFish = getPos_x() + 2;
                    setPos_x(moveFish);
                    timmerSpeedInsect--;
                }
                if (getPos_x() > destination_pos_x) {
                    moveFish = getPos_x() - 2;
                    setPos_x(moveFish);
                    timmerSpeedInsect--;
                }
                if (getPos_y() > destination_pos_y) {
                    moveFish = getPos_y() - 2;
                    setPos_y(moveFish);
                    timmerSpeedInsect--;
                }
            } else {

                EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            }
        } else {
            Insect.setSpeedUpgrade(1);
            timmerSpeedInsect = 10;
            if (EdiblePellet.get_counterToStopMoveFish() == 0) {
                if (getPos_x() <= destination_pos_x + 5
                        && getPos_x() >= destination_pos_x - 5
                        && getPos_y() <= destination_pos_y + 5
                        && getPos_y() >= destination_pos_y - 5) {
                    randomEdgePosition();
                }
                if (getPos_y() < destination_pos_y) {
                    moveFish = getPos_y() + speedFish;

                    setPos_y(moveFish);
                }
                if (getPos_x() < destination_pos_x) {
                    moveFish = getPos_x() + speedFish;
                    setPos_x(moveFish);
                }
                if (getPos_x() > destination_pos_x) {
                    moveFish = getPos_x() - speedFish;
                    setPos_x(moveFish);
                }
                if (getPos_y() > destination_pos_y) {
                    moveFish = getPos_y() - speedFish;
                    setPos_y(moveFish);
                }

            } else {

                EdiblePellet.set_counterToStopMoveFish(EdiblePellet.get_counterToStopMoveFish() - 1);
            }
        }

    }

}
