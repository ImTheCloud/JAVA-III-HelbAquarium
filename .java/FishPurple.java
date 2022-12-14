public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int pos_x_fishRed;
    private static int pos_y_fishRed;
    private int moveFish;
    private int speedFish = 3 + Board.get_speed_fish();

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    ///////////////////////////////////
    // Method called every moment for a change, here for move
    //////////////////////////////////

    @Override
    public void update() {

        oppositeDirectionofTheRedFish();

        if (getPos_y() < pos_y_fishRed) {
            moveFish = getPos_y() + speedFish;
            setPos_y(moveFish);
        }
        if (getPos_x() < pos_x_fishRed) {
            moveFish = getPos_x() + speedFish;
            setPos_x(moveFish);
        }
        if (getPos_x() > pos_x_fishRed) {
            moveFish = getPos_x() - speedFish;
            setPos_x(moveFish);
        }
        if (getPos_y() > pos_y_fishRed) {
            moveFish = getPos_y() - speedFish;
            setPos_y(moveFish);
        }

    }

    private void oppositeDirectionofTheRedFish() {

        for (int i = 0; i < Board.get_listFish().size(); i++) {

            if (FishRed.class.getName() == Board.get_listFish().get(i).getClass().getName()) {

                pos_x_fishRed = Board.get_listFish().get(i).getPos_x();
                pos_y_fishRed = Board.get_listFish().get(i).getPos_y();

                if (getPos_x() <= pos_x_fishRed && getPos_x() <= pos_y_fishRed) {
                    pos_x_fishRed = 5; // 5 because 0 its the edge and we cant see the fish
                    pos_y_fishRed = 5;
                } else if (getPos_x() >= pos_x_fishRed && getPos_y() >= pos_y_fishRed) {
                    pos_x_fishRed = get_screen_W();
                    pos_y_fishRed = get_screen_H();
                } else if (getPos_x() <= pos_x_fishRed && getPos_y() >= pos_y_fishRed) {
                    pos_x_fishRed = 30;
                    pos_y_fishRed = get_screen_H();
                } else {
                    pos_x_fishRed = get_screen_W();
                    pos_y_fishRed = 30;
                }

            }

        }
    }

}