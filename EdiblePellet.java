import java.util.ArrayList;

public class EdiblePellet extends GameObjectElement {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////

    private final int timeFor10second = 160;
    private final static int hitBoxPellet = 15;
    private static int counterToStopMoveFish = 0;
    private static int idFishTouchPellet = getIdfishtouchelementbydefault();

    ///////////////////////////////////
    // Get
    //////////////////////////////////

    public EdiblePellet() {
        super.positionRandomElement();

    }

    public static int getIdFishTouchPellet() {
        return idFishTouchPellet;
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

            if ((pos_x_fish - hitBoxPellet <= getPos_x_element())
                    && (pos_x_fish + hitBoxPellet >= getPos_x_element())
                    && (pos_y_fish - hitBoxPellet <= getPos_y_element())
                    && (pos_y_fish + hitBoxPellet >= getPos_y_element())) {

                super.positionRandomElement();

                counterToStopMoveFish = timeFor10second * Board.get_ediblePellet_list().size();
                // * the number of the pellet
                // because the counter decremente faster when there more pellet in the aquarium

                idFishTouchPellet = fish.getIdFish();

            }

        }

        if (counterToStopMoveFish != getEndofthecounter()) {
            counterToStopMoveFish--;

        } else {
            idFishTouchPellet = getIdfishtouchelementbydefault();

        }
    }
}