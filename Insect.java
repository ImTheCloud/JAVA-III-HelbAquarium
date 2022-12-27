import java.util.ArrayList;

public class Insect {
    ///////////////////////////////////
    // The variables
    //////////////////////////////////
    private final int hitBoxInsect = 15;
    private final int numberOfInsect = 3;
    private int randomInsectTimmer = (int) (Math.random() * numberOfInsect);
    private final int insectNumberOne = 0;
    private final int insectNumberTwo = 1;
    private final int insectNumberThree = 2;

    private static int timmerSpeedInsect = 0;
    private String insecTimmerName;
    private int pos_x_insect;
    private int pos_y_insect;

    private final static int idFishTouchInsectByDefault = -1;
    // by default is -1 because if no fish touch insect = no id Fish
    private static int idFishTouchInsect = idFishTouchInsectByDefault;

    private int timmeLow = 100 * Board.get_insectList().size();
    private int timmeNormal = 200 * Board.get_insectList().size();
    private int timmeHight = 300 * Board.get_insectList().size();

    private final String insectTimeLow = "timmerLow";
    private final String insectTimeNormal = "timmerNormal";
    private final String insectTimeHight = "timmerHight";

    private final int endOfTheCounter = 0;

    ///////////////////////////////////
    // Constructor
    //////////////////////////////////

    public Insect() {
        positionRandomInsect();
    }

    ///////////////////////////////////
    // The Get for other class
    //////////////////////////////////

    public static int getIdFishTouchInsectByDefault() {
        return idFishTouchInsectByDefault;
    }

    public int getPos_x_insect() {
        return pos_x_insect;
    }

    public int getPos_y_insect() {
        return pos_y_insect;
    }

    public static int getIdFishTouchInsect() {
        return idFishTouchInsect;
    }

    ///////////////////////////////////
    // Method update called in Board for do something every x milisecond (timer)
    //////////////////////////////////

    public void update() {
        nameTimeSpeedUpgrade();
        insectTouchedbyAInsect();
    }

    ///////////////////////////////////
    // Method for different timer
    // when a fish take a insect his speed upgrade
    // if its the timmer low, the time of the speed will be low, etc...
    //////////////////////////////////

    public void nameTimeSpeedUpgrade() {
        if (randomInsectTimmer == insectNumberOne) {
            // its a random in 0,1,2 number of insect if the random its 0, the timmer will
            // be low, etc...
            insecTimmerName = insectTimeLow;
        } else if (randomInsectTimmer == insectNumberTwo) {
            insecTimmerName = insectTimeNormal;
        } else if (randomInsectTimmer == insectNumberThree) {
            insecTimmerName = insectTimeHight;
        }
    }

    ///////////////////////////////////
    // Method for put a insect in a random position at the beginning
    //////////////////////////////////

    public void positionRandomInsect() {
        pos_x_insect = (int) (Math.random() * Board.getB_WIDTH() - hitBoxInsect);
        pos_y_insect = (int) (Math.random() * Board.getB_HEIGHT() - hitBoxInsect);
        // - hitbox, if not its possible to see the insect halfway
        // if is appear at the limit of the screen
    }

    ///////////////////////////////////
    // If a fish touch a insect he eats it
    // and another insect appears in a random position
    // if the insect has the name "timmerHigh"
    // he will have the most time of the 3 time, etc...
    ///////////////////////////////////

    public void insectTouchedbyAInsect() {

        ArrayList<Fish> get_listFish = Board.get_listFish();

        for (int i = 0; i < get_listFish.size(); i++) {

            Fish fish = get_listFish.get(i);
            int pos_x_fish = fish.getPos_x_fish();
            int pos_y_fish = fish.getPos_y_fish();

            if ((getPos_x_insect() - hitBoxInsect <= pos_x_fish)
                    && (getPos_x_insect() + hitBoxInsect >= pos_x_fish)
                    && (getPos_y_insect() - hitBoxInsect <= pos_y_fish)
                    && (getPos_y_insect() + hitBoxInsect >= pos_y_fish)) {
                positionRandomInsect();

                if (insecTimmerName == insectTimeLow) {
                    timmerSpeedInsect = timmeLow;
                } else if (insecTimmerName == insectTimeNormal) {
                    timmerSpeedInsect = timmeNormal;
                } else if (insecTimmerName == insectTimeHight) {
                    timmerSpeedInsect = timmeHight;
                }
                idFishTouchInsect = fish.getIdFish();

            }

        }

        if (timmerSpeedInsect != endOfTheCounter) {
            timmerSpeedInsect--;
        } else {
            idFishTouchInsect = idFishTouchInsectByDefault;
        }

    }

}