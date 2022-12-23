public class EdiblePellet {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private final int milisecond = 100;
    private final static int hitBoxPellet = 7;
    private static int counterToStopMoveFish = 0;
    private static String nameFishTouchPellet;
    private int pos_x_Pellet;
    private int pos_y_Pellet;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public EdiblePellet() {
        positionRandomEdiblePellet();

    }

    ///////////////////////////////////
    // Get and Set used
    //////////////////////////////////

    public int getPos_x_pellet() {
        return pos_x_Pellet;
    }

    public int getPos_y_pellet() {
        return pos_y_Pellet;
    }

    static int get_counterToStopMoveFish() {
        return counterToStopMoveFish;
    }

    static String get_NameFishTouchPellet() { // see wich fish touched the pellet
        return nameFishTouchPellet;
    }

    public static void set_counterToStopMoveFish(int setCounterToStopMoveFish) {
        // counter -- for stop the fishes when a fish take a pellet
        counterToStopMoveFish = setCounterToStopMoveFish;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        ediblePelletTouchedByAFish();
    }

    ///////////////////////////////////
    // Method for put a Pellet in a random position ah the beginning
    //////////////////////////////////

    public void positionRandomEdiblePellet() {
        pos_x_Pellet = (int) (Math.random() * Board.getB_WIDTH() - hitBoxPellet);
        pos_y_Pellet = (int) (Math.random() * Board.getB_HEIGHT() - hitBoxPellet);
        // - hitbox, if not its possible to see the pellet halfway
        // if is appear at the limit of the screen
    }

    ///////////////////////////////////
    // If a fish touch a pellet he eats it and another pellet appears in a random
    // not for the fish black
    // a counter is put when a pellet is touched
    // milisecond its multiplicate by the number of the fish in the listFish because
    // its a change when they are several fish ( its for to have 10 second )
    // the method take the name of the fish whou touched the pellet
    // for know that fish will continue to move
    ///////////////////////////////////

    public void ediblePelletTouchedByAFish() {
        for (int i = 0; i < Board.get_listFish().size(); i++) {

            // first if its for the hitbox of the pellet
            if ((Board.get_listFish().get(i).getPos_x_fish() - hitBoxPellet <= getPos_x_pellet())
                    && (Board.get_listFish().get(i).getPos_x_fish() + hitBoxPellet >= getPos_x_pellet())
                    && (Board.get_listFish().get(i).getPos_y_fish() - hitBoxPellet <= getPos_y_pellet())
                    && (Board.get_listFish().get(i).getPos_y_fish() + hitBoxPellet >= getPos_y_pellet())) {
                positionRandomEdiblePellet();
                counterToStopMoveFish = milisecond * Board.get_listFish().size();
                // 10 second and * the number of the fish
                // because the counter decremente faster when there more fish in the aquarium

                nameFishTouchPellet = Board.get_listFish().get(i).getClass().getName();

            }

        }
    }

}