public class FishPurple extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int destination_pos_x;
    private static int destination_pos_y;
    private int moveFish;
    private int MoveFishEverymoment = 1;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishPurple() {
        super("Image/fishPurple.png");
    }

    ///////////////////////////////////
    // Method for a random Edge
    //////////////////////////////////

    public void random_nvl_position() {

        int numberEdgeExisting = 4;
        int randomEdge = (int) (Math.random() * numberEdgeExisting);

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

        // ArrayList<Fish> listFish = Board.get_listFish();
        // for (Fish fish : listFish) {

        // }

    }

    ///////////////////////////////////
    // Method called every moment for a chhange, here for move
    //////////////////////////////////

    @Override
    public void update() {

        // EdiblePellet.set_stop();

        // if (set_stop== 0) {
        // Fait avancer le poisson
        if (getPos_x() == destination_pos_x && getPos_y() == destination_pos_y) {
            random_nvl_position();
        }
        if (getPos_y() < destination_pos_y) {
            moveFish = getPos_y() + MoveFishEverymoment;
            setPos_y(moveFish);
        }
        if (getPos_x() < destination_pos_x) {
            moveFish = getPos_x() + MoveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_x() > destination_pos_x) {
            moveFish = getPos_x() - MoveFishEverymoment;
            setPos_x(moveFish);
        }
        if (getPos_y() > destination_pos_y) {
            moveFish = getPos_y() - MoveFishEverymoment;
            setPos_y(moveFish);
        }

        // } else {
        // set_stop--;
        // }

    }

}