public class FishOrange extends Fish {

    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private static int nvl_pos_x;
    private static int nvl_pos_y;
    private int new_pos;
    private int MoveFishEverymoment = 1;
    private static int[] tab = new int[2];

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public FishOrange() {
        super("Image/fishOrange.png");
        random_nvl_position();
    }

    ///////////////////////////////////
    // Method for a random Edge
    //////////////////////////////////

    public static int[] random_nvl_position() {

        int numberEdgeExisting = 4;
        int randomEdge = (int) (Math.random() * numberEdgeExisting);

        if (randomEdge == 0) {
            nvl_pos_x = 0;
            nvl_pos_y = (int) (Math.random() * screen_H);
        } else if (randomEdge == 1) {
            nvl_pos_x = screen_W;
            nvl_pos_y = (int) (Math.random() * screen_H);
        } else if (randomEdge == 2) {
            nvl_pos_y = 0;
            nvl_pos_x = (int) (Math.random() * screen_W);
        } else if (randomEdge == 3) {
            nvl_pos_y = screen_H;
            nvl_pos_x = (int) (Math.random() * screen_W);
        }

        tab[0] = nvl_pos_x;
        tab[1] = nvl_pos_y;

        return tab;

    }

    ///////////////////////////////////
    // the get/set
    //////////////////////////////////

    public static int[] get_randomNvlPosition() {
        return random_nvl_position();
    }

    ///////////////////////////////////
    // Method called every moment for a chhange, here for move
    //////////////////////////////////
    @Override
    public void update() {

        // EdiblePellet.set_stop();

        // if (set_stop== 0) {
        // Fait avancer le poisson
        if (getPos_x() < nvl_pos_x) {
            new_pos = getPos_x() + MoveFishEverymoment;
            setPos_x(new_pos);
        } else if (getPos_x() > nvl_pos_x) {
            new_pos = getPos_x() - MoveFishEverymoment;
            setPos_x(new_pos);
        } else if (getPos_y() > nvl_pos_y) {
            new_pos = getPos_y() - MoveFishEverymoment;
            setPos_y(new_pos);
        } else if (getPos_y() < nvl_pos_y) {
            new_pos = getPos_y() + MoveFishEverymoment;
            setPos_y(new_pos);
        } else if (getPos_x() == nvl_pos_x && getPos_y() == nvl_pos_y) {
            random_nvl_position();
        }
        // } else {
        // set_stop--;
        // }

    }

}
