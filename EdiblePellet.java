import java.util.ArrayList;

public class EdiblePellet {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int endOfTheCounter = 0;
    private final int milisecond = 115;
    private final static int hitBoxPellet = 7;
    private static int counterToStopMoveFish = 0;
    private int pos_x_Pellet;
    private int pos_y_Pellet;

    private final static int idFishTouchPelletByDefault = -1;
    // by default is -1 because if no fish touch insect = no id Fish
    private static int idFishTouchedPellet = idFishTouchPelletByDefault;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public EdiblePellet() {
        positionRandomEdiblePellet();

    }

    ///////////////////////////////////
    // Get and Set used
    //////////////////////////////////

    public static int getIdFishTouchedPellet() {
        return idFishTouchedPellet;
    }

    public static int getIdfishtouchpelletbydefault() {
        return idFishTouchPelletByDefault;
    }

    public int getPos_x_pellet() {
        return pos_x_Pellet;
    }

    public int getPos_y_pellet() {
        return pos_y_Pellet;
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
    // milisecond its multiplicate by the number of the pellet in the listPellet
    // because its change when they are several pelet ( its for to have 10 second )
    // the method take the name of the fish whou touched the pellet
    // for know that fish will continue to move
    ///////////////////////////////////

    public void ediblePelletTouchedByAFish() {

        ArrayList<Fish> get_listFish = Board.get_listFish();
        for (int i = 0; i < get_listFish.size(); i++) {

            Fish fish = get_listFish.get(i);
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if ((pos_x_fish - hitBoxPellet <= pos_x_Pellet)
                    && (pos_x_fish + hitBoxPellet >= pos_x_Pellet)
                    && (pos_y_fish - hitBoxPellet <= pos_y_Pellet)
                    && (pos_y_fish + hitBoxPellet >= pos_y_Pellet)) {

                positionRandomEdiblePellet();
                counterToStopMoveFish = milisecond * Board.get_ediblePellet_list().size();
                // * the number of the pellet
                // because the counter decremente faster when there more pellet in the aquarium

                idFishTouchedPellet = fish.getIdFish();

            }

        }

        if (counterToStopMoveFish != endOfTheCounter) {
            counterToStopMoveFish--;
            System.out.println(counterToStopMoveFish);
        } else {
            idFishTouchedPellet = idFishTouchPelletByDefault;

        }
    }
}