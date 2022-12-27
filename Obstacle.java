import java.util.ArrayList;

public class Obstacle extends GameFixeElement {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxOBstacleWidth = 40; // / 20 H
    private final int hitBoxOBstacleHeight = 12; // / 20 H

    private final static int idFishTouchInsectByDefault = -1;
    // by default is -1 because if no fish touch insect = no id Fish
    private static int idFishTouchInsect = idFishTouchInsectByDefault;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Obstacle() {
        super.positionRandomElement();

    }

    ///////////////////////////////////
    // GET
    //////////////////////////////////

    public static int getIdFishTouchInsect() {
        return idFishTouchInsect;
    }

    public static void setIdFishTouchInsect(int idFishTouchInsect) {
        Obstacle.idFishTouchInsect = idFishTouchInsect;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        obstacleTouched();
    }

    ///////////////////////////////////
    // Method for the obstacle
    // when a obstacle is touched it bypasses it or for the orange take
    // an other random edge
    //////////////////////////////////
    public void obstacleTouched() {
        idFishTouchInsect = idFishTouchInsectByDefault;
        ArrayList<Fish> get_listFish = Board.get_listFish();
        for (int i = 0; i < get_listFish.size(); i++) {

            Fish fish = get_listFish.get(i);
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if ((getPos_x_element() - hitBoxOBstacleWidth <= pos_x_fish)
                    // for x its *2 hitbox bcs width its longer than height
                    && (getPos_x_element() + hitBoxOBstacleWidth >= pos_x_fish)
                    && (getPos_y_element() - hitBoxOBstacleHeight <= pos_y_fish)
                    && (getPos_y_element() + hitBoxOBstacleHeight >= pos_y_fish)) {
                idFishTouchInsect = fish.getIdFish();

            }
        }
    }

}