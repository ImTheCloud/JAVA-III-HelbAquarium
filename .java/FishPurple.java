public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishRed;
    private static int pos_y_fishRed;
    private int moveFish;
    private int speedFish = 3 + Board.get_speed_fish();
    private double closestDistance = 1000;
    private double calculDistance = 0;
    private int x;
    private int y;
    private double newDistance;
    private int destination_pos_x;
    private int destination_pos_y;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int test_pos_x = getPos_x() + i;
                int test_pos_y = getPos_x() + j;

                x = pos_x_fishRed - test_pos_x;
                y = pos_y_fishRed - test_pos_y;

                newDistance = Math.sqrt(x * x + y * y);
                if (closestDistance < newDistance) {
                    if (test_pos_x >= get_screen_W() || test_pos_x <= 0) {
                        destination_pos_y = test_pos_y;
                    } else if (test_pos_y >= get_screen_H() || test_pos_y <= 0) {
                        destination_pos_x = test_pos_x;
                    } else {
                        destination_pos_x = test_pos_x;
                        destination_pos_y = test_pos_y;
                    }

                }

            }

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

    }

}